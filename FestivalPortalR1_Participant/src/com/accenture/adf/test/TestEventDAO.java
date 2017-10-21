package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.EventDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.exceptions.FERSGenericException;
import com.accenture.adf.helper.FERSDataConnection;

/**
 * Junit test class for EventDAO class
 *
 */
public class TestEventDAO {

	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet resultSet = null;
	private ArrayList<Event> showAllEvents;
	private EventDAO dao;	

	/**
	 * Sets up database connection before other methods are executed in this class
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpDatabaseConnection() throws Exception {
		connection = FERSDataConnection.createConnection();
	}

	/**
	 * Closes the database connection after all the methods are executed
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownDatabaseConnection() throws Exception {
		/**
		 * @TODO: Close connection object here  
		 */
	}

	/**
	 * Sets up the objects required in other methods
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		showAllEvents = new ArrayList<Event>();
		dao = new EventDAO();
	}

	/**
	 * Deallocate the resources after execution of method
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
	}

	/**
	 * Positive test case to test the method showAllEvents
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testShowAllEvents_Positive() throws ClassNotFoundException, SQLException {
		/**
		 * @TODO: Call showAllEvents method and assert it for
		 * size of returned type list
		 */	
		showAllEvents=dao.showAllEvents();
		assertEquals(true,showAllEvents.size()==3);
		
	}	

	/**
	 * Junit test case to test positive case for updateEventDeletions
	 */
	@Test	
	public void testUpdateEventDeletions_Positive() {
		/**
		 * @TODO: Find out seats available for an event by opening a connection
		 * and calling the query SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?
		 * Call the updateEventDeletions for eventId
		 * Again find out the seats available for this event
		 * testSeatsAvailableBefore should be 1 more then testSeatsAvailableAfter
		 */		
	}

	/**
	 * Negative test case for method updateEventDeletions
	 */
	@Test
	public void testUpdateEventDeletions_Negative() {
		/**
		 * @TODO: Call updateEventDeletions for incorrect eventid and it should
		 * throw an exception
		 */	
	}

	/**
	 * Positive test case for method updateEventNominations
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws FERSGenericException 
	 */
	@Test
	public void testUpdateEventNominations_Positive() throws ClassNotFoundException, SQLException, FERSGenericException {
		/**
		 * @TODO: Find out seats available for an event by opening a connection
		 * and calling the query SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?
		 * Call the updateEventNominations for eventId
		 * Again find out the seats available for this event
		 * testSeatsAvailableBefore should be 1 less then testSeatsAvailableAfter
		 */	
		
		int retVal;
		int retVal2;
		connection = FERSDataConnection.createConnection();
		statement = connection.prepareStatement("SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = 1001");
		resultSet =	statement.executeQuery();
		resultSet.next();
		retVal = resultSet.getInt("SEATSAVAILABLE");
		retVal--;
		
		dao.updateEventNominations(1001); 
		
		
		resultSet =	statement.executeQuery();
		resultSet.next();
		retVal2 = resultSet.getInt("SEATSAVAILABLE");
		
		assertEquals(retVal,retVal2 );
		
	}

	/**
	 * Negative test case for method updateEventNominations
	 */
	@Test
	public void testUpdateEventNominations_Negative() {
		/**
		 * @TODO: Call updateEventNominations for incorrect eventid and it should
		 * throw an exception
		 */	
	}

	/**
	 * Positive test case for method checkEventsofVisitor
	 */
	@Test
	public void testCheckEventsOfVisitor_Positive() {
		/**
		 * @TODO: Create visitor object by setting appropriate values
		 * Call checkEventsofVisitor method by passing this visitor object and
		 * valid eventId
		 * Assert the value of return type 
		 */		
	}

}
