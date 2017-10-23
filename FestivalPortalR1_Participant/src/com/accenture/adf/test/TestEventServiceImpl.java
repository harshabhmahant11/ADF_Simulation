package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.businesstier.service.EventServiceImpl;

/**
 * Junit test case to test class EventServiceImpl
 *
 */
public class TestEventServiceImpl {

	private List<Event> eventList;	
	private Visitor visitor;
	private EventServiceImpl eventServiceImpl;

	/**
	 * Set up the objects required before execution of every method
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {		
		eventServiceImpl = new EventServiceImpl();
		visitor = new Visitor();
	}

	/**
	 * Deallocates the objects after execution of every method
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
		visitor=null;
		eventServiceImpl=null;
	}

	/**
	 * Test case to test the method getAllEvents
	 */
	@Test
	public void testGetAllEvents() {
		/**
		 * @TODO: Call getAllEvents method and assert it for the size of returned array
		 */		
		eventServiceImpl = new EventServiceImpl();
		eventList=eventServiceImpl.getAllEvents();
		assertEquals(3,eventList.size());
	}

	/**
	 * Test case to test the method checkEventsofVisitor
	 */
	@Test
	public void testCheckEventsofVisitor() {
		/**
		 * @TODO: Call checkEventsofVisitor and assert the returned type of this method
		 * for appropriate return type
		 */	
			Visitor visitor = new Visitor();
			visitor.setVisitorId(1002);
			assertTrue(eventServiceImpl.checkEventsofVisitor(visitor,1002));
		
	}

	/**
	 * Test case to test the method updateEventDeletions
	 */
	@Test
	public void testUpdateEventDeletions() {
		/**
		 * @TODO: Call updateEventDeletions and assert the return type of this method
		 */		
	}

}
