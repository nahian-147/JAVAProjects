import java.util.*;

public class CPUScheduler {

    public double roundRobin(ArrayList<Process> p, int slotLength){
        double awt;
        int time = 0;
        int twt = 0;
        Process runningProcess = null;
        ArrayList<Process> unhandledprocesses = new ArrayList<>();
        unhandledprocesses.addAll(p);
        unhandledprocesses.sort(new ArrivalTimeComparator());
        ArrayList<Process> arrivedProcesses = new ArrayList<>();
        ArrayList<Process> completedProcesses = new ArrayList<>();
        while(true){
            for(Process process : unhandledprocesses){
                if (process.getProcessArrivalTime() <= time){
                    if (!arrivedProcesses.contains(process)){
                        arrivedProcesses.add(process);
                    }
                }
            }
            if(unhandledprocesses.isEmpty()){
                break;
            }else if (!arrivedProcesses.isEmpty()){
                for (Process process : arrivedProcesses){
                    runningProcess = process;
                    if (!runningProcess.isStarted()){
                        runningProcess.setProcessStartupTime(time);
                        runningProcess.setStarted(true);
                    }
                    int timeSlot;
                    if (runningProcess.getProcessRemainingBurstTime() >= slotLength){
                        timeSlot = slotLength;
                    }else {
                        timeSlot = runningProcess.getProcessRemainingBurstTime();
                    }
                    for (int t=0;t<timeSlot;t++){
                        runningProcess.setProcessRemainingBurstTime(runningProcess.getProcessRemainingBurstTime()-1);
                        time++;
                    }
                }
                if (runningProcess.getProcessRemainingBurstTime() == 0){
                    runningProcess.setProcessCompletionTime(time);
                    runningProcess.setCompleted(true);
                    runningProcess.calculateWT();
                    completedProcesses.add(runningProcess);
                    arrivedProcesses.remove(runningProcess);
                    unhandledprocesses.remove(runningProcess);
                    twt += runningProcess.getProcessWaitingTime();
                    runningProcess.resetProcess();
                }
            }else{
                time++;
            }
        }
        awt = (double) twt/completedProcesses.size();
        return awt ;
    }
}
