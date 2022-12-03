import java.util.Comparator;

public class RemainingBurstTimeComparator implements Comparator<Process> {
    @Override
    public int compare(Process o1, Process o2) {
        return  o1.getProcessRemainingBurstTime() - o2.getProcessRemainingBurstTime();
    }
}
