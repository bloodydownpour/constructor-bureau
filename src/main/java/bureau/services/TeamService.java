package bureau.services;

import bureau.domain.ProjectTeam;
import bureau.repository.TeamRepository;
import bureau.repository.TransactionManager;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TeamService extends BaseService {
    private TeamRepository teamRepository;


    public List<ProjectTeam> getAllTeams() throws SQLException {
        return teamRepository.findAll();
    }

    public Optional<ProjectTeam> getTeamById(Long id) throws SQLException {
        return teamRepository.findById(id);
    }

    public void createTeam(ProjectTeam team) throws SQLException {
        teamRepository.save(team);
    }

    public void deleteTeam(Long id) throws SQLException {
        teamRepository.deleteById(id);
    }

    public List<ProjectTeam> getTeamsByProjectId(Long projectId) throws SQLException {
        return teamRepository.findByProjectId(projectId);
    }

    public void setTeamRepository(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void setTransactionManager(TransactionManager transactionManagerInstance) {

    }
}
