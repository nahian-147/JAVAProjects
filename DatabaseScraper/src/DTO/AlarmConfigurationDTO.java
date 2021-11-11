package DTO;

public class AlarmConfigurationDTO {
    private long id;
    private double configValue;
    private int configValue2;
    private long duration;

    public AlarmConfigurationDTO() {
        this.configValue = -1.0D;
        this.duration = -1L;
        this.configValue2 = -1;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long p_id) {
        this.id = p_id;
    }

    public double getConfigValue() {
        return this.configValue;
    }

    public void setConfigValue(double p_ConfigValue) {
        this.configValue = p_ConfigValue;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long p_duration) {
        this.duration = p_duration;
    }

    public int getConfigValue2() {
        return this.configValue2;
    }

    public void setConfigValue2(int configValue2) {
        this.configValue2 = configValue2;
    }
}

/*
 * Location:
 * F:\WholeSaleBilling\WholeSaleBilling_v001\WebContent\WEB-INF\classes\
 *
 * Qualified Name: alarmmanagement.AlarmConfigurationDTO
 *
 * JD-Core Version: 0.7.0.1
 *
 */