package com.globant.tests.celebrities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import com.globant.tests.celebrities.model.entity.Person;
import com.globant.tests.celebrities.model.repository.IPersonRepository;
import com.globant.tests.celebrities.util.Constants;

/**
 * Service related with the celebrity search criteria
 * 
 * @author elkin.giraldo
 *
 */
@Service
public class CelebrityService {

	@Autowired
	private IPersonRepository personRepository;

	/**
	 * This method will build the response to the client, knowing the information
	 * retrieved from the database.
	 * 
	 * @return String with the response handled
	 */
	public String findCelebrity() {

		String response = "";

		try {
			final Person celebrity = personRepository.findByIsCelebrity(true);

			if (celebrity != null) {
				response = String.format(Constants.CELEBRITY_FOUND, celebrity.getId(), celebrity.getFirstName(),
						celebrity.getLastName(), celebrity.isCelebrity());
			} else {
				response = Constants.CELEBRITY_NOT_FOUND;
			}

		} catch (final IncorrectResultSizeDataAccessException e) {
			return Constants.MORE_THAN_ONE_CELEBRITY;
		}

		return response;

	}

}
