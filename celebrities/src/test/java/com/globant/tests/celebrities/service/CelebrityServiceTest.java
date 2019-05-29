package com.globant.tests.celebrities.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.globant.tests.celebrities.model.entity.Person;
import com.globant.tests.celebrities.model.repository.IPersonRepository;
import com.globant.tests.celebrities.util.Constants;

public class CelebrityServiceTest {

	@InjectMocks
	private CelebrityService celebrityService;

	@Mock
	private IPersonRepository personRepository;

	private final Person personOne = new Person();
	private final Person personTwo = new Person();
	private final Person personThree = new Person();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		personOne.setId(1L);
		personOne.setFirstName("First Name One");
		personOne.setLastName("Last Name One");
		final Set<Long> knownPeopleOne = new HashSet<Long>();
		knownPeopleOne.add(new Long(2L));
		knownPeopleOne.add(new Long(3L));
		personOne.setKnownPeople(knownPeopleOne);

		personTwo.setId(2L);
		personTwo.setFirstName("First Name Two");
		personTwo.setLastName("Last Name Two");

		personThree.setId(3L);
		personThree.setFirstName("First Name Three");
		personThree.setLastName("Last Name Three");
		final Set<Long> knownPeopleThree = new HashSet<Long>();
		knownPeopleThree.add(new Long(2L));
		personThree.setKnownPeople(knownPeopleThree);

	}

	@Test
	public void onlyOnePersonInTheTeam() {

		final List<Person> allPeople = new ArrayList<Person>();
		allPeople.add(personOne);
		when(personRepository.findAll()).thenReturn(allPeople);

		final String msg = celebrityService.findCelebrity();

		assertEquals(Constants.MIN_TWO_PEOPLE_REQUIRED, msg);
	}

	@Test
	public void celebrityFound() {

		final List<Person> allPeople = new ArrayList<Person>();
		allPeople.add(personOne);
		allPeople.add(personTwo);
		allPeople.add(personThree);
		when(personRepository.findAll()).thenReturn(allPeople);

		final String msg = celebrityService.findCelebrity();
		final String expectedMsg = String.format(Constants.CELEBRITY_FOUND, personTwo.getId(), personTwo.getFirstName(),
				personTwo.getLastName());

		assertEquals(expectedMsg, msg);
	}

	@Test
	public void celebrityNotFound() {

		final Set<Long> knownPeopleTwo = new HashSet<Long>();
		knownPeopleTwo.add(new Long(1L));
		personTwo.setKnownPeople(knownPeopleTwo);

		final List<Person> allPeople = new ArrayList<Person>();
		allPeople.add(personOne);
		allPeople.add(personThree);
		allPeople.add(personTwo);
		when(personRepository.findAll()).thenReturn(allPeople);

		final String msg = celebrityService.findCelebrity();

		assertEquals(Constants.CELEBRITY_NOT_FOUND, msg);
	}

}
