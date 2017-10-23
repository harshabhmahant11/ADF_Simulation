package com.accenture.adf.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.helper.FERSDataConnection;

/**
 * JUnit test case for VisitorDAO class for testing all repository methods to
 * call database sub-routines
 * 
 */
public class TestVisitorDAO {
	
	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet resultSet = null;
	
	
	
	private Visitor visitor;
	private VisitorDAO visitorDAO;
	private ArrayList<Event> registeredEvents;

	/**
	 * Setting up initial objects 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		visitor = new Visitor();
		visitorDAO = new VisitorDAO();
		registeredEvents = new ArrayList<Event>();
	}

	/**
	 * Deallocating objects after execution of every method
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		visitor=null;
		visitorDAO=null;
		registeredEvents=null;
	}

	/**
	 * Test case for method insertData
	 */
	@Test
	public void testInsertData() {
		/**
		 * @TODO: Create visitor object by setting appropriate values
		 * Call insertData method by passing this visitor object
		 * Search this new visitor object by calling searchUser method
		 * Assert the values of username*/		
		
		visitor.setUserName("jon");
		visitor.setFirstName("asA");
		visitor.setFirstName("asda");
		visitor.setPassword("xxxx");
		Visitor v1=new Visitor();
		boolean flag= false;
		
		try {
			flag=visitorDAO.insertData(visitor);
			v1=visitorDAO.searchUser("jon", "xxxx");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fail("runtime");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true,flag);
		assertEquals(visitor.getUserName(),v1.getUserName());
	
	}	


	/**
	 * Test case for method searchUser
	 */
	@Test
	public void testSearchUser() {
		/**
		 * @TODO: Call searchUser method for valid values of username
		 * and password and assert the value of username for the returned type of method
		 */		
	//	'1001','bsmith','password','Bob','Smith','bsmith@email.com','748937487'),
		
		
		visitor.setUserName("bsmith");
		
		Visitor v1 = null;
		try {
			v1 = visitorDAO.searchUser("bsmith", "password");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(visitor.getUserName(),v1.getUserName() );
		
		
		
		
		
		
		
	}

	/**
	 * Test case for method registerVisitorToEvent
	 */ 
	/* DONE BUT NEED TO CHECK WITH SIR*/

	@Test
	public void testRegisterVisitorToEvent() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to registerVisitorToEvent method
		 * and assert the value
		 */		
		try {
			visitor = visitorDAO.searchUser("npatel", "password");
			visitorDAO.registerVisitorToEvent(visitor, 1002);
			
			String qry = "SELECT COUNT(*) FROM EVENTSIGNUP WHERE EVENTID = ? AND VISITORID = ? ;";
			
			
			connection = FERSDataConnection.createConnection();
			statement = connection.prepareStatement(qry);
			statement.setInt(1, 1002);
			statement.setInt(2, visitor.getVisitorId());
			
			resultSet = statement.executeQuery();
			
			 resultSet.next();
			
			 int count = resultSet.getInt(1);
			 
			 
			 assertEquals(1, count);
			 
			 
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}	

	/**
	 * Test case for method registeredEvents
	 */
	@Test
	public void testRegisteredEvents() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to registeredEvents method
		 * and assert the value
		 */		
		
		try {
			visitor = visitorDAO.searchUser("bsmith", "password");
			
			registeredEvents = visitorDAO.registeredEvents(visitor);
			
			
			
			
			assertEquals(3, registeredEvents.size());
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	/**
	 * Test case for method updateVisitor
	 */
	@Test
	public void testUpdateVisitor() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Update the value in this visitor object
		 * Pass this visitor object to updateVisitor method
		 * and assert the value of changed value
		 */		
		
		try {
			visitor = visitorDAO.searchUser("bsmith", "password");
			visitor.setPassword("password");
			
			
			
			int status = visitorDAO.updateVisitor(visitor);
			
			assertEquals(1, status);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * Test case for method registeredEvents
	 */
	@Test
	public void testUnregisterEvent() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to unregisterEvent method
		 * and assert the value
		 */		
		//System.out.println("tests");
		
	int status=1;
		try {
			visitor = visitorDAO.searchUser("npatel", "password");
			try {
				visitorDAO.unregisterEvent(visitor,1002);
				String qry = "SELECT COUNT(*) AS EVENTCOUNT FROM EVENTSIGNUP WHERE EVENTID=1002 AND VISITORID=1001 ;";
				connection = FERSDataConnection.createConnection();
				statement = connection.prepareStatement(qry);
			
				resultSet= statement.executeQuery();
				resultSet.next();
				status=resultSet.getInt(1);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(0,status);
	}

}
