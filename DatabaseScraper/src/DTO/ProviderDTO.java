package DTO;

//import login.LoginDTO;
import org.apache.commons.lang3.StringUtils;
//import user.UserDTO;
//import user.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class ProviderDTO {


    public static final int PROVIDER_TYPE_ORIGINATING = 1;
    public static final int PROVIDER_TYPE_TERMINATING = 2;
    public static final int PROVIDER_TYPE_RESELLER = 3;

    public static final int DELIVERY_TYPE_GET = 0;
    public static final int DELIVERY_TYPE_POST = 1;

    public static final int BILL_ON_ATTEMPT = 1;
    public static final int BILL_ON_SUBMIT = 2;
    public static final int BILL_ON_DELIVERY = 3;

    public static final short DAILY = 1;
    public static final short WEEKLY = 0;
    public static final short MONTHLY = 3;
    public static final short CUSTOM = 4;

    public final int passwordExpirationType=3;

    private long providerID;
    private String providerName;
    private String billingPassword;
    private String description;
    private String otpSerial;
    public int providerType;
    public String providerClientType;
    public String userName;
    public String password;
    public String apikey;
    public String secretkey;
    private double balance;
    private double creditLimit;
    private String balanceString;
    public String ipAddress;
    public String deliveryURLOrg;
    public String deliveryURL;
    public int deliveryMethod;
    public String requestUnicodeURL;
    public String requestAsciiURL;
    public String queryURL;
    public int portNumber;
    public int originatorTON;
    public int originatorNPI;
    public int destinationTON;
    public int destinationNPI;
    public long smsProviderRatePlanID;
    private String smsProviderRatePlanName;
    private long smsProviderRatePlanIDRegistered;
    private String smsProviderRatePlanNameRegistered;
    private int billingPolicy;
    private long parentID;
    private long accManagerID;
    private int roleID;
    public boolean encodingType;
    public boolean activationStatus;
    public String httpResponseText;
    private int tps;
    private long currencyID;

    private String[] loginIPList;
    private String contactNumber;

    public int associatedClientID;

//    private String[] dippingCountryIDList;
    private String dippingCountryIDListString;
    private ArrayList<Long> dippingCountryIDList;
    private ArrayList<HashMap<String,String>> dippingCountryIDMap;
    private boolean enableDipping=false;
    private boolean enableDippingCharge=false;

    private String whitelistCountryIDListString;
    private ArrayList<HashMap<String,String>> whitelistCountryIDMap;
    private boolean enableWhitelist=false;


    private boolean enableIPRestriction=false;
    private String restrictedIPListString;
    private String[] restrictedIPList;

    private long providerInfoID;
    private String contactName;
    private long birthDate;
    private String birthDateFormatted;
    private String designation;
    private String companyName;
    private String phoneNo;
    private String mobileNo;
    private String mail;
    private String address;
    private Long contactCountryID;
    private String contactCountryName;

    private String billingContactName;
    private String billingDesignation;
    private String billingPhoneNo;
    private String billingMail;
    private String billingAddress;


    private int m_invoiceDueDate;
    private int m_autoInvoiceActive;
    private int m_invoiceCycle;
    private int m_invoicePeriod;
    private int m_emailerActive;
    private int m_smsActive;
    ///
    private int m_daily;
    private int m_weekly;
    private int m_monthly;
    private int m_custom;

    public long getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(long currencyID) {
        this.currencyID = currencyID;
    }

    public int getTps() {
        return tps;
    }

    public void setTps(int tps) {
        this.tps = tps;
    }

    public String[] getRestrictedIPList() {
        return restrictedIPList;
    }

    public void setRestrictedIPList(String[] restrictedIPList) {
        this.restrictedIPList = restrictedIPList;
    }

    public boolean isEnableIPRestriction() {
        return enableIPRestriction;
    }

    public void setEnableIPRestriction(boolean enableIPRestriction) {
        this.enableIPRestriction = enableIPRestriction;
    }

    public String getRestrictedIPListString() {
        return restrictedIPListString;
    }

    public void setRestrictedIPListString(String restrictedIPListString) {
        this.restrictedIPListString = restrictedIPListString;
    }

    public String getWhitelistCountryIDListString() {
        return whitelistCountryIDListString;
    }

    public void setWhitelistCountryIDListString(String whitelistCountryIDListString) {
        this.whitelistCountryIDListString = whitelistCountryIDListString;
    }

    public ArrayList<HashMap<String, String>> getWhitelistCountryIDMap() {
        return whitelistCountryIDMap;
    }

    public void setWhitelistCountryIDMap(ArrayList<HashMap<String, String>> whitelistCountryIDMap) {
        this.whitelistCountryIDMap = whitelistCountryIDMap;
    }

    public boolean isEnableWhitelist() {
        return enableWhitelist;
    }

    public void setEnableWhitelist(boolean enableWhitelist) {
        this.enableWhitelist = enableWhitelist;
    }

    public int getDaily() {
        return m_daily;
    }

    public void setDaily(int p_daily) {
        m_daily = p_daily;
    }

    public int getWeekly() {
        return m_weekly;
    }

    public void setWeekly(int p_weekly) {
        m_weekly = p_weekly;
    }

    public int getMonthly() {
        return m_monthly;
    }

    public void setMonthly(int p_monthly) {
        m_monthly = p_monthly;
    }

    public int getCustom() {
        return m_custom;
    }

    public void setCustom(int m_custom) {
        this.m_custom = m_custom;
    }


    public int getInvoiceDueDate() {
        return m_invoiceDueDate;
    }

    public void setInvoiceDueDate(int p_invoiceDueDate) {
        m_invoiceDueDate = p_invoiceDueDate;
    }

    public int getAutoInvoiceActive() {
        return m_autoInvoiceActive;
    }

    public void setAutoInvoiceActive(int p_autoInvoiceActive) {
        m_autoInvoiceActive = p_autoInvoiceActive;
    }

    public int getInvoiceCycle() {
        return m_invoiceCycle;
    }

    public void setInvoiceCycle(int p_invoiceCycle) {
        m_invoiceCycle = p_invoiceCycle;
    }

    public int getInvoicePeriod() {
        return m_invoicePeriod;
    }

    public void setInvoicePeriod(int p_invoicePeriod) {
        m_invoicePeriod = p_invoicePeriod;
    }

    public int getEmailerActive() {
        return m_emailerActive;
    }

    public void setEmailerActive(int p_emailerActive) {
        m_emailerActive = p_emailerActive;
    }

    public int getSmsActive() {
        return m_smsActive;
    }

    public void setSmsActive(int p_smsActive) {
        m_smsActive = p_smsActive;
    }

    public ArrayList<HashMap<String, String>> getDippingCountryIDMap() {
        return dippingCountryIDMap;
    }

    public void setDippingCountryIDMap(ArrayList<HashMap<String, String>> dippingCountryIDMap) {
        this.dippingCountryIDMap = dippingCountryIDMap;
    }

    public String getDippingCountryIDListString() {
        return dippingCountryIDListString;
    }

    public void setDippingCountryIDListString(String dippingCountryIDListString) {
        this.dippingCountryIDListString = dippingCountryIDListString;
        this.setDippingCountryIDList(dippingCountryIDListString);
    }

    public ArrayList<Long> getDippingCountryIDList() {
        return dippingCountryIDList;
    }

    public void setDippingCountryIDList(String dippingCountryIDs) {
        this.dippingCountryIDList = new ArrayList<>();
        if(StringUtils.isNotBlank(dippingCountryIDs)){
            String[] countryIDs=dippingCountryIDs.split(",");
            for (int i = 0; i < countryIDs.length; i++){
                if(StringUtils.isNotBlank(countryIDs[i]))
                    dippingCountryIDList.add(Long.parseLong(countryIDs[i].trim()));
            }

        }

    }

    public long getProviderInfoID() {
        return providerInfoID;
    }

    public void setProviderInfoID(long providerInfoID) {
        this.providerInfoID = providerInfoID;
    }

    public Long getContactCountryID() {
        return contactCountryID;
    }

    public void setContactCountryID(Long contactCountryID) {
        this.contactCountryID = contactCountryID;
    }

    public boolean isEnableDipping() {
        return enableDipping;
    }

    public void setEnableDipping(boolean enableDipping) {
        this.enableDipping = enableDipping;
    }

    /*public String[] getDippingCountryIDList() {
        return dippingCountryIDList;
    }

    public void setDippingCountryIDList(String[] dippingCountryIDList) {
        this.dippingCountryIDList = dippingCountryIDList;
    }*/

    public boolean isEnableDippingCharge() {
        return enableDippingCharge;
    }

    public void setEnableDippingCharge(boolean enableDippingCharge) {
        this.enableDippingCharge = enableDippingCharge;
    }

    public int getAssociatedClientID() {
        return associatedClientID;
    }

    public void setAssociatedClientID(int associatedClientID) {
        this.associatedClientID = associatedClientID;
    }

    public int getPasswordExpirationType() {
        return passwordExpirationType;
    }

    public long getProviderID() {
        return providerID;
    }

    public void setProviderID(long providerID) {
        this.providerID = providerID;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getBillingPassword() {
        return billingPassword;
    }

    public void setBillingPassword(String billingPassword) {
        this.billingPassword = billingPassword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOtpSerial() {
        return otpSerial;
    }

    public void setOtpSerial(String otpSerial) {
        this.otpSerial = otpSerial;
    }

    public int getProviderType() {
        return providerType;
    }

    public void setProviderType(int providerType) {
        this.providerType = providerType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getSecretkey() {
        return secretkey;
    }

    public void setSecretkey(String secretkey) {
        this.secretkey = secretkey;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getBalanceString() {
        return balanceString;
    }

    public void setBalanceString(String balanceString) {
        this.balanceString = balanceString;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDeliveryURLOrg() {
        return deliveryURLOrg;
    }

    public void setDeliveryURLOrg(String deliveryURLOrg) {
        this.deliveryURLOrg = deliveryURLOrg;
    }

    public String getDeliveryURL() {
        return deliveryURL;
    }

    public void setDeliveryURL(String deliveryURL) {
        this.deliveryURL = deliveryURL;
    }

    public String getQueryURL() {
        return queryURL;
    }

    public void setQueryURL(String queryURL) {
        this.queryURL = queryURL;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    public int getOriginatorTON() {
        return originatorTON;
    }

    public void setOriginatorTON(int originatorTON) {
        this.originatorTON = originatorTON;
    }

    public int getOriginatorNPI() {
        return originatorNPI;
    }

    public void setOriginatorNPI(int originatorNPI) {
        this.originatorNPI = originatorNPI;
    }

    public int getDestinationTON() {
        return destinationTON;
    }

    public void setDestinationTON(int destinationTON) {
        this.destinationTON = destinationTON;
    }

    public int getDestinationNPI() {
        return destinationNPI;
    }

    public void setDestinationNPI(int destinationNPI) {
        this.destinationNPI = destinationNPI;
    }

    public long getSmsProviderRatePlanID() {
        return smsProviderRatePlanID;
    }

    public void setSmsProviderRatePlanID(long smsProviderRatePlanID) {
        this.smsProviderRatePlanID = smsProviderRatePlanID;
    }

    public String getSmsProviderRatePlanName() {
        return smsProviderRatePlanName;
    }

    public void setSmsProviderRatePlanName(String smsProviderRatePlanName) {
        this.smsProviderRatePlanName = smsProviderRatePlanName;
    }

    public long getSmsProviderRatePlanIDRegistered() {
        return smsProviderRatePlanIDRegistered;
    }

    public void setSmsProviderRatePlanIDRegistered(long smsProviderRatePlanIDRegistered) {
        this.smsProviderRatePlanIDRegistered = smsProviderRatePlanIDRegistered;
    }

    public String getSmsProviderRatePlanNameRegistered() {
        return smsProviderRatePlanNameRegistered;
    }

    public void setSmsProviderRatePlanNameRegistered(String smsProviderRatePlanNameRegistered) {
        this.smsProviderRatePlanNameRegistered = smsProviderRatePlanNameRegistered;
    }

    public long getParentID() {
        return parentID;
    }

    public void setParentID(long parentID) {
        this.parentID = parentID;
    }

//    public String getParentName(){
//        ProviderDTO providerDTO = ProviderRepository.getInstance().getSMSProviderDTOByID(this.parentID);
//        if(providerDTO != null){
//            return providerDTO.providerName;
//        }
//        return "";
//    }

    public long getAccManagerID() {
        return accManagerID;
    }

    public void setAccManagerID(long accManagerID) {
        this.accManagerID = accManagerID;
    }

//    public String getAccManagerName(){
//        UserDTO userDTO = UserRepository.getInstance().getUserByUserID(this.accManagerID);
//        if(userDTO != null){
//            return userDTO.getUsername();
//        }
//        return "";
//    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public boolean isEncodingType() {
        return encodingType;
    }

    public void setEncodingType(boolean encodingType) {
        this.encodingType = encodingType;
    }

    public boolean isActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(boolean activationStatus) {
        this.activationStatus = activationStatus;
    }

    public String getResponseText() {
        return httpResponseText;
    }

    public void setResponseText(String httpResponseText) {
        this.httpResponseText = httpResponseText;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String[] getLoginIPList() {
        return loginIPList;
    }

    public void setLoginIPList(String[] loginIPList) {
        this.loginIPList = loginIPList;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getRequestUnicodeURL() {
        return requestUnicodeURL;
    }

    public void setRequestUnicodeURL(String requestUnicodeURL) {
        this.requestUnicodeURL = requestUnicodeURL;
    }

    public String getRequestAsciiURL() {
        return requestAsciiURL;
    }

    public void setRequestAsciiURL(String requestAsciiURL) {
        this.requestAsciiURL = requestAsciiURL;
    }

    public int getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(int deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBillingContactName() {
        return billingContactName;
    }

    public void setBillingContactName(String billingContactName) {
        this.billingContactName = billingContactName;
    }

    public String getBirthDateFormatted() {
        return birthDateFormatted;
    }

    public void setBirthDateFormatted(String birthDateFormatted) {
        this.birthDateFormatted = birthDateFormatted;
    }

    public String getBillingDesignation() {
        return billingDesignation;
    }

    public void setBillingDesignation(String billingDesignation) {
        this.billingDesignation = billingDesignation;
    }

    public String getBillingPhoneNo() {
        return billingPhoneNo;
    }

    public void setBillingPhoneNo(String billingPhoneNo) {
        this.billingPhoneNo = billingPhoneNo;
    }

    public String getBillingMail() {
        return billingMail;
    }

    public void setBillingMail(String billingMail) {
        this.billingMail = billingMail;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getContactCountryName() {
        return contactCountryName;
    }

    public void setContactCountryName(String contactCountryName) {
        this.contactCountryName = contactCountryName;
    }

    public int getBillingPolicy() {
        return billingPolicy;
    }

    public void setBillingPolicy(int billingPolicy) {
        this.billingPolicy = billingPolicy;
    }

    public String getBillingPolicyName(){
        if(this.billingPolicy==BILL_ON_ATTEMPT) return "On Attempt";
        else if(this.billingPolicy==BILL_ON_SUBMIT) return "On Submit";
        else return "On Delivery";
    }

//    public String getProviderClientType(LoginDTO loginDTO) {
//        if (providerType == PROVIDER_TYPE_ORIGINATING) {
//            return "Originating";
//        }  else if(providerType == PROVIDER_TYPE_TERMINATING){
//            return "Terminating";
//        }else{
//            return "Reseller";
//        }
//    }

    public String getProviderClientType() {
        return providerClientType;
    }

    public void setProviderClientType() {
        if (providerType == PROVIDER_TYPE_ORIGINATING) {
            this.providerClientType= "Originating";
        }  else if(providerType == PROVIDER_TYPE_TERMINATING){
            this.providerClientType= "Terminating";
        }else{
            this.providerClientType= "Reseller";
        }
    }
}
