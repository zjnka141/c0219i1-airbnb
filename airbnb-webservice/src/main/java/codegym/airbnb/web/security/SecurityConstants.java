package codegym.airbnb.web.security;

public final class SecurityConstants {
    static final String SECRET_KEY="$MySecret123$";
    static final String TOKEN_PREFIX="Bearer ";
    static final String AUTH_HEADER="Authorization";
    static final long EXPIRATION_TIME=3600000; // 1 hour
}
