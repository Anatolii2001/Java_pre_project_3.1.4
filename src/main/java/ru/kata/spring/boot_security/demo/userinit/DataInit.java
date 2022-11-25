package ru.kata.spring.boot_security.demo.userinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInit {

    @Autowired
    private UserServiceImpl userService;

    @PostConstruct
    public void init() {
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");

        userService.addRole(role1);
        userService.addRole(role2);

        List<Role> roleAdmin = new ArrayList<>();
        List<Role> roleUser = new ArrayList<>();

        roleAdmin.add(role1);
        roleUser.add(role2);

        User user1 = new User("admin", "admin", "Moscow", "112", "admin@gmail.com", roleAdmin);
        User user2 = new User("user", "user", "New-York", "777", "user@gmail.com", roleUser);

        userService.add(user1);
        userService.add(user2);
    }
}
