package Lib.Core;

public class Account {
    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account() {
        this("", "");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean authenticate(String username, String password) {
        if (username.equals(this.username) && password.equals(this.password)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Username: " + username + "\nPassword: " + password;
    }
}
