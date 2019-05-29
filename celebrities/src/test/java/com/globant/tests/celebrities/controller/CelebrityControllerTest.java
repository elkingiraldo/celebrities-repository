package com.globant.tests.celebrities.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.globant.tests.celebrities.service.CelebrityService;

public class CelebrityControllerTest {

	private static final String TEST_MESSAGE = "Test Message";

	@InjectMocks
	private CelebrityController celebrityController;

	@Mock
	private CelebrityService celebrityService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void messageNotAffected() {
		when(celebrityService.findCelebrity()).thenReturn(TEST_MESSAGE);
		final String msgToFront = celebrityController.getCelebrity();
		assertEquals(TEST_MESSAGE, msgToFront);
	}

	@Test
	public void onlyOneCallToCelebrityService() {
		celebrityController.getCelebrity();
		verify(celebrityService, times(1)).findCelebrity();
	}

}
