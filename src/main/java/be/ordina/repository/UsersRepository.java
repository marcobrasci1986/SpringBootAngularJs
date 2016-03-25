package be.ordina.repository;

import be.ordina.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by MaBa on 15/03/2016.
 */
@Repository
public interface UsersRepository extends JpaRepository<UserInfo, String> {

}
