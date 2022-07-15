package data;

public class Problem{
    private String problemStatus;
    private String problemType;   

    public Problem(String problemStatus, String problemType) {
        this.problemStatus = problemStatus;
        this.problemType = problemType;
    }
    public String getProblemType() {
        return problemType;
    }
    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }
    public String getProblemStatus() {
        return problemStatus;
    }
    public void setProblemStatus(String problemStatus) {
        this.problemStatus = problemStatus;
    }
}
