package org.toy.dsc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.toy.dsc.entity.UserEntity;
import org.toy.dsc.repository.UserRepository;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserTrackerSpringBootApplicationTest {
    
    @Autowired
    private UserRepository userRepository;

    @Test
    public void createUserTest(){
        UserEntity user = new UserEntity("helloworld@naver.com","hellopass","coder","2023-11-11");
        UserEntity savedUser = userRepository.save(user);
        System.out.println("Success User" + savedUser.toString());

    }
}
