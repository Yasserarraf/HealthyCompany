package com.fstt.healthycompany.security;

public interface SecurityParameters {
    public static final String JWT_HEADER_NAME = "Authorization";
    public static final String SECRET = "yasserarraf011@gmail.com";
    public static final long EXPIRATION = 10*24*3600;
    public static final String HEADER_PREFIX = "Bearer ";
}
