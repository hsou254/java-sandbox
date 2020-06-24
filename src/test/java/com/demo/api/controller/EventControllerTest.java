package com.demo.api.controller;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.ui.Model;

/**
 *
 * @author Hy
 */
public class EventControllerTest {
    
    public EventControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of home method, of class EventController.
     */
    @Test
    public void testHome() {
        System.out.println("home");
        Model model = null; // TODO
        EventController instance = new EventController();
        String expResult = ""; //TODO
        String result = instance.home(model);
        assertEquals(expResult, result);
    }

    /**
     * Test of results method, of class EventController.
     */
    @Test
    public void testResults() {
        System.out.println("results");
        String strOwner = "hsou254";
        String strReposname = "java-sandbox";
        String strSelectedEventType = "Create";
        
        Model model = null; //TODO
        EventController instance = new EventController();
        String expResult = ""; //TODO
        String result = instance.results(strOwner, strReposname, strSelectedEventType, model);
        assertEquals(expResult, result);
    }
    
}
