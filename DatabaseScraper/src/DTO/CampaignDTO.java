package DTO;

//import .ProviderDTO;
//import .ProviderRepository;
//import .TimeConverter;

public class CampaignDTO {
    public static int CAMPAIGN_TYPE_GENERIC = 1;
    public static int CAMPAIGN_TYPE_DYNAMIC = 2;
    public static int CAMPAIGN_TYPE_REQUEST = 3;

    public static int CAMPAIGN_STATUS_PENDING = 1;
    public static int CAMPAIGN_STATUS_IN_PROGRESS = 2;
    public static int CAMPAIGN_STATUS_SUCCESSFUL = 3;
    public static int CAMPAIGN_STATUS_FAILED = 4;
    public static int CAMPAIGN_STATUS_REJECTED = -1;


    private long campaignID;
    private String campaignName;
    private String campaignDesc;
    private int campaignType;
    private int campaignStatus;
    private String senderID;
    private long orgProviderID;
    private long terProviderID;
    private String campaignContactSource;
    private String campaignText;
    private int totalContacts;
    private int totalProcessed;
    private int totalDelivered;
    private int totalFailed;
    private double totalBill;
    private long createdBy;
    private long creationTime;
    private long scheduledTime;
    private long completionTime;
    private int hideContacts;

    public long getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(long campaignID) {
        this.campaignID = campaignID;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getCampaignDesc() {
        return campaignDesc;
    }

    public void setCampaignDesc(String campaignDesc) {
        this.campaignDesc = campaignDesc;
    }

    public int getCampaignType() {
        return campaignType;
    }

    public void setCampaignType(int campaignType) {
        this.campaignType = campaignType;
    }

    public int getCampaignStatus() {
        return campaignStatus;
    }

    public void setCampaignStatus(int campaignStatus) {
        this.campaignStatus = campaignStatus;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public long getOrgProviderID() {
        return orgProviderID;
    }

    public void setOrgProviderID(long orgProviderID) {
        this.orgProviderID = orgProviderID;
    }

//    public String getOrgProviderName(){
//        ProviderDTO dto = ProviderRepository.getInstance().getSMSProviderDTOByID(this.orgProviderID);
//        if(dto!=null){
//            return dto.getProviderName();
//        }
//        return "";
//    }

    public long getTerProviderID() {
        return terProviderID;
    }

    public void setTerProviderID(long terProviderID) {
        this.terProviderID = terProviderID;
    }

//    public String getTerProviderName(){
//        ProviderDTO dto = ProviderRepository.getInstance().getSMSProviderDTOByID(this.terProviderID);
//        if(dto!=null){
//            return dto.getProviderName();
//        }
//        return "";
//    }

    public String getCampaignContactSource() {
        return campaignContactSource;
    }

    public void setCampaignContactSource(String campaignContactSource) {
        this.campaignContactSource = campaignContactSource;
    }

    public String getCampaignText() {
        return campaignText;
    }

    public void setCampaignText(String campaignText) {
        this.campaignText = campaignText;
    }

    public int getTotalContacts() {
        return totalContacts;
    }

    public void setTotalContacts(int totalContacts) {
        this.totalContacts = totalContacts;
    }

    public int getTotalProcessed() {
        return totalProcessed;
    }

    public void setTotalProcessed(int totalProcessed) {
        this.totalProcessed = totalProcessed;
    }

    public int getTotalDelivered() {
        return totalDelivered;
    }

    public void setTotalDelivered(int totalDelivered) {
        this.totalDelivered = totalDelivered;
    }

    public int getTotalFailed() {
        return totalFailed;
    }

    public void setTotalFailed(int totalFailed) {
        this.totalFailed = totalFailed;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public long getCreatedBy () {
        return createdBy;
    }

    public void setCreatedBy (long createdBy) {
        this.createdBy = createdBy;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public long getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(long scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

//    public String getScheduledTimeString(){
//        return TimeConverter.ConvertMilliSecondsToFormattedDate(this.scheduledTime, "dd-MM-yyyy HH:mm:ss");
//    }

    public long getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(long completionTime) {
        this.completionTime = completionTime;
    }

    public int getHideContacts() {
        return hideContacts;
    }

    public void setHideContacts(int hideContacts) {
        this.hideContacts = hideContacts;
    }
}
