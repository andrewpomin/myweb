package myprojects.dao.services;

import lombok.AllArgsConstructor;
import myprojects.dao.entities.Users;
import myprojects.dao.entities.UsersDTO;
import myprojects.dao.repositories.UsersRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@AllArgsConstructor
@Service
@Component
public class DefaultUsersService {
    private final UsersRepository usersRepository;
    private final UsersConverter usersConverter;

    private void validateUserDto(UsersDTO usersDto) {
        if (isNull(usersDto)) {
            System.out.println("Object user is null");
        }
        closePreviousSession(usersDto);
    }

    public boolean isLogin(String sessionId) {
        UsersDTO usersDTO = findBySessionId(sessionId);
        if (usersDTO != null) {
            return usersDTO.isLogin();
        }
        return false;
    }

    public void saveUser(UsersDTO usersDTO) {
        validateUserDto(usersDTO);
        usersRepository.save(usersConverter.fromUsersDtoToUsers(usersDTO));
    }

    public void updateUser(UsersDTO usersDTO) {
        validateUserDto(usersDTO);
        Users user = usersRepository.findByEmail(usersDTO.getEmail());
        usersDTO = checkBeforeUpdate(user, usersDTO);
        Users updatedUser = usersRepository.save(usersConverter.fromUsersDtoToUsers(usersDTO));
        usersConverter.fromUsersToUsersDto(updatedUser);
    }

    public UsersDTO checkBeforeUpdate(Users user, UsersDTO usersDTO) {
        if (usersDTO.getId() == 0) usersDTO.setId(user.getId());
        if (usersDTO.getEmail() == null) usersDTO.setEmail(user.getEmail());
        if (usersDTO.getPassword() == null) usersDTO.setPassword(user.getPassword());
        if (usersDTO.getFirstName() == null) usersDTO.setFirstName(user.getFirstName());
        if (usersDTO.getLastName() == null) usersDTO.setLastName(user.getLastName());
        if (usersDTO.getPhone() == null) usersDTO.setPhone(user.getPhone());
        if (usersDTO.getSessionId() == null) usersDTO.setSessionId(user.getSessionId());
        if (usersDTO.getCreateTimeSession() == 0) usersDTO.setCreateTimeSession(user.getCreateTimeSession());
        return usersDTO;
    }

    public UsersDTO findByEmail(String email) {
        Users user = usersRepository.findByEmail(email);
        if (user != null) {
            return usersConverter.fromUsersToUsersDto(user);
        }
        return null;
    }

    public UsersDTO findBySessionId(String sessionId) {
        Users user = usersRepository.findBySessionId(sessionId);
        if (user != null) {
            return usersConverter.fromUsersToUsersDto(user);
        }
        return null;
    }

    public List<UsersDTO> findAll() {
        return usersRepository.findAll().stream().map(usersConverter::fromUsersToUsersDto).collect(Collectors.toList());
    }

    public void closePreviousSession(UsersDTO usersDTO) {
        List<UsersDTO> list = findAll();
        for (UsersDTO u : list) {
            if (u.getSessionId().equals(usersDTO.getSessionId())) {
                //close session
                Users user = usersRepository.findBySessionId(u.getSessionId());
                user.setSessionId("forceQuit");
                user.setLogin(false);
                UsersDTO usersDTOOld = usersConverter.fromUsersToUsersDto(user);
                updateUser(usersDTOOld);
                return;
            }
        }
    }
}
