package be.ordina.controller;

import be.ordina.domain.Item;
import be.ordina.repository.interfaces.ItemRepositoryInterface;
import be.ordina.services.ItemService;
import be.ordina.services.interfaces.ItemServiceInterface;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by MaBa on 21/03/16.
 */
public class ItemControllerTest {

    @InjectMocks
    private ItemController itemController;

    @Mock
    private ItemService itemService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testFindById() throws Exception {
        Item test = new Item(true, "test");
        when(itemService.findOne(1)).thenReturn(test);

        Item result = itemController.findById(1);

        assertThat(test, is(result));
        assertThat(test.getDescription(), is(test.getDescription()));

        verify(itemService).findOne(1);
    }
}