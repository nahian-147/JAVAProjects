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

    public double fcfs(ArrayList<ProcessDTO> p){
        ganttfcfs = new ArrayList<>();
        ArrayList<ProcessDTO> processes = new ArrayList<>();
        processes.addAll(p);
        int time = 0;
        int twt = 0;
        double awt;
        processes.sort(new ATComparator());
        for (ProcessDTO process : processes){
            process.setProcessST(time);
            ganttChartfcfs.put(process.getName(),new ArrayList<>());
            process.setProcessWT(time);
            ganttChartfcfs.get(process.getName()).add(process.getProcessST()+"");
            ganttfcfs.add(process.getName());
            process.setStarted(true);
            time += process.getProcessRBT();
            process.setCompleted(true);
            process.setProcessCT(time);
            process.calculateWT();
        }
        for (ProcessDTO process : processes){
            twt += process.getProcessWT();
        }
        awt = (double) twt/processes.size();
        return awt ;
    }

    public double sjfp(ArrayList<ProcessDTO> p){
        ganttsjfp = new ArrayList<>();
        ArrayList<ProcessDTO> unhandledProcesses = new ArrayList<>();
        unhandledProcesses.addAll(p);
        int time = 0;
        int twt = 0;
        ProcessDTO runningProcess;
        double awt;
        unhandledProcesses.sort(new ATComparator());
        ArrayList<ProcessDTO> arrivedProcesses = new ArrayList<>();
        ArrayList<ProcessDTO> completedProcesses = new ArrayList<>();
        while(true){
            for(ProcessDTO process : unhandledProcesses){
                if (!ganttChartsjfp.containsKey(process.getName())) ganttChartsjfp.put(process.getName(),new ArrayList<>());
                if (process.getProcessAT() == time){
                    arrivedProcesses.add(process);
                }
            }
            if(unhandledProcesses.isEmpty()){
                break;
            }else if (!arrivedProcesses.isEmpty()){
                arrivedProcesses.sort(new RBTComparator());
                runningProcess = arrivedProcesses.get(0);
                if (!runningProcess.isStarted()){
                    runningProcess.setProcessST(time);
                    runningProcess.setStarted(true);
                }
                ganttChartsjfp.get(runningProcess.getName()).add(time + "");
                ganttsjfp.add(runningProcess.getName());
                runningProcess.setProcessRBT(runningProcess.getProcessRBT()-1);
                time++;
                if (runningProcess.getProcessRBT() == 0){
                    runningProcess.setCompleted(true);
                    runningProcess.setProcessCT(time);
                    runningProcess.calculateWT();
                    twt += runningProcess.getProcessWT();
                    completedProcesses.add(runningProcess);
                    arrivedProcesses.remove(runningProcess);
                    unhandledProcesses.remove(runningProcess);
                    runningProcess.resetProcess();
                }
            }else{
                time++;
            }
        }
        for (ProcessDTO process : completedProcesses){
            twt += process.getProcessWT();
        }
        awt = (double) twt/completedProcesses.size();
        return awt ;
    }

    public double sjfnp(ArrayList<ProcessDTO> p){
        ganttsjfnp = new ArrayList<>();
        ArrayList<ProcessDTO> unhandledprocesses = new ArrayList<>();
        unhandledprocesses.addAll(p);
        int time = 0;
        int twt = 0;
        ProcessDTO runningProcess;
        double awt;
        unhandledprocesses.sort(new ATComparator());
        ArrayList<ProcessDTO> arrivedProcesses = new ArrayList<>();
        ArrayList<ProcessDTO> completedProcesses = new ArrayList<>();
        while(true){
            for(ProcessDTO process : unhandledprocesses){
                if (!ganttChartsjfnp.containsKey(process.getName())) ganttChartsjfnp.put(process.getName(),new ArrayList<>());
                if (process.getProcessAT() == time){
                    arrivedProcesses.add(process);
                }
            }
            if(unhandledprocesses.isEmpty()){
                break;
            }else if (!arrivedProcesses.isEmpty()){
                runningProcess = arrivedProcesses.get(0);
                if (!runningProcess.isStarted()){
                    runningProcess.setProcessST(time);
                    runningProcess.setStarted(true);
                }
                ganttChartsjfnp.get(runningProcess.getName()).add(time + "");
                ganttsjfnp.add(runningProcess.getName());
                runningProcess.setProcessRBT(runningProcess.getProcessRBT()-1);
                time++;

                if (runningProcess.getProcessRBT() == 0){
                    runningProcess.setProcessCT(time);
                    runningProcess.setCompleted(true);
                    runningProcess.calculateWT();
                    completedProcesses.add(runningProcess);
                    arrivedProcesses.remove(runningProcess);
                    unhandledprocesses.remove(runningProcess);
                    twt += runningProcess.getProcessWT();
                    runningProcess.resetProcess();
                    arrivedProcesses.sort(new RBTComparator());
                }
            }else{
                time++;
            }
        }
        awt = (double) twt/completedProcesses.size();
        return awt ;
    }

    public double roundrobin(ArrayList<ProcessDTO> p,int slotLength){
        double awt;
        int time = 0;
        int twt = 0;
        ProcessDTO runningProcess = null;
        ganttrr = new ArrayList<>();
        ArrayList<ProcessDTO> unhandledprocesses = new ArrayList<>();
        unhandledprocesses.addAll(p);
        unhandledprocesses.sort(new ATComparator());
        ArrayList<ProcessDTO> arrivedProcesses = new ArrayList<>();
        ArrayList<ProcessDTO> completedProcesses = new ArrayList<>();
        while(true){
            for(ProcessDTO process : unhandledprocesses){
                if (!ganttChartrr.containsKey(process.getName())) ganttChartrr.put(process.getName(),new ArrayList<>());
                if (process.getProcessAT() <= time){
                    if (!arrivedProcesses.contains(process)){
                        arrivedProcesses.add(process);
                    }
                }
            }
            if(unhandledprocesses.isEmpty()){
                break;
            }else if (!arrivedProcesses.isEmpty()){
                for (ProcessDTO process : arrivedProcesses){
                    runningProcess = process;
                    if (!runningProcess.isStarted()){
                        runningProcess.setProcessST(time);
                        runningProcess.setStarted(true);
                    }
                    int timeSlot;
                    if (runningProcess.getProcessRBT() >= slotLength){
                        timeSlot = slotLength;
                    }else {
                        timeSlot = runningProcess.getProcessRBT();
                    }
                    for (int t=0;t<timeSlot;t++){
                        ganttChartrr.get(runningProcess.getName()).add(time + "");
                        ganttrr.add(runningProcess.getName());
                        runningProcess.setProcessRBT(runningProcess.getProcessRBT()-1);
                        time++;
                    }
                }
                if (runningProcess.getProcessRBT() == 0){
                    runningProcess.setProcessCT(time);
                    runningProcess.setCompleted(true);
                    runningProcess.calculateWT();
                    completedProcesses.add(runningProcess);
                    arrivedProcesses.remove(runningProcess);
                    unhandledprocesses.remove(runningProcess);
                    twt += runningProcess.getProcessWT();
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
