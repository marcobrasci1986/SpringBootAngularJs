package be.ordina.controller;

import be.ordina.domain.Shipwreck;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by MaBa on 18/03/16.
 */
@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {




    @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
    public List<Shipwreck> list() {
        return ShipwreckStub.list();
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.POST)
    public Shipwreck create(@RequestBody Shipwreck shipwreck) {
        return ShipwreckStub.create(shipwreck);
    }

    @RequestMapping(value = "shipwrecks", method = RequestMethod.PUT)
    public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
        return ShipwreckStub.update(id, shipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        ShipwreckStub.delete(id);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
    public Shipwreck get(@PathVariable Long id) {
        return ShipwreckStub.get(id);
    }
}
