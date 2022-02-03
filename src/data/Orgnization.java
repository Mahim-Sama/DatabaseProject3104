package data;

public class Orgnization {
    private int OrgID;
    private String OrgName;
    private String OrgAddress;
    private String OrgPhone;
    private String OrgEmail;
    private String DonationType;
    
    public int getOrgID() {
        return OrgID;
    }

    public String getDonationType() {
        return DonationType;
    }

    public void setDonationType(String donationType) {
        this.DonationType = donationType;
    }

    public String getOrgEmail() {
        return OrgEmail;
    }

    public void setOrgEmail(String orgEmail) {
        this.OrgEmail = orgEmail;
    }

    public String getOrgPhone() {
        return OrgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.OrgPhone = orgPhone;
    }

    public String getOrgAddress() {
        return OrgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.OrgAddress = orgAddress;
    }

    public String getOrgName() {
        return OrgName;
    }

    public void setOrgName(String orgName) {
        this.OrgName = orgName;
    }

    public void setOrgID(int orgID) {
        this.OrgID = orgID;
    }

}
