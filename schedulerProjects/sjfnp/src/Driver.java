import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    public static void main(String args[]){


        ArrayList<Process> cpuProcesses = new ArrayList<>();
        CPUScheduler scheduler = new CPUScheduler();

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

        System.out.println(scheduler.shortestJobFirstNonPreemptive(cpuProcesses));

    }
}
