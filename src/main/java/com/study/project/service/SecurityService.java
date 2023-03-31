package com.study.project.service;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class SecurityService {

	private static final String SECRET_KEY = "aarjjkjaskjdl1d4naskjkdakj25c0qw";

	// 토큰 생성
	public String createToken(String object) {
		long ttlMillis = 60 * 1000 * 60;
		// 토큰 서명을 위한 알고리즘
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
		Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());
		return Jwts.builder().setSubject(object).signWith(signatureAlgorithm, signingKey)
				.setExpiration(new Date(System.currentTimeMillis() + ttlMillis)).compact();
	}

	// 토큰 확인
	public String getSubject(String token) {
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
				.parseClaimsJws(token).getBody();
		return claims.getSubject();
	}
}
