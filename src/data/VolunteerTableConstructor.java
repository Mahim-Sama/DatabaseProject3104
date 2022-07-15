package data;

public class VolunteerTableConstructor {
    private int ID;
    private String vName;
    private String vOrg;
    private String vDesignation;
    private String vMail;
    private String vContact;
    private String vGender;
    private String vBloodGroup;

    public VolunteerTableConstructor() {
    }

    public VolunteerTableConstructor(int iD, String vName, String vOrg, String vDesignation, String vMail,String vContact,
     String vGender,  String vBloodGroup) {
        setID(iD);
        this.setvName(vName);
        this.setvOrgName(vOrg);
        this.setvDesignation(vDesignation);
        this.setvEmail(vMail);
        this.setvContact(vContact);
        this.setvGender(vGender);
        this.setvBloodGroup(vBloodGroup);
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
        return vMail;
    }

    public void setvEmail(String vMail) {
        this.vMail = vMail;
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
        return vOrg;
    }

    public void setvOrgName(String vOrg) {
        this.vOrg = vOrg;
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
