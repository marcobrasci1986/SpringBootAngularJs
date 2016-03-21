package be.ordina.controller;

import be.ordina.Application;
import be.ordina.domain.Item;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by MaBa on 21/03/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
public class ShipwreckControllerTest {

    /**
     * Inject a property from application.properties
     */
    @Value("${base_url}")
    private String BASE_URL;


    @Test
    public void testList() throws Exception {

        RestTemplate testRestTemplate = new TestRestTemplate();
        Item[] response = testRestTemplate.getForObject(BASE_URL, Item[].class);


        assertEquals(2, response.length);


    }

    @Test
    public void testGet() throws Exception {
        RestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<Item> response = testRestTemplate.getForEntity(BASE_URL + "/1", Item.class);


        Item item = response.getBody();
        assertEquals(item.getDescription(), "My default description");
    }
}