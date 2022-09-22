package myprojects.dao.repositories;

import myprojects.dao.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);

    Users findBySessionId(String sessionId);
}
