package org.toy.dsc.mapper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.toy.dsc.domain.User;
import org.toy.dsc.entity.UserEntity;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
@NoArgsConstructor
public class UserMapper {

    public UserEntity UserToUserEntity(User user){
        return new UserEntity(
                user.getEmail(),
                user.getPassword(),
                user.getUsername());
    }

    public User UserEntityToUser(UserEntity userEntity){
        User user = new User(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"))
        );
        return user;
    }

}
