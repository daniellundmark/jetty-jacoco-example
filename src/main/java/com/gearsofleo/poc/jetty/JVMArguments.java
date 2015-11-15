package com.gearsofleo.poc.jetty;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

public class JVMArguments {

	public static List<String> getJVMArguments(){
		RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
		return runtimeMXBean.getInputArguments();
	}
	
}
