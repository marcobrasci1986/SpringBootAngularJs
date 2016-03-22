package be.ordina.repository;

import be.ordina.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MaBa on 15/03/2016.
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

    List<Item> findByDescriptionIgnoreCaseStartingWith(String value);
}
