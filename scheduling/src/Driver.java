import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    static Scanner scanner = new Scanner(System.in);

    static void addProcessTo(ArrayList<Process> processes, String name){
        String[] inp;
        System.out.println("Enter Arrival time and Bust times separated by a comma.");
        inp = scanner.next().split(",");
        int at,bt;
        at = new Integer(inp[0]);
        bt = new Integer(inp[1]);
        processes.add(new Process(at,bt, name));
    }
    public static void main(String args[]){

        int n,i=0;
        int slot;
        String name;

        ArrayList<Process> cpuProcesses = new ArrayList<>();
        CPUScheduler scheduler = new CPUScheduler();

        if (args.length == 0){

            System.out.println("How many Processes?");

            n = new Integer(scanner.next());

            for (i=0;i<n;i++){
                name = "p" + (i+1);
                addProcessTo(cpuProcesses,name);
            }
        }else if (args[0].substring(args[0].length()-3,args[0].length()).equals("csv")){
            File csvFile = new File(args[0]);
            try {
                Scanner scanner = new Scanner(csvFile);
                scanner.useDelimiter("\n");
                while (scanner.hasNext()){
                    name = "p" + ++i;
                    int at,bt;
                    String[] inp = scanner.next().split(",");
                    at = new Integer(inp[0]);
                    bt = new Integer(inp[1]);
                    cpuProcesses.add(new Process(at,bt, name));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            Process p1 = new Process(0,3,"p1");
            Process p2 = new Process(1,8,"p2");
            Process p3 = new Process(2,6,"p3");
            Process p4 = new Process(4,4,"p3");
            Process p5 = new Process(5,2,"p4");

            cpuProcesses.add(p1);
            cpuProcesses.add(p3);
            cpuProcesses.add(p4);
            cpuProcesses.add(p2);
            cpuProcesses.add(p5);
        }

        while (true){
            String response;
            System.out.println("Chose One from Bellow :");
            System.out.println("1.First Come First Served");
            System.out.println("2.Shortest Job First (Preemtive)");
            System.out.println("3.Shortest Job First (Non Preemtive)");
            System.out.println("4.Roundrobin");
            System.out.println("5.All");
            System.out.println("6.Exit");
            System.out.println(" ");
            response = scanner.next();
            ArrayList<Process> p = new ArrayList<>();
            p.addAll(cpuProcesses);
            switch (response){
                case "1":
                    System.out.println("First Come First Served Avrg Waiting Time = "+scheduler.firstComeFirstServed(p));
                    scheduler.printGantChart("fcfs");
                    break;
                case "2":
                    System.out.println("Shortest Job First (Preemtive) Avrg Waiting Time = "+scheduler.shortestJobFirstPreemptive(p));
                    scheduler.printGantChart("sjfp");
                    break;
                case "3":
                    System.out.println("Shortest Job First (Non Preemtive) Avrg Waiting Time = "+scheduler.shortestJobFirstNonPreemptive(p));
                    scheduler.printGantChart("sjfnp");
                    break;
                case "4":
                    System.out.println("Time Slot for each time sharing portions ?");
                    slot = new Integer(scanner.next());
                    System.out.println("Roundrobin Avrg Waiting Time = "+scheduler.roundRobin(p,slot));
                    scheduler.printGantChart("rr");
                    break;
                case "5":
                    System.out.println("Time Slot for each time sharing portions ?");
                    slot = new Integer(scanner.next());
                    System.out.println("First Come First Served Avrg Waiting Time = "+scheduler.firstComeFirstServed(p));
                    System.out.println("Shortest Job First (Preemtive) Avrg Waiting Time = "+scheduler.shortestJobFirstPreemptive(p));
                    System.out.println("Shortest Job First (Non Preemtive) Avrg Waiting Time = "+scheduler.shortestJobFirstNonPreemptive(p));
                    System.out.println("Roundrobin Avrg Waiting Time = "+scheduler.roundRobin(p,slot));
                    break;
                case "6":
                    break;
                default:
                    if (response.equalsIgnoreCase("exit")) break;
                    else continue;
            }
            if (response.equalsIgnoreCase("6") || response.equalsIgnoreCase("exit")) break;
        }
    }
}
