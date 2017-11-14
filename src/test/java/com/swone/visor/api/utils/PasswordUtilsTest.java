package com.swone.visor.api.utils;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtilsTest {
	
	private static final String senha = "abc123";
	private final BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
	
	@Test
	public void testSenhaNula() {
		assertNull(PasswordUtils.gerarBCrypt(null));
	}
	
	@Test
	public void testGerarHashSenha() {
		String hash = PasswordUtils.gerarBCrypt(senha);
		
		assertTrue(bCryptEncoder.matches(senha, hash));
	}

}
