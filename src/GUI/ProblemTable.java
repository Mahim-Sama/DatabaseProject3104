package GUI;

public class ProblemTable {
    private int ID;
    private String victim; 
    private String problem;
    private String prbStatus;

    public ProblemTable(int iD, String victim, String problem, String prbStatus) {
        setID(iD);
        this.setVictim(victim);
        this.setProblem(problem);
        this.setPrbStatus(prbStatus);
    }

    public String getPrbStatus() {
        return prbStatus;
    }

    public void setPrbStatus(String prbStatus) {
        this.prbStatus = prbStatus;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getVictim() {
        return victim;
    }

    public void setVictim(String victim) {
        this.victim = victim;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        this.ID = iD;
    }

    public ProblemTable() {
    }
}
