package co.uco.bitacora.domain.jwt;

public class JwtResponse {
    private  String token;

    public String getToken() {
        return token;
    }

    public JwtResponse(String token) {
        this.token = token;
    }
}
