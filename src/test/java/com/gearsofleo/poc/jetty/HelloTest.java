package com.gearsofleo.poc.jetty;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloTest {

	@Test
	public void test_jvmArgs() {
		Assert.assertNotNull(JVMArguments.getJVMArguments());
	}
	
}
