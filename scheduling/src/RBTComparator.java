import java.util.Comparator;

public class RBTComparator implements Comparator<ProcessDTO> {
    @Override
    public int compare(ProcessDTO o1, ProcessDTO o2) {
        return  o1.getProcessRBT() - o2.getProcessRBT();
    }
}
