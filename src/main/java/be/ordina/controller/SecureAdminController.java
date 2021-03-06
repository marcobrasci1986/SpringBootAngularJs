package be.ordina.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/secureAdmin")
public class SecureAdminController {


    /**
     * Will throw 403 for all not Admin users
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<String> securedDataAdmin() {
        List<String> securedStrings = new ArrayList<>();
        securedStrings.add("This is a secret message. Only for Admin Roles");
        return securedStrings;
    }

}
