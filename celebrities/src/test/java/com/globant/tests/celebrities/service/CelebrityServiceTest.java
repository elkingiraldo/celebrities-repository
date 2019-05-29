package com.globant.tests.celebrities.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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

	Person person = new Person();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		person.setId(1L);
		person.setFirstName("First Name");
		person.setLastName("Last Name");
		person.setCelebrity(true);
	}

	@Test
	public void celebretyNotFoundReturnCorrectMessage() {
		when(personRepository.findByIsCelebrity(true)).thenReturn(null);
		final String msg = celebrityService.findCelebrity();
		assertEquals(Constants.CELEBRITY_NOT_FOUND, msg);
	}

	@Test
	public void celebretyFoundReturnCorrectMessage() {
		when(personRepository.findByIsCelebrity(true)).thenReturn(person);
		final String msg = celebrityService.findCelebrity();
		assertEquals(String.format(Constants.CELEBRITY_FOUND, person.getId(), person.getFirstName(),
				person.getLastName(), person.isCelebrity()), msg);
	}

}
