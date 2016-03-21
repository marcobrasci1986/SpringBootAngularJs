package be.ordina.services;

import be.ordina.Application;
import be.ordina.domain.Item;
import be.ordina.repository.interfaces.ItemRepositoryInterface;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Integration test.
 *
 * Here you can inject services
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ItemServiceTest {

    @Autowired
    private ItemRepositoryInterface itemRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {
        List<Item> result = itemRepository.findAll();

        assertThat(result.size(), is(2));
    }

}