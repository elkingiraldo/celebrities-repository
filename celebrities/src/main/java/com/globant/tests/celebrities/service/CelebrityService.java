package com.globant.tests.celebrities.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.tests.celebrities.model.entity.Person;
import com.globant.tests.celebrities.model.repository.IPersonRepository;
import com.globant.tests.celebrities.util.Constants;

/**
 * Service related with the celebrity search criteria but with an alternative
 * approach
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

		final List<Person> allPeople = personRepository.findAll();
		final int listSize = allPeople.size();

		if (listSize <= 1) {
			return Constants.MIN_TWO_PEOPLE_REQUIRED;
		}

		int left = 0;
		int right = listSize - 1;

		while (left < right) {
			if (knows(allPeople.get(left), allPeople.get(right))) {
				left++;
			} else {
				right--;
			}
		}

		final int celebrity = left;
		for (int i = 0; i < listSize; i++) {
			if (i != celebrity && (knows(allPeople.get(celebrity), allPeople.get(i))
					|| !knows(allPeople.get(i), allPeople.get(celebrity)))) {
				return Constants.CELEBRITY_NOT_FOUND;
			}
		}

		final Person celebrityFound = allPeople.get(celebrity);
		final String responseCelebrityFound = String.format(Constants.CELEBRITY_FOUND, celebrityFound.getId(),
				celebrityFound.getFirstName(), celebrityFound.getLastName());
		return responseCelebrityFound;

	}

	/**
	 * This method will take two PersonObject and it will response if the first
	 * person knows the second one
	 * 
	 * @param leftPerson, {@link Person} Person that we will ask for the other one
	 * @param rightPerson, {@link} Person that we want to know if the first one
	 *        knows
	 * @return boolean knowing if the person 1 knows person 2
	 */
	private boolean knows(final Person leftPerson, final Person rightPerson) {
		if (leftPerson.getKnownPeople().contains(new Long(rightPerson.getId()))) {
			return true;
		}
		return false;
	}

}
