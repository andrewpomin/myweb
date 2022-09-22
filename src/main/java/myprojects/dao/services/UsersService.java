package myprojects.dao.services;

import myprojects.dao.entities.UsersDTO;

import java.util.List;

public interface UsersService {
    UsersDTO saveUser(UsersDTO usersDTO);

    UsersDTO updateUser(UsersDTO usersDTO);

    UsersDTO findByLogin(String email);

    List<UsersDTO> findAll();

    boolean isLogin(String sessionId);
}
