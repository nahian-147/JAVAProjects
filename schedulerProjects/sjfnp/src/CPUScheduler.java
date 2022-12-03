import java.util.*;

public class CPUScheduler {

    public double shortestJobFirstNonPreemptive(ArrayList<Process> p){
        ArrayList<Process> unhandledprocesses = new ArrayList<>();
        unhandledprocesses.addAll(p);
        int time = 0;
        int twt = 0;
        Process runningProcess;
        double awt;
        unhandledprocesses.sort(new ArrivalTimeComparator());
        ArrayList<Process> arrivedProcesses = new ArrayList<>();
        ArrayList<Process> completedProcesses = new ArrayList<>();
        while(true){
            for(Process process : unhandledprocesses){
                if (process.getProcessArrivalTime() == time){
                    arrivedProcesses.add(process);
                }
            }
            if(unhandledprocesses.isEmpty()){
                break;
            }else if (!arrivedProcesses.isEmpty()){
                runningProcess = arrivedProcesses.get(0);
                if (!runningProcess.isStarted()){
                    runningProcess.setProcessStartupTime(time);
                    runningProcess.setStarted(true);
                }
                runningProcess.setProcessRemainingBurstTime(runningProcess.getProcessRemainingBurstTime()-1);
                time++;

                if (runningProcess.getProcessRemainingBurstTime() == 0){
                    runningProcess.setProcessCompletionTime(time);
                    runningProcess.setCompleted(true);
                    runningProcess.calculateWT();
                    completedProcesses.add(runningProcess);
                    arrivedProcesses.remove(runningProcess);
                    unhandledprocesses.remove(runningProcess);
                    twt += runningProcess.getProcessWaitingTime();
                    runningProcess.resetProcess();
                    arrivedProcesses.sort(new RemainingBurstTimeComparator());
                }
            }else{
                time++;
            }
        }
        awt = (double) twt/completedProcesses.size();
        return awt ;
    }

}
