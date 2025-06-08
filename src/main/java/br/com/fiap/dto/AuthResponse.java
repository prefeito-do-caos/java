package br.com.fiap.dto;

public class AuthResponse {

    private String accessToken;
    private String tokenType;
    private PublicUser user;

    public AuthResponse() {
        super();
    }

    public AuthResponse(String accessToken, String tokenType) {
        super();

        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public PublicUser getUser() {
        return user;
    }

    public void setUser(PublicUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", user=" + user +
                '}';
    }

}
