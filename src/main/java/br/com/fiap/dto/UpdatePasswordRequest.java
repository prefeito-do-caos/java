package br.com.fiap.dto;

public class UpdatePasswordRequest {

    private String password;
    private String newPassword;

    public UpdatePasswordRequest() {
        super();
    }

    public UpdatePasswordRequest(String password, String newPassword) {
        super();

        this.password = password;
        this.newPassword = newPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "UpdatePasswordRequest{" +
                "password='" + password + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }

}
