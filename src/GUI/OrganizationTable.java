package GUI;

public class OrganizationTable {
    private int ID;
    private String Name;
    private String Address;
    private String mail;
    private String Contact;
    private String donationType;

    public OrganizationTable() {
    }

    public OrganizationTable(int iD, String name, String address, String mail, String contact, String donationType) {
        setID(iD);
        setName(name);
        setAddress(address);
        this.setMail(mail);
        setContact(contact);
        this.setDonationType(donationType);
    }

    public String getDonationType() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        this.Contact = contact;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        this.ID = iD;
    }

    
}
