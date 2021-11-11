package sms.history;

public class HistoryDTO {
    int smsCount = 0;
    int successCount = 0;
    private long referenceID;
    private String messageID;
    private String reportID;
    private String sender;
    private long smsOrgAccountID;
    private String smsOrgName;
    private String receiver;
    private long smsTerAccountID;
    private String smsTerName;
    private String content;
    private String contentShort;
    private String password;
    private long requestTime;
    private String requestTimeStr;
    private long responseTime;
    private String responseTimeStr;
    private long futureSMStime;
    private int status;
    private String statusStr;
    private String originatorIP;
    private int port;
    private String operatorCode;
    private int editCount;
    private int totalSegment;
    private int totalSMSCount;
    private long parentReferenceID;
    private double smsCost;
    private long smsCostDeductedFrom;
    private long broadCastID;
    private String smsCountryID;
    private String destName;
    private int smsType;
    private String smsTypeInStr;
    private double smsTax;
    private double buyingPrice;
    private double sellingPrice;
    private double profit;

    private String countryID;
    private String countryName;
    private String operatorName;
    private double orgDippingCost;
    private double orgCostWithDippingCost;
    private double orgRate;
    private int segmentCount;
    private double terRate;
    private double terCost;
    private double resellerRate;
    private double resellerCost;
    private double dippingProviderCost;
    private double myCostWithDippingCost;
    private double margin;

    public double getOrgCostWithDippingCost() {
        return orgCostWithDippingCost;
    }

    public void setOrgCostWithDippingCost(double orgCostWithDippingCost) {
        this.orgCostWithDippingCost = orgCostWithDippingCost;
    }

    public double getMyCostWithDippingCost() {
        return myCostWithDippingCost;
    }

    public void setMyCostWithDippingCost(double myCostWithDippingCost) {
        this.myCostWithDippingCost = myCostWithDippingCost;
    }

    public String getContentShort() {
        return contentShort;
    }

    public void setContentShort(String contentShort) {
        this.contentShort = contentShort;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public int getTotalSMSCount() {
        return totalSMSCount;
    }

    public void setTotalSMSCount(int totalSMSCount) {
        this.totalSMSCount = totalSMSCount;
    }

    public int getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(int smsCount) {
        this.smsCount = smsCount;
    }

    public long getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(long referenceID) {
        this.referenceID = referenceID;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public long getSmsOrgAccountID() {
        return smsOrgAccountID;
    }

    public void setSmsOrgAccountID(long smsOrgAccountID) {
        this.smsOrgAccountID = smsOrgAccountID;
    }

    public String getSmsOrgName() {
        return smsOrgName;
    }

    public void setSmsOrgName(String smsOrgName) {
        this.smsOrgName = smsOrgName;
    }

    public long getSmsTerAccountID() {
        return smsTerAccountID;
    }

    public void setSmsTerAccountID(long smsTerAccountID) {
        this.smsTerAccountID = smsTerAccountID;
    }

    public String getSmsTerName() {
        return smsTerName;
    }

    public void setSmsTerName(String smsTerName) {
        this.smsTerName = smsTerName;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(long requestTime) {
        this.requestTime = requestTime;
    }

    public long getFutureSMStime() {
        return futureSMStime;
    }

    public void setFutureSMStime(long futureSMStime) {
        this.futureSMStime = futureSMStime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOriginatorIP() {
        return originatorIP;
    }

    public void setOriginatorIP(String originatorIP) {
        this.originatorIP = originatorIP;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public int getEditCount() {
        return editCount;
    }

    public void setEditCount(int editCount) {
        this.editCount = editCount;
    }

    public int getTotalSegment() {
        return totalSegment;
    }

    public void setTotalSegment(int totalSegment) {
        this.totalSegment = totalSegment;
    }

    public long getParentReferenceID() {
        return parentReferenceID;
    }

    public void setParentReferenceID(long parentReferenceID) {
        this.parentReferenceID = parentReferenceID;
    }

    public double getSmsCost() {
        return smsCost;
    }

    public void setSmsCost(double smsCost) {
        this.smsCost = smsCost;
    }

    public long getSmsCostDeductedFrom() {
        return smsCostDeductedFrom;
    }

    public void setSmsCostDeductedFrom(long smsCostDeductedFrom) {
        this.smsCostDeductedFrom = smsCostDeductedFrom;
    }

    public long getBroadCastID() {
        return broadCastID;
    }

    public void setBroadCastID(long broadCastID) {
        this.broadCastID = broadCastID;
    }

    public String getSmsCountryID() {
        return smsCountryID;
    }

    public void setSmsCountryID(String smsCountryID) {
        this.smsCountryID = smsCountryID;
    }

    public String getDestName() {
        return destName;
    }

    public void setDestName(String destName) {
        this.destName = destName;
    }

    public int getSmsType() {
        return smsType;
    }

    public void setSmsType(int smsType) {
        this.smsType = smsType;
    }

    public double getSmsTax() {
        return smsTax;
    }

    public void setSmsTax(double smsTax) {
        this.smsTax = smsTax;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public double getOrgDippingCost() {
        return orgDippingCost;
    }

    public void setOrgDippingCost(double orgDippingCost) {
        this.orgDippingCost = orgDippingCost;
    }

    public double getOrgRate() {
        return orgRate;
    }

    public void setOrgRate(double orgRate) {
        this.orgRate = orgRate;
    }

    public int getSegmentCount() {
        return segmentCount;
    }

    public void setSegmentCount(int segmentCount) {
        this.segmentCount = segmentCount;
    }

    public double getTerRate() {
        return terRate;
    }

    public void setTerRate(double terRate) {
        this.terRate = terRate;
    }

    public double getTerCost() {
        return terCost;
    }

    public void setTerCost(double terCost) {
        this.terCost = terCost;
    }

    public double getDippingProviderCost() {
        return dippingProviderCost;
    }

    public void setDippingProviderCost(double dippingProviderCost) {
        this.dippingProviderCost = dippingProviderCost;
    }

    public double getMargin() {
        return margin;
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }

    public String getReportID() {
        return reportID;
    }

    public void setReportID(String reportID) {
        this.reportID = reportID;
    }

    public String getSmsTypeInStr() {
        return smsTypeInStr;
    }

    public void setSmsTypeInStr(String smsTypeInStr) {
        this.smsTypeInStr = smsTypeInStr;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getRequestTimeStr() {
        return requestTimeStr;
    }

    public void setRequestTimeStr(String requestTimeStr) {
        this.requestTimeStr = requestTimeStr;
    }

    public String getResponseTimeStr() {
        return responseTimeStr;
    }

    public void setResponseTimeStr(String responseTimeStr) {
        this.responseTimeStr = responseTimeStr;
    }

    public double getResellerRate() {
        return resellerRate;
    }

    public void setResellerRate(double resellerRate) {
        this.resellerRate = resellerRate;
    }

    public double getResellerCost() {
        return resellerCost;
    }

    public void setResellerCost(double resellerCost) {
        this.resellerCost = resellerCost;
    }
}
