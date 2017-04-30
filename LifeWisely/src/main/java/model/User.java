package model;


import org.springframework.context.annotation.Role;

import java.util.Set;

public class User {
    private String username;
    private String password;
    
        public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
}