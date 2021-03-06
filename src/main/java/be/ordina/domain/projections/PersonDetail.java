package be.ordina.domain.projections;

import be.ordina.domain.Department;
import be.ordina.domain.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 * http://localhost:8080/api/persons?projection=test
 */
@Projection(name = "test", types = {Person.class})
public interface PersonDetail {

    String getFirstName();
    String getLastName();

    @Value("#{target.department.departmentName}")
    String getDepartmentName();

    @Value("#{target.firstName} - #{target.lastName}")
    String getFullName();
}
