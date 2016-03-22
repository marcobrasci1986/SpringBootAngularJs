package be.ordina.repository;

import be.ordina.Application;
import be.ordina.domain.Person;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.List;

import static org.junit.Assert.assertEquals;

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
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    @DatabaseSetup("/META-INF/dbtest/person/persons.xml")
    public void testFindByFirstLastAndAge() throws Exception {
        List<Person> result = personRepository.findByFirstLastAndAge(33);

        assertEquals(1, result.size());

    }
}