package myprojects.dao.services;

import myprojects.dao.entities.Users;
import myprojects.dao.entities.UsersDTO;
import org.springframework.stereotype.Component;

@Component
public class UsersConverter {
    public Users fromUsersDtoToUsers(UsersDTO usersDTO) {
        return Users.builder()
                .id(usersDTO.getId())
                .firstName(usersDTO.getFirstName())
                .lastName(usersDTO.getLastName())
                .phone(usersDTO.getPhone())
                .email(usersDTO.getEmail())
                .password(usersDTO.getPassword())
                .sessionId(usersDTO.getSessionId())
                .createTimeSession(usersDTO.getCreateTimeSession())
                .isLogin(usersDTO.isLogin())
                .build();
    }

    public UsersDTO fromUsersToUsersDto(Users users) {
        return UsersDTO.builder()
                .id(users.getId())
                .firstName(users.getFirstName())
                .lastName(users.getLastName())
                .phone(users.getPhone())
                .email(users.getEmail())
                .password(users.getPassword())
                .sessionId(users.getSessionId())
                .createTimeSession(users.getCreateTimeSession())
                .isLogin(users.isLogin())
                .build();
    }
}
