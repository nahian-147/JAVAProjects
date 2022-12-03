public class Process {

    private final int processArrivalTime;
    private final int processBurstTime;
    private int processRemainingBurstTime;
    private int processCompletionTime;
    private int processWaitingTime;
    private int processStartupTime;
    private int processTurnoverTime;
    private final String processName;

    public String getProcessName() {
        return processName;
    }

    public int getProcessBurstTime() {
        return processBurstTime;
    }

    public int getProcessTurnoverTime() {
        return processTurnoverTime;
    }

    public void setProcessTurnoverTime(int processTurnoverTime) {
        this.processTurnoverTime = processTurnoverTime;
    }

    private boolean isCompleted = false;
    private boolean isStarted = false;

    public int getProcessArrivalTime() {
        return processArrivalTime;
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

    public int getProcessRemainingBurstTime() {
        return processRemainingBurstTime;
    }

    public void setProcessRemainingBurstTime(int processRemainingBurstTime) {
        this.processRemainingBurstTime = processRemainingBurstTime;
    }

    public int getProcessCompletionTime() {
        return processCompletionTime;
    }

    public void setProcessCompletionTime(int processCompletionTime) {
        this.processCompletionTime = processCompletionTime;
    }

    public int getProcessWaitingTime() {
        return processWaitingTime;
    }

    public void setProcessWaitingTime(int processWaitingTime) {
        this.processWaitingTime = processWaitingTime;
    }

    public int getProcessStartupTime() {
        return processStartupTime;
    }

    public void setProcessStartupTime(int processStartupTime) {
        this.processStartupTime = processStartupTime;
    }

    Process(int at, int bt, String processName){
        this.processArrivalTime = at;
        this.processBurstTime = bt;
        this.processRemainingBurstTime = bt;
        this.processName = processName;
    }

    void calculateWT(){
        this.calculateTT();
        this.processWaitingTime = this.processTurnoverTime - this.processBurstTime;
    }

    void calculateTT(){
        this.processTurnoverTime = this.processCompletionTime - this.processArrivalTime;
    }

    void resetProcess(){
        this.processRemainingBurstTime = this.processBurstTime;
        this.processCompletionTime = 0;
        this.processWaitingTime = 0;
        this.processStartupTime = 0;
        this.processTurnoverTime = 0;
        this.isCompleted = false;
        this.isStarted = false;
    }
}
