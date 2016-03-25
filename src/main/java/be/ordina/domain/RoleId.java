package be.ordina.domain;

import java.io.Serializable;

/**
 * Created by MaBa on 25/03/16.
 */
public class RoleId implements Serializable{

    private String username;
    private String role;


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
