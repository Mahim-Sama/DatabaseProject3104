package data;

public class personINFO {
    private int personID;

    private String personName;

    public personINFO(int personID, String personName) {
        this.personID = personID;
        this.personName = personName;
    }
    public void setID(int personID){
        personID = this.personID;
    }

    public void setName(String personName){
        personName = this.personName;
    }

    public int getID(){
        return personID;
    }

    public String getName(){
        return personName;
    }

    
}

