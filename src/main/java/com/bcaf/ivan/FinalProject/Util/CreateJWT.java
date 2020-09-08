package com.bcaf.ivan.FinalProject.Util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class CreateJWT {
    public String buildJWT(String id,String issuer,String subject,long tlMillis){
        SignatureAlgorithm signatureAlgorithm= SignatureAlgorithm.HS256;
        long nowMillis=System.currentTimeMillis();
        Date now = new Date(nowMillis);
        byte[] apiKeySecretBytes= DatatypeConverter.parseBase64Binary("e53062bedfee842f17ea60e10da1268e515ae54f7207daa501d6bd18263fbe2ec91ce12e52ef7e79573a4e7bc00450902f37c4ecc0299ed32e8223b9e1de3481");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm,signingKey);
        if(tlMillis>=0){
            long expMillis=nowMillis-tlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }
}
