package org.toy.dsc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.toy.dsc.controller.PostController;
import org.toy.dsc.dto.request.CreatePostRequest;
import org.toy.dsc.dto.request.UserRegisterRequest;
import org.toy.dsc.entity.PostEntity;
import org.toy.dsc.entity.UserEntity;
import org.toy.dsc.repository.PostRepository;
import org.toy.dsc.repository.UserRepository;
import org.toy.dsc.service.PostService;
import org.toy.dsc.service.UserService;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc // MockMVC를 주입받아 테스트에 사용할 수 있다.
@ExtendWith(SpringExtension.class)
public class PostingApiTestController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();// 직렬화할 ObjectMapper 사용

    @Test
    public void SuccessPosting() throws Exception {
        // Given
        CreatePostRequest request = new CreatePostRequest(1L, "Sample4","Sample3");
//        String serializedRequest = objectMapper.writeValueAsString(userLoginRequest);
        // When
        ResultActions response = mockMvc.perform(post("/posts/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))) // 매개변수로.. (가독성)
                .andDo(print());

        // than
//                .andExpect(status().isOk()) // Response 200
//                .andExpect(jsonPath("$.title").value(request.getTitle())) // check title
//                .andExpect(jsonPath("$.content").value(request.getContent())) // check content
//                .andExpect(jsonPath("$.userId").value(request.getUserId())); // check username


        // Test db는 어떻게 setup하지?
    }


    // TODO : Fix Error
    @Test
    public void CreatePostInvalidUser() throws Exception {
        // UserLogin
        UserEntity user = userRepository.save(new UserEntity("test@email.com", "testEmail", "TestUsername"));

        CreatePostRequest request = new CreatePostRequest(user.getId(), "sampleTitle2","wowww");

        ResultActions response = mockMvc.perform(post("/posts/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isNotFound()); // Response 200
    }

}
