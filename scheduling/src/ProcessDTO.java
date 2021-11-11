public class ProcessDTO {

    private final int processAT; // Arrival Time
    private final int processBT; // Burst Time
    private int processRBT; // Remaining Burst Time
    private int processCT; // Completion Time
    private int processWT; // Waiting Time
    private int processST; // Starting Time
    private int processTT; // Turnaround Time
    private final String name;

    public String getName() {
        return name;
    }

    public int getProcessBT() {
        return processBT;
    }

    public int getProcessTT() {
        return processTT;
    }

    public void setProcessTT(int processTT) {
        this.processTT = processTT;
    }

    private boolean isCompleted = false;
    private boolean isStarted = false;

    public int getProcessAT() {
        return processAT;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public int getProcessRBT() {
        return processRBT;
    }

    public void setProcessRBT(int processRBT) {
        this.processRBT = processRBT;
    }

    public int getProcessCT() {
        return processCT;
    }

    public void setProcessCT(int processCT) {
        this.processCT = processCT;
    }

    public int getProcessWT() {
        return processWT;
    }

    public void setProcessWT(int processWT) {
        this.processWT = processWT;
    }

    public int getProcessST() {
        return processST;
    }

    public void setProcessST(int processST) {
        this.processST = processST;
    }

    ProcessDTO(int at, int bt, String name){
        this.processAT = at;
        this.processBT = bt;
        this.processRBT = bt;
        this.name = name;
    }

    void calculateWT(){
        this.calculateTT();
        this.processWT = this.processTT  - this.processBT;
    }

    void calculateTT(){
        this.processTT = this.processCT - this.processAT;
    }

    void resetProcess(){
        this.processRBT = this.processBT;
        this.processCT = 0;
        this.processWT = 0;
        this.processST = 0;
        this.processTT = 0;
        this.isCompleted = false;
        this.isStarted = false;
    }
}
