package com.globant.tests.celebrities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.tests.celebrities.model.entity.Person;
import com.globant.tests.celebrities.model.repository.IPersonRepository;
import com.globant.tests.celebrities.util.Constants;

@Service
public class CelebrityService {

	@Autowired
	private IPersonRepository personRepository;

	public String findCelebrity() {

		final Person celebrity = personRepository.findByIsCelebrity(true);

		if (celebrity != null) {
			return String.format(Constants.CELEBRITY_FOUND, celebrity.getFirstName(), celebrity.getLastName());
		}

		return Constants.CELEBRITY_NOT_FOUND;
	}

}
