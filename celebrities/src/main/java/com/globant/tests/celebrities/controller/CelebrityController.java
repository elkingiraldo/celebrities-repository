package com.globant.tests.celebrities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.tests.celebrities.service.CelebrityService;

@RestController(value = "/celebrity")
public class CelebrityController {

	@Autowired
	private CelebrityService celebrityService;

	@GetMapping
	public String getCelebrity() {
		return celebrityService.findCelebrity();
	}

}
