package be.ordina.repository;

import be.ordina.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by MaBa on 15/03/2016.
 */
public interface ItemRepository extends JpaRepository<Item, Integer>{
}
