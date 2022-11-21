package com.bianchinijeovani.incomeandexpenses.services;

import com.bianchinijeovani.incomeandexpenses.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import static java.util.Collections.emptyList;

public class AuthenticationService {

    static final long EXPIRATIONTIME = 864_000_00;
    static final String SIGNINGKEY = "SecretKey";
    static final String PREFIX = "Bearer";

    static public void addToken(HttpServletResponse res, String username) {
        String JwtToke = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SIGNINGKEY)
                .compact();
        res.addHeader("Authorization", PREFIX + " " + JwtToke);
        res.addHeader("Access-Control-Expose_headers", "Authorization");
    }

    static public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null){
            String username = Jwts.parser()
                    .setSigningKey(SIGNINGKEY)
                    .parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody()
                    .getSubject();
            if (username != null)
                return new UsernamePasswordAuthenticationToken(username, null, emptyList());
        }
        return null;
    }


}
