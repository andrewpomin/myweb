package myprojects.controllers;

import lombok.AllArgsConstructor;
import myprojects.dao.services.DefaultUsersService;
import myprojects.dao.entities.UsersDTO;
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

    @PostMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (defaultUsersService.findByEmail(login) != null
                && defaultUsersService.findByEmail(login).getPassword().equals(password)) {
            String sessionId = request.getSession().getId();
            long createTime = request.getSession().getCreationTime();
            UsersDTO usersDTO = UsersDTO.builder()
                    .email(login)
                    .sessionId(sessionId)
                    .createTimeSession(createTime)
                    .isLogin(true)
                    .build();

            defaultUsersService.updateUser(usersDTO);
            response.sendRedirect(request.getContextPath() + "/");
        } else {
            response.sendRedirect(request.getContextPath() + "/login?error=1");
        }
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UsersDTO usersDTO = defaultUsersService.findBySessionId(request.getSession().getId());
        if (usersDTO != null) {
            usersDTO.setLogin(false);
            usersDTO.setSessionId("quit");
            defaultUsersService.updateUser(usersDTO);
        }
        response.sendRedirect(request.getContextPath() + "/choose");
    }

    @PostMapping("/register")
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        int age;
        if (request.getParameter("age") != null) age = Integer.parseInt(request.getParameter("age")); else age = 0;
        String phone = request.getParameter("phone");
        String sessionId = request.getSession().getId();
        long createTime = request.getSession().getCreationTime();

        if (defaultUsersService.findByEmail(email) != null) {
            response.sendRedirect(request.getContextPath() + "/signup?error=1");
        } else {
            UsersDTO usersDTO = UsersDTO.builder()
                    .email(email)
                    .firstName(firstName)
                    .lastName(lastname)
                    .phone(phone)
                    .password(password)
                    .sessionId(sessionId)
                    .createTimeSession(createTime)
                    .isLogin(true)
                    .build();
            defaultUsersService.saveUser(usersDTO);
            response.sendRedirect(request.getContextPath() + "/");
        }
    }

    @PostMapping("/researcher")
    public void registerRandom(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sessionId = request.getSession().getId();
        long createTime = request.getSession().getCreationTime();
        int random = (int) (Math.random() * 1000);
        UsersDTO usersDTO = UsersDTO.builder()
                .email("email" + random + "@email.com")
                .firstName("Researcher")
                .lastName("Researcher")
                .phone("+380123456789")
                .password("password")
                .sessionId(sessionId)
                .createTimeSession(createTime)
                .isLogin(true)
                .build();
        defaultUsersService.saveUser(usersDTO);
        response.sendRedirect(request.getContextPath() + "/");
    }
}
