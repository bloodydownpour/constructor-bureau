package bureau.domain;

public class Project extends Entity {
    private String name;
    private String status;
    private int teamID;
    private int requestID;

    public Project(int id, String name, String status, int teamID, int requestID) {
        super(id);
        this.name = name;
        this.status = status;
        this.teamID = teamID;
        this.requestID = requestID;
    }
    public Project() {}

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }
}
