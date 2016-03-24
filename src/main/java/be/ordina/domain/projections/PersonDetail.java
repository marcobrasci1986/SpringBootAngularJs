package be.ordina.domain.projections;

import be.ordina.domain.Department;
import be.ordina.domain.Person;
import org.springframework.data.rest.core.config.Projection;

/**
 * Created by MaBa on 24/03/16.
 */
@Projection(name = "test", types = {Person.class})
public interface PersonDetail {

    String getFirstName();
    String getLastName();
    Department getDepartment();
}
