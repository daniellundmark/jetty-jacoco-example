package com.gearsofleo.poc.jetty;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloIT {

	@Test
	public void test_HelloWorld() throws Exception {
		HttpGet get = new HttpGet("http://localhost:9090/jettyjacoco/hello");
		HttpClient client = HttpClientBuilder.create().build();
		
		ResponseHandler<String> responseHandler=new BasicResponseHandler();
		HttpResponse response = client.execute(get);
        String responseBody = responseHandler.handleResponse(response);

		System.err.println("Response is: "+responseBody);
		Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
	}
	
}
