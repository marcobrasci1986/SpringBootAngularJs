package be.ordina.repository;

import be.ordina.domain.Role;
import be.ordina.domain.RoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MaBa on 15/03/2016.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, RoleId> {


    List<Role> findByUsername(String username);

}
