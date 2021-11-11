package DTO;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AlarmHistoryDTO {
    static Logger logger = Logger.getLogger(AlarmHistoryDTO.class);
    long hsAlarmGenerationTime;
    private long hsID;
    private int hsAlarmID;
    private String hsMailToList;
    private String hsMailContent;
    private String hsMailSubject;
    private String hsAlarmDetails;
    private String description;
    private double defaultVal;
    private int evtCount = 0;

    public int getEvtCount() {
        return evtCount;
    }

    public void setEvtCount(int evtCount) {
        this.evtCount = evtCount;
    }


    public String getStrTime() {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date(this.hsAlarmGenerationTime));
        return date;
    }

    public long getHsID() {
        return hsID;
    }

    public void setHsID(long hsID) {
        this.hsID = hsID;
    }

    public long getHsAlarmGenerationTime() {
        return hsAlarmGenerationTime;
    }

    public void setHsAlarmGenerationTime(long hsAlarmGenerationTime) {
        this.hsAlarmGenerationTime = hsAlarmGenerationTime;
    }

    public int getHsAlarmID() {
        return hsAlarmID;
    }

    public void setHsAlarmID(int hsAlarmID) {
        this.hsAlarmID = hsAlarmID;
    }

    public String getHsAlarmDetails() {
        return hsAlarmDetails;
    }

    public void setHsAlarmDetails(String hsAlarmDetails) {
        this.hsAlarmDetails = hsAlarmDetails;
        logger.debug("hsAlarmDetails : " + hsAlarmDetails);
        //int a = hsAlarmDetails.indexOf("|");
        if(hsAlarmDetails!=null) {
	        String[] tokenStrings = hsAlarmDetails.split("\\|");
	        logger.debug(tokenStrings.length + " " + tokenStrings[0]);
	        if (tokenStrings.length != 2) {
	            logger.debug("Error: not 2 tokens.");
	            return;
	        }
	        tokenStrings[0] = tokenStrings[0].split(":")[1];
	        if (NumberUtils.isCreatable(tokenStrings[0])) {
	            this.defaultVal = Float.parseFloat(tokenStrings[0]);
	        } else {
	            logger.debug("No Default value or NaN");
	        }
	        this.description = tokenStrings[1];
        }else
        	this.description = "";

    }

    public String getDescription() {
        return description;
    }

    public double getDefaultValue() {
        return defaultVal;
    }

    public String getHsMailSubject() {
        return this.hsMailSubject;
    }

    public void setHsMailSubject(String subject) {
        this.hsMailSubject = subject;
    }
    
    public String getHsMailToList() {
        return this.hsMailToList;
    }

    public void setHsMailToList(String toList) {
        this.hsMailToList = toList;
    }
    
    public String getHsMailContent() {
        return this.hsMailContent;
    }

    public void setHsMailContent(String mailContent) {
        this.hsMailContent = mailContent;
    }

}
