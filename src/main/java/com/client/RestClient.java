package com.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	// GET Method
	public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(url); // get REQUEST
		CloseableHttpResponse response = client.execute(get); // hit the GET URL
		
	//a.Status Code	
		int statuscode = response.getStatusLine().getStatusCode();
		System.out.println("Status Code Response ---> " + statuscode );
		
	//b. GET Json Response String
		String json = EntityUtils.toString(response.getEntity(), "UTF-8");
		JSONObject jsonResponse = new JSONObject(json);
		System.out.println("Response JSON from API ---> " + jsonResponse);

	//c. GET All Headers
		Header[] headers = response.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for (Header header : headers) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("Header Array -->" + allHeaders);
	}

}
