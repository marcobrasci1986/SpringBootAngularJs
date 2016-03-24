package be.ordina.repository;

import be.ordina.domain.Person;
import be.ordina.domain.projections.PersonDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Use the projection class by default.
 */
@Repository
@RepositoryRestResource(excerptProjection = PersonDetail.class)
@PreAuthorize("hasRole('ROLE_ADMIN')")
public interface PersonRepository extends JpaRepository<Person, Integer>{

    @Query("Select p from Person p where p.firstName = :firstName and p.lastName = :lastName and p.age = :age")
    List<Person> findByFirstLastAndAge(@Param("firstName") String firstName,@Param("lastName") String lastName, @Param("age") Integer age);

    List<Person> findAgeGreaterThan(@Param("age") Integer age);

}
