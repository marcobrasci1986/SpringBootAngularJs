package be.ordina.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/secureUser")
public class SecureUserController {


    /**
     * Will throw 403 for all not Admin or User users
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole({'ROLE_ADMIN', 'ROLE_USER'})")
    public List<String> securedDataAdminUser() {
        List<String> securedStrings = new ArrayList<>();
        securedStrings.add("This is a secret message. Only for User and Admin Roles");
        return securedStrings;
    }

}
