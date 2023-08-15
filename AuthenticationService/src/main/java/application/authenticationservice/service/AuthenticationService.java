package application.authenticationservice.service;

import application.authenticationservice.mysqldb.MySqlDatabase;
import application.authenticationservice.mysqldb.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final MySqlDatabase mySqlDatabase;
    @Autowired
    public AuthenticationService(MySqlDatabase mySqlDatabase) {
        this.mySqlDatabase = mySqlDatabase;
    }
    public boolean authenticate(String username, String password) {
        User user = mySqlDatabase.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
