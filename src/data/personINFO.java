package data;

public class personINFO {
    private String personName;
    private String personFather;
    private String personMother;
    private String personAddress;
    private int personAge;
    private String Familymember;
    private String personGender;

    private int personID;

    public personINFO() {
    }
    
    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public personINFO(String personName, String personFather, String personMother, String personAddress, int personAge, String Familymember, String personGender) {
        this.personName = personName;
        this.personFather = personFather;
        this.personMother = personMother;
        this.personAddress = personAddress;
        this.personAge = personAge;
        this.Familymember = Familymember;
        this.personGender = personGender;
    }

    // public personINFO(String personFather, String personMother, String personAddress, String personAge,
    //         int familymember, String pGender) {
    //     this.setName(personName);
    //     this.personFather = personFather;
    //     this.setPersonMother(personMother);
    //     this.setPersonAddress(personAddress);
    //     this.setPersonAge(personAge);
    //     setFamilymember(familymember);
    //     this.setpGender(pGender);
    // }

    public String getpGender() {
        return personGender;
    }

    public void setpGender(String personGender) {
        this.personGender = personGender;
    }
    
    public String getFamilymember() {
        return Familymember;
    }

    public void setFamilymember(String familymember) {
        this.Familymember = familymember;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public String getPersonMother() {
        return personMother;
    }

    public void setPersonMother(String personMother) {
        this.personMother = personMother;
    }

    public String getPersonFather() {
        return personFather;
    }
    public void setPersonFather(String personFather) {
        this.personFather = personFather;
    }

    public void setName(String personName){
        personName = this.personName;
    }

    public String getName(){
        return personName;
    }

    
}

