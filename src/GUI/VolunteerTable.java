package GUI;

public class VolunteerTable {
    private int ID;
    private String vName;
    private String vOrgName;
    private String vDesignation;
    private String vContact;
    private String vEmail;
    private String vBloodGroup;
    private String vGender;

    public VolunteerTable() {
    }

    public VolunteerTable(int iD, String vName, String vOrgName, String vDesignation, String vContact, String vEmail,
            String vBloodGroup, String vGender) {
        setID(iD);
        this.setvName(vName);
        this.setvOrgName(vOrgName);
        this.setvDesignation(vDesignation);
        this.setvContact(vContact);
        this.setvEmail(vEmail);
        this.setvBloodGroup(vBloodGroup);
        this.setvGender(vGender);
    }

    public String getvGender() {
        return vGender;
    }

    public void setvGender(String vGender) {
        this.vGender = vGender;
    }

    public String getvBloodGroup() {
        return vBloodGroup;
    }

    public void setvBloodGroup(String vBloodGroup) {
        this.vBloodGroup = vBloodGroup;
    }

    public String getvEmail() {
        return vEmail;
    }

    public void setvEmail(String vEmail) {
        this.vEmail = vEmail;
    }

    public String getvContact() {
        return vContact;
    }

    public void setvContact(String vContact) {
        this.vContact = vContact;
    }

    public String getvDesignation() {
        return vDesignation;
    }

    public void setvDesignation(String vDesignation) {
        this.vDesignation = vDesignation;
    }

    public String getvOrgName() {
        return vOrgName;
    }

    public void setvOrgName(String vOrgName) {
        this.vOrgName = vOrgName;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        this.ID = iD;
    }

}
