package myprojects.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String password;

    @Column(name = "session_id")
    private String sessionId;

    @Column(name = "create_time_session")
    private long createTimeSession;

    @Column(name = "is_login")
    private boolean isLogin;
}
