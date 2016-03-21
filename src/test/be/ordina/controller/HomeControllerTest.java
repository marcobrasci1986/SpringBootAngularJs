package be.ordina.controller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MaBa on 21/03/16.
 */
public class HomeControllerTest {

    private HomeController homeController;

    @Before
    public void setUp() throws Exception {
        homeController = new HomeController();
    }

    @Test
    public void testHome() throws Exception {
        String result = homeController.home();
        assertEquals("Das Boot, reporting for duty!", result);
    }
}