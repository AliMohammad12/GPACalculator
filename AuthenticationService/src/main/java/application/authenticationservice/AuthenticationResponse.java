package application.authenticationservice;

public class AuthenticationResponse {
    private boolean authenticated;
    public AuthenticationResponse(boolean authenticated) {
        this.authenticated = authenticated;
    }
    public AuthenticationResponse() {}
    public boolean isAuthenticated() {
        return authenticated;
    }
    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
