package com.utcn.se.project.decoder;

import com.utcn.se.project.dto.UserRole;
import org.json.JSONObject;

import java.util.Base64;

public class JWTDecoder {

    private static final String TOKEN_REGEX = "\\.";
    private static final String ROLE_NOT_FOUND_MESSAGE = "Role not found!";
    private static final String ROLE_TOKEN = "role";

    private static final Base64.Decoder decoder = Base64.getDecoder();

    public static UserRole getUserRoleFromToken(String token){
        String[] tokenParts = token.split(TOKEN_REGEX);
        String body = new String(decoder.decode(tokenParts[1]));
        JSONObject jsonObject = new JSONObject(body);
        try {
            return UserRole.valueOf(jsonObject.getString(ROLE_TOKEN));
        } catch (IllegalArgumentException exception) {
            return UserRole.valueOf("GUEST");
        }
    }
}
