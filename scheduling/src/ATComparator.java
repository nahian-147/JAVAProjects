import java.util.Comparator;

public class ATComparator implements Comparator<ProcessDTO> {
    @Override
    public int compare(ProcessDTO o1, ProcessDTO o2) {
        return  o1.getProcessAT() - o2.getProcessAT();
    }
}
