package myprojects.dao.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsersDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private String sessionId;
    private long createTimeSession;
    private boolean isLogin;
}
