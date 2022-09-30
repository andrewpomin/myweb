package myprojects.controllers;

import lombok.AllArgsConstructor;
import myprojects.dao.services.DefaultUsersService;
import myprojects.dao.entities.UsersDTO;
import myprojects.models.UsersModels;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UsersController {
    private final DefaultUsersService defaultUsersService;
    private final UsersModels usersModels;

    @PostMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        usersModels.login(request, response);
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        usersModels.logout(request, response);
    }

    @PostMapping("/register")
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        usersModels.register(request, response);
    }

    @PostMapping("/researcher")
    public void registerRandom(HttpServletRequest request, HttpServletResponse response) throws IOException {
        usersModels.registerRandom(request, response);
    }
}
