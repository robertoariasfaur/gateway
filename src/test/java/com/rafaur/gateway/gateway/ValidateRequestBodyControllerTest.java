package com.rafaur.gateway.gateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.xmlunit.builder.Input;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest
        //(controllers = ValidateRequestBodyController.class)

public class ValidateRequestBodyControllerTest {
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;

    @Test
    void whenInputIsInvalid_thenReturnsStatus400() throws Exception {
//        Input input = invalidInput();
//        String body = objectMapper.writeValueAsString(input);
//
//        mvc.perform(post("/validateBody")
//                        .contentType("application/json")
//                        .content(body))
//                .andExpect(status().isBadRequest());
    }
}
