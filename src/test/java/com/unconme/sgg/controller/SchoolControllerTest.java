package com.unconme.sgg.controller;

import com.unconme.sgg.SggApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;


/**
 * @author: Fuwei Feng
 * @version: 2020/8/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SggApplication.class)
@WebAppConfiguration
public class SchoolControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetSchoolDetail1() throws Exception {
        MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
        paramsMap.add("school_name", "哈佛大学");
        paramsMap.add("info_module", null);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/school")
                .params(paramsMap)
                .accept(MediaType.ALL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testGetSchoolDetail2() throws Exception {
        MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
        paramsMap.add("school_name", "哈佛大学");
        paramsMap.add("info_module", "schoolInfo");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/school")
                .params(paramsMap)
                .accept(MediaType.ALL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testGetSchoolMajor() throws Exception {
        MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
        paramsMap.add("school_name", "哈佛大学");
        paramsMap.add("major_name", null);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/school/major")
                .params(paramsMap)
                .accept(MediaType.ALL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testGetSchoolMajor2() throws Exception {
        MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
        paramsMap.add("school_name", "哈佛大学");
        paramsMap.add("major_name", "计算机科学");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/school/major")
                .params(paramsMap)
                .accept(MediaType.ALL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testGetSchoolList() throws Exception {
        MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
        paramsMap.add("list_name", null);
        paramsMap.add("page", "1");
        paramsMap.add("size", "2");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/school/list")
                .params(paramsMap)
                .accept(MediaType.ALL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testGetSchoolList2() throws Exception {
        MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
        paramsMap.add("list_name", "TimesRank");
        paramsMap.add("page", "1");
        paramsMap.add("size", "2");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/school/list")
                .params(paramsMap)
                .accept(MediaType.ALL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
