package bureau.services;

import bureau.domain.Request;
import bureau.repository.RequestRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RequestService extends BaseService {
    private RequestRepository requestRepository;

    public void setRequestRepository(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public List<Request> getAllRequests() throws SQLException {
        return requestRepository.findAll();
    }

    public Optional<Request> getRequestById(Long id) throws SQLException {
        return requestRepository.findById(id);
    }
    public List<Request> getRequestsByClientId(Long id) throws SQLException {
        return requestRepository.findByClientId(id);
    }

    public List<Request> getPendingRequests() throws SQLException {
        return requestRepository.getPendingRequests();
    }

    public void acceptRequest(Long id) throws SQLException {
        requestRepository.acceptRequest(id);
    }
    public void createRequest(Request request) throws SQLException {
        requestRepository.save(request);
    }

    public void updateRequest(Request request) throws SQLException {
        requestRepository.save(request);
    }


    public void deleteRequest(Long id) throws SQLException {
        requestRepository.deleteById(id);
    }
}
