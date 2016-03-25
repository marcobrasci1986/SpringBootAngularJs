package be.ordina.authentication;

import be.ordina.domain.Role;
import be.ordina.domain.UserInfo;
import be.ordina.repository.RoleRepository;
import be.ordina.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MaBa on 25/03/16.
 *
 * Based on: http://www.concretepage.com/spring/spring-security/spring-mvc-security-jdbc-authentication-example-with-custom-userdetailsservice-and-database-tables-using-java-configuration
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // find user
        UserInfo userInfo = usersRepository.findOne(username);

        List<Role> roles = roleRepository.findByUsername(userInfo.getUsername());

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }


        UserDetails userDetails = new User(userInfo.getUsername(), userInfo.getPassword(), authorities);

        return userDetails;
    }
}
