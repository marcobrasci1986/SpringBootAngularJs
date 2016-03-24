package be.ordina.domain;

import javax.persistence.*;

/**
 * Created by MaBa on 22/03/16.
 */
@NamedQueries(
        @NamedQuery(name = "Person.findAgeGreaterThan", query = "select p from Person p where p.age > :age")
)
@Entity
public class Person extends AbstractEntity{


    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private int age;

    /**
     * JoinColumn is on Employee
     */
    @ManyToOne
    private Department department;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
