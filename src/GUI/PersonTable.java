package GUI;

public class PersonTable {

    private int ID;
    private String name;
    private String FatherName;
    private String MotherName;
    private String Address;
    private int AGE;
    private String FamilyMember;
    private String Gender;
    private String BloodGroup;
    
    public PersonTable() {
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.BloodGroup = bloodGroup;
    }

    public PersonTable(int ID,String name, String fatherName, String motherName, String address, int aGE,
            String familyMember, String gender, String BloodGroup) {
        this.setID(ID);
        this.setName(name);
        setFatherName(fatherName);
        setMotherName(motherName);
        setAddress(address);
        setAGE(aGE);
        setFamilyMember(familyMember);
        setGender(gender);
        this.setBloodGroup(BloodGroup);
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public String getFamilyMember() {
        return FamilyMember;
    }

    public void setFamilyMember(String familyMember) {
        this.FamilyMember = familyMember;
    }

    public int getAGE() {
        return AGE;
    }

    public void setAGE(int aGE) {
        this.AGE = aGE;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getMotherName() {
        return MotherName;
    }

    public void setMotherName(String motherName) {
        this.MotherName = motherName;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        this.FatherName = fatherName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        this.ID = iD;
    }

    
}
