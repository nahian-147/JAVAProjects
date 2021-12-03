import java.util.*;

public class CPUScheduler {

    private HashMap<String,ArrayList<String>> ganttChartfcfs = new HashMap<>();
    private ArrayList<String> ganttfcfs;
    private HashMap<String,ArrayList<String>> ganttChartsjfp = new HashMap<>();
    private ArrayList<String> ganttsjfp;
    private HashMap<String,ArrayList<String>> ganttChartsjfnp = new HashMap<>();
    private ArrayList<String> ganttsjfnp;
    private HashMap<String,ArrayList<String>> ganttChartrr = new HashMap<>();
    private ArrayList<String> ganttrr;

    public double firstComeFirstServed(ArrayList<Process> p){
        ganttfcfs = new ArrayList<>();
        ArrayList<Process> processes = new ArrayList<>();
        processes.addAll(p);
        int time = 0;
        int twt = 0;
        double awt;
        processes.sort(new ArrivalTimeComparator());
        for (Process process : processes){
            process.setProcessStartupTime(time);
            ganttChartfcfs.put(process.getProcessName(),new ArrayList<>());
            process.setProcessWaitingTime(time);
            ganttChartfcfs.get(process.getProcessName()).add(process.getProcessStartupTime()+"");
            ganttfcfs.add(process.getProcessName());
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

    public double shortestJobFirstPreemptive(ArrayList<Process> p){
        ganttsjfp = new ArrayList<>();
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
                if (!ganttChartsjfp.containsKey(process.getProcessName())) ganttChartsjfp.put(process.getProcessName(),new ArrayList<>());
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
                ganttChartsjfp.get(runningProcess.getProcessName()).add(time + "");
                ganttsjfp.add(runningProcess.getProcessName());
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

    public double shortestJobFirstNonPreemptive(ArrayList<Process> p){
        ganttsjfnp = new ArrayList<>();
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
                if (!ganttChartsjfnp.containsKey(process.getProcessName())) ganttChartsjfnp.put(process.getProcessName(),new ArrayList<>());
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
                ganttChartsjfnp.get(runningProcess.getProcessName()).add(time + "");
                ganttsjfnp.add(runningProcess.getProcessName());
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

    public double roundRobin(ArrayList<Process> p, int slotLength){
        double awt;
        int time = 0;
        int twt = 0;
        Process runningProcess = null;
        ganttrr = new ArrayList<>();
        ArrayList<Process> unhandledprocesses = new ArrayList<>();
        unhandledprocesses.addAll(p);
        unhandledprocesses.sort(new ArrivalTimeComparator());
        ArrayList<Process> arrivedProcesses = new ArrayList<>();
        ArrayList<Process> completedProcesses = new ArrayList<>();
        while(true){
            for(Process process : unhandledprocesses){
                if (!ganttChartrr.containsKey(process.getProcessName())) ganttChartrr.put(process.getProcessName(),new ArrayList<>());
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
                        ganttChartrr.get(runningProcess.getProcessName()).add(time + "");
                        ganttrr.add(runningProcess.getProcessName());
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
    private void showGantChartmap(HashMap<String,ArrayList<String>> map){
        map.forEach(
                (key,value)-> System.out.println(key + " " + value));
    }
    private String prepareGantChart(ArrayList<String> list){
        String chart = "|" + list.get(0);

        for (int i=1;i<list.size();i++){
            if (list.get(i-1).equalsIgnoreCase(list.get(i))){
                chart += "--";
            }else{
                chart += "|" + list.get(i);
            }
        }
        chart += "|";
        return chart;
    }
    public void printGantChart(String alg){
        switch (alg){
            case "fcfs":
//                showGantChartmap(ganttChartfcfs);
                System.out.println(prepareGantChart(ganttfcfs));
                break;
            case "sjfp":
//                showGantChartmap(ganttChartsjfp);
                System.out.println(prepareGantChart(ganttsjfp));
                break;
            case "sjfnp":
//                showGantChartmap(ganttChartsjfnp);
                System.out.println(prepareGantChart(ganttsjfnp));
                break;
            case "rr":
//                showGantChartmap(ganttChartrr);
                System.out.println(prepareGantChart(ganttrr));
                break;
            default:
                System.out.println("Error!");
        }
    }
}
