package com.globant.tests.celebrities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.tests.celebrities.model.entity.Person;
import com.globant.tests.celebrities.model.repository.IPersonRepository;

@Service
public class CelebrityService {

	private static final String CELEBRITY_FOUND = "There is a celebrity in the team with the following information => Fist Name: %s, Last Name: %s";
	private static final String CELEBRITY_NOT_FOUND = "There isn't a celebrity in the team";

	@Autowired
	private IPersonRepository personRepository;

	public String findCelebrity() {

		final Person celebrity = personRepository.findByIsCelebrity(true);

		if (celebrity != null) {
			return String.format(CELEBRITY_FOUND, celebrity.getFirstName(), celebrity.getLastName());
		}

		return CELEBRITY_NOT_FOUND;
	}

}
