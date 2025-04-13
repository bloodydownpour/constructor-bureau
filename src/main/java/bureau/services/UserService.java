package bureau.services;


import bureau.domain.User;
import bureau.repository.RepositoryException;
import bureau.repository.UserRepository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public class UserService extends BaseService  {
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByLoginAndPassword(String login, String password) throws ServiceException {
        try {
            return userRepository.readByLoginAndPassword(login, sha512hash(password));
        } catch(RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    private static String sha512hash(String input) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            byte[] byteHash = messageDigest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder(byteHash.length >> 1);
            int n;
            char lChar, hChar;
            for(byte b : byteHash) {
                n = b & 0x0F;
                lChar = (char)(n < 10 ? '0' + n : 'a' + n - 10);
                n = (b & 0xF0) >> 4;
                hChar = (char)(n < 10 ? '0' + n : 'a' + n - 10);
                hexString.append(hChar).append(lChar);
            }
            return hexString.toString();
        } catch(NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
