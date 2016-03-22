package be.ordina.controller;

import be.ordina.Application;
import be.ordina.domain.Item;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

/**
 * Created by MaBa on 21/03/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("/META-INF/dbtest/initialData.xml")
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