package org.toy.dsc.domain;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private Long userId;
    private String email;
    private String username;
    private String password;
    private String createdDate;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}
