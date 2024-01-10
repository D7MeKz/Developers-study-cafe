package org.toy.dsc.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UserEntity extends BaseTimeEntity{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성 전략
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    public UserEntity(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
