package org.launchcode.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User {

    @NotBlank(message = "Username is Empty")
    @Size(min = 5, max = 15, message = "Username must be 5-15 characters")
    private String username;

    @Email
    private String email;

    @NotBlank(message = "Password is Empty")
    @Size(min = 6, message = "Password must be min 6 characters")
    private String password;

    @NotBlank(message = "Password doesn't match")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password, String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
        checkPassword();
    }

    public  String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword(){
        if(this.password != null && this.verifyPassword != null && !this.password.equals(this.verifyPassword)){
            this.verifyPassword = null;
        }
    }
}

