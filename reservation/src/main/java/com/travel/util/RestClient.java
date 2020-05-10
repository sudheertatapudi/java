package com.travel.util;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.travel.entity.Station;


public class RestClient {
	
	@Autowired	
	private static RestTemplate restTemplate;

	public static void main(String[] args) {
		
		String stations = restTemplate.getForObject("http://localhost:8080/stations/all", String.class);
		
		System.out.println(Arrays.asList(stations));
	}

}
