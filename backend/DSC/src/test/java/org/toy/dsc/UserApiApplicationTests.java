package org.toy.dsc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.toy.dsc.dto.request.UserRegisterRequest;
import org.toy.dsc.service.UserService;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc // MockMVC를 주입받아 테스트에 사용할 수 있다.
@ExtendWith(SpringExtension.class) // SpringExtension 같은 확장 기틍을 지정해서 테스트할 수 있음
public class UserApiApplicationTests {
    @Autowired
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();// 직렬화할 ObjectMapper 사용
    ResultMatcher jsonPath;
    @Test
    public void testPostUser() throws Exception{

        // Test Register
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest("sample@naver.com","helloworld","wow");
        ResultActions registerResponse =  mockMvc.perform(post("/users/register")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(userRegisterRequest)))
                .andDo(print()); // 테스트 과정을 콘솔에 출력한다.
    }

    @Test
    public void testGetUser() throws Exception{
        // Sample data
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest("sample@naver.com","helloworld","wow");
        ResultActions registerResponse =  mockMvc.perform(post("/users/register")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(userRegisterRequest)))
                        .andDo(print());

        ResultActions responseExistedId = mockMvc.perform(get("/users/{id}", 1))
                .andDo(print());

    }
}
