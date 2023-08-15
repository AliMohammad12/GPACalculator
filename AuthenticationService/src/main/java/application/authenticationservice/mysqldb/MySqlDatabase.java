package application.authenticationservice.mysqldb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MySqlDatabase {
    private final UserRepository userRepository;
    @Autowired
    public MySqlDatabase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
