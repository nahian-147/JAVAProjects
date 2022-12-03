import java.util.*;

public class CPUScheduler {

    public double firstComeFirstServed(ArrayList<Process> p){
        ArrayList<Process> processes = new ArrayList<>();
        processes.addAll(p);
        int time = 0;
        int twt = 0;
        double awt;
        processes.sort(new ArrivalTimeComparator());
        for (Process process : processes){
            process.setProcessStartupTime(time);
            process.setProcessWaitingTime(time);
            process.setStarted(true);
            time += process.getProcessRemainingBurstTime();
            process.setCompleted(true);
            process.setProcessCompletionTime(time);
            process.calculateWT();
        }
        for (Process process : processes){
            twt += process.getProcessWaitingTime();
        }
        awt = (double) twt/processes.size();
        return awt ;
    }
}
