package com.gus.carshop.security;

import com.gus.carshop.dto.TokenDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

	private static final String SECRET_KEY = "4A614E645267556B58703273357638782F413F4428472B4B6250655368566D59";

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);

	}

	public <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
		final Claims claims = extractAllClaims(token);
		return claimResolver.apply(claims);
	}

	public TokenDTO generateToken(UserDetails userDetails) {
		Date validity = new Date(System.currentTimeMillis() + 100 * 60 * 24 *100);

		Date now = new Date(System.currentTimeMillis());

		String accessToken = Jwts
			.builder()
			.setSubject(userDetails.getUsername())
			.setIssuedAt(now)
			.setExpiration(validity)
			.signWith(getSignInKey(), SignatureAlgorithm.HS256)
			.compact();

		return new TokenDTO(userDetails.getUsername(), true, now, validity, accessToken, null);

	}

	public boolean isTokenValid(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private boolean isTokenExpired(String token) {
		return extractClaim(token, Claims::getExpiration).before(new Date());
	}

	private Claims extractAllClaims(String token) {
		return Jwts
			.parserBuilder()
			.setSigningKey(getSignInKey())
			.build()
			.parseClaimsJws(token)
			.getBody();
	}

	private Key getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
