package io.github.andrepestana.chatroom.security;

public interface SecurityConstants {

	public static final String SECRET = "SECRET";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGNUP_API_URL = "/api/v1/users/sign-up";
    public static final String SIGNUP_PAGE_URL = "/sign-up.html";
    public static final String LOGIN_PAGE_URL = "/login.html";
    
}
