package be.ordina.repository;

import be.ordina.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MaBa on 22/03/16.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

    @Query("Select p from Person p where p.age = :age")
    List<Person> findByFirstLastAndAge(@Param("age") Integer age);
}
