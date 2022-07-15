package data;

public class Volunteer {
    
    private int volunteerID;
    private String volunteerName;
    private String volunteerDesignation;
    private String volunteerEmail;
    private String volunteerPhone;
    private String volunteerAddress;
    private String volunteerGender;
    private String volunteerBloodGroup;

    public Volunteer(int volunteerID, String volunteerName, String volunteerDesignation, String volunteerEmail,
            String volunteerPhone, String volunteerAddress, String volunteerGender, String volunteerBloodGroup) {
        this.volunteerID = volunteerID;
        this.volunteerName = volunteerName;
        this.volunteerDesignation = volunteerDesignation;
        this.volunteerEmail = volunteerEmail;
        this.volunteerPhone = volunteerPhone;
        this.volunteerAddress = volunteerAddress;
        this.volunteerGender = volunteerGender;
        this.volunteerBloodGroup = volunteerBloodGroup;
    }

    public int getVolunteerID() {
        return volunteerID;
    }

    public String getVolunteerBloodGroup() {
        return volunteerBloodGroup;
    }

    public void setVolunteerBloodGroup(String volunteerBloodGroup) {
        this.volunteerBloodGroup = volunteerBloodGroup;
    }

    public String getVolunteerGender() {
        return volunteerGender;
    }

    public void setVolunteerGender(String volunteerGender) {
        this.volunteerGender = volunteerGender;
    }

    public String getVolunteerAddress() {
        return volunteerAddress;
    }

    public void setVolunteerAddress(String volunteerAddress) {
        this.volunteerAddress = volunteerAddress;
    }

    public String getVolunteerPhone() {
        return volunteerPhone;
    }

    public void setVolunteerPhone(String volunteerPhone) {
        this.volunteerPhone = volunteerPhone;
    }

    public String getVolunteerEmail() {
        return volunteerEmail;
    }

    public void setVolunteerEmail(String volunteerEmail) {
        this.volunteerEmail = volunteerEmail;
    }

    public String getVolunteerDesignation() {
        return volunteerDesignation;
    }

    public void setVolunteerDesignation(String volunteerDesignation) {
        this.volunteerDesignation = volunteerDesignation;
    }

    public void setVolunteerID(int volunteerID) {
        this.volunteerID = volunteerID;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }
}
