package bureau.domain;

import org.eclipse.tags.shaded.org.apache.regexp.RE;

import java.util.Date;

public class Request extends Entity {
    private String title;
    private String description;
    private Date creationDate;
    private Date deadline;
    private String status;
    private int clientID;
    private int managerID;
    private int leadID;
    private int projectTeamID;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public int getLeadID() {
        return leadID;
    }

    public void setLeadID(int leadID) {
        this.leadID = leadID;
    }

    public int getProjectTeamID() {
        return projectTeamID;
    }

    public void setProjectTeamID(int projectTeamID) {
        this.projectTeamID = projectTeamID;
    }

    public Request(int id,
                   String title,
                   String description,
                   Date creationDate,
                   Date deadline,
                   String status,
                   int clientID,
                   int managerID,
                   int leadID,
                   int projectTeamID)
    {
        super(id);
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.deadline = deadline;
        this.status = status;
        this.clientID = clientID;
        this.managerID = managerID;
        this.leadID = leadID;
        this.projectTeamID = projectTeamID;
    }
    public Request() {
        super();
    }

        @Override
        public String toString() {
            return "Request{" +
                    "id=" + getId() +
                    "title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", creationDate=" + creationDate +
                    ", deadline=" + deadline +
                    ", status='" + status + '\'' +
                    ", clientID=" + clientID +
                    ", managerID=" + managerID +
                    ", leadID=" + leadID +
                    ", projectTeamID=" + projectTeamID +
                    '}';
        }
    }

