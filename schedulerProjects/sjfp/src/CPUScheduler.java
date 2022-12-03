import java.util.*;

public class CPUScheduler {

    public double shortestJobFirstPreemptive(ArrayList<Process> p){
        ArrayList<Process> unhandledProcesses = new ArrayList<>();
        unhandledProcesses.addAll(p);
        int time = 0;
        int twt = 0;
        Process runningProcess;
        double awt;
        unhandledProcesses.sort(new ArrivalTimeComparator());
        ArrayList<Process> arrivedProcesses = new ArrayList<>();
        ArrayList<Process> completedProcesses = new ArrayList<>();
        while(true){
            for(Process process : unhandledProcesses){
                if (process.getProcessArrivalTime() == time){
                    arrivedProcesses.add(process);
                }
            }
            if(unhandledProcesses.isEmpty()){
                break;
            }else if (!arrivedProcesses.isEmpty()){
                arrivedProcesses.sort(new RemainingBurstTimeComparator());
                runningProcess = arrivedProcesses.get(0);
                if (!runningProcess.isStarted()){
                    runningProcess.setProcessStartupTime(time);
                    runningProcess.setStarted(true);
                }
                runningProcess.setProcessRemainingBurstTime(runningProcess.getProcessRemainingBurstTime()-1);
                time++;
                if (runningProcess.getProcessRemainingBurstTime() == 0){
                    runningProcess.setCompleted(true);
                    runningProcess.setProcessCompletionTime(time);
                    runningProcess.calculateWT();
                    twt += runningProcess.getProcessWaitingTime();
                    completedProcesses.add(runningProcess);
                    arrivedProcesses.remove(runningProcess);
                    unhandledProcesses.remove(runningProcess);
                    runningProcess.resetProcess();
                }
            }else{
                time++;
            }
        }
        for (Process process : completedProcesses){
            twt += process.getProcessWaitingTime();
        }
        awt = (double) twt/completedProcesses.size();
        return awt ;
    }
}
