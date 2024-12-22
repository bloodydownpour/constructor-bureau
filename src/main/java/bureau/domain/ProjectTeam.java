package bureau.domain;

import java.util.ArrayList;

public class ProjectTeam extends Entity{
    private String name;
    private int leadID;
    private int projectID;
    private ArrayList<Integer> memberIDs;

    public ProjectTeam(int id, String name, int leadID, int projectID, ArrayList<Integer> memberIDs) {
        super(id);
        this.name = name;
        this.leadID = leadID;
        this.projectID = projectID;
        this.memberIDs = memberIDs;
    }
    public ProjectTeam() {}


    public ArrayList<Integer> getMemberIDs() {
        return memberIDs;
    }

    public void setMemberIDs(ArrayList<Integer> memberIDs) {
        this.memberIDs = memberIDs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeadID() {
        return leadID;
    }

    public void setLeadID(int leadID) {
        this.leadID = leadID;
    }
    public void addMember(int memberID) {
        this.memberIDs.add(memberID);
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }
}
