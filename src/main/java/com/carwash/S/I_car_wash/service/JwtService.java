package com.carwash.S.I_car_wash.service;

import com.carwash.S.I_car_wash.dto.UserDTO;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.util.*;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    public String generateToken(UserDTO userDTO){

        Map<String, Object>claims=new HashMap<>();
        claims.put("email",userDTO.getEmail());
        claims.put("role",userDTO.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDTO.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(getSignKey())
                .compact();
    }

    public SecretKey getSignKey(){
        byte[]key= Base64.getDecoder().decode(secretKey);
        return Keys.hmacShaKeyFor(key);
    }
}
