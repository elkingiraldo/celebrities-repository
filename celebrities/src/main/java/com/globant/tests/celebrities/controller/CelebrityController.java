package com.globant.tests.celebrities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.tests.celebrities.service.CelebrityService;

/**
 * Rest controller for getting information about people in the team
 * 
 * @author elkin.giraldo
 *
 */
@RestController
@RequestMapping("/celebrity")
public class CelebrityController {

	@Autowired
	private CelebrityService celebrityService;

	/**
	 * It allows us to get the information related with the celebrity in the team
	 * 
	 * @return String with the information of operation
	 */
	@GetMapping
	public String getCelebrity() {
		return celebrityService.findCelebrity();
	}

}
