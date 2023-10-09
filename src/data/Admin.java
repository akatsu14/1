package data;

import component.Role;

public class Admin extends User {

    private Role role = Role.ADMIN;

    public Admin(String username, String password) {
        super(username, password);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
