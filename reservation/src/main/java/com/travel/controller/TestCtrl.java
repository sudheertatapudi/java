package com.travel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCtrl {
	
	@RequestMapping("/test")
	public String test()
	{
		return "test";
	}

}
