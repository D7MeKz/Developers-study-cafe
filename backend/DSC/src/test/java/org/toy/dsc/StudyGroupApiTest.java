package org.toy.dsc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.toy.dsc.dto.request.StudyGroupCreateRequest;
import org.toy.dsc.dto.response.GetStudyGroupResponse;
import org.toy.dsc.entity.StudyGroupEntity;
import org.toy.dsc.entity.UserEntity;
import org.toy.dsc.repository.StudyGroupRepository;
import org.toy.dsc.repository.UserRepository;
import org.toy.dsc.service.StudyGroupService;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class StudyGroupApiTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper; // For serialization

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudyGroupRepository studyGroupRepository;

    @Autowired
    private StudyGroupService studyGroupService;

    @DisplayName("Add study Group: 스터디 그룹 생성에 추가한다.")
    @Test
    public void createStudyGroup() throws Exception{
        // Given
        userRepository.save(new UserEntity("sample@naver.com","password","sampleUsername"));
        StudyGroupCreateRequest request = new StudyGroupCreateRequest("1","group1","hello world");

        // Object to Json
        final String requestBody = objectMapper.writeValueAsString(request);

        // when
        ResultActions result = mockMvc.perform(post("/v1/group/create")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody))
                .andDo(print());


        // then
        result.andExpect(status().isOk());

        // then
        List<StudyGroupEntity> studyGroup = studyGroupRepository.findAll();
        assertThat(studyGroup.size()).isEqualTo(1);
        assertThat(studyGroup.get(0).getName()).isEqualTo(request.getName());
    }

    @DisplayName("/v1/group/{id} : 올바른 스터디 그룹을 반환한다.")
    @Test
    public void getValidStudyGroup() throws Exception{
        studyGroupRepository.save(new StudyGroupEntity("sample","sample"));
        ResultActions result = mockMvc.perform(get("/v1/group/{id}",1L)).andDo(print())
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("sample"))
                .andExpect(jsonPath("$.description").value("sample"));

    }

    // 왜 안될까???
    @DisplayName("/v1/group/{id} : 올바르지 않는 스터디 그룹을 반환한다.")
    @Test
    public void getInvalidStudyGroup() throws Exception{
        studyGroupRepository.save(new StudyGroupEntity("sample","sample"));
        ResultActions result = mockMvc.perform(get("/v1/group/{id}",2L)).andDo(print())
                .andExpect(status().isNotFound())
                .andDo(print());
    }
}
