package com.oopsmails.simplemain;

//import org.junit.Test;

import org.gradle.internal.impldep.org.junit.Assert;
import org.junit.jupiter.api.Test;

class SimpleMainTest {
	@Test
	void verifyNoExceptionThrown() {
		String str = "Testing in SimpleMainTest";
		System.out.println(str);
		SimpleMain.main(new String[] {});
		Assert.assertNotNull(str);
	}
}
