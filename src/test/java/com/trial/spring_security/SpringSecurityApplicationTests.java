package com.trial.spring_security;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;

import com.trial.spring_security.util.PlaintTextPasswordEncoder;

@SpringBootTest
class SpringSecurityApplicationTests {

	@Autowired
	PlaintTextPasswordEncoder passwordEncoder;

	@Test
	@Order(1)
	void contextLoads() {
		String password = "thisispassword";
		String temp = passwordEncoder.encode(password);
		boolean result = passwordEncoder.matches(temp, password);
		assertEquals(password, temp);
		assertEquals(result, true);
		System.out.println(passwordEncoder.hashSHA512(password));
		System.out.println();
	}

	@Test
	@Order(2)
	void keyGenerator() {
		BytesKeyGenerator bytesKeyGenerator = KeyGenerators.secureRandom(16);
		byte[] key = bytesKeyGenerator.generateKey();
		int len = bytesKeyGenerator.getKeyLength();
		System.out.println("key length : " + len);
		System.out.println("key : " + key);
		System.out.println("array " + Arrays.toString(key));
	}

}
