package be.ordina.repository;

import be.ordina.Application;
import be.ordina.domain.Item;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import static org.assertj.core.api.Assertions.*;

import static org.junit.Assert.*;

/**
 * Created by MaBa on 22/03/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
public class ItemRepositoryInterfaceTest {

    @Autowired
    private ItemRepositoryInterface itemRepositoryInterface;

    @Test
    @DatabaseSetup("/META-INF/dbtest/findOne.xml")
    public void testFind() throws Exception {
        Item result = itemRepositoryInterface.findOne(1);

        assertNotNull(result);
        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getDescription()).isEqualTo("My default description");
    }

    @Test
    @DatabaseSetup("/META-INF/dbtest/findOne.xml")
    @ExpectedDatabase(value = "/META-INF/dbtest/insert.xml")
    public void testSave() throws Exception {
        itemRepositoryInterface.saveAndFlush(new Item(true, "Second item"));
    }
}