package com.rafaur.gateway.gateway;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(controllers = ValidateParametersController.class)
public class ValidateParametersControllerTest {
//    @Autowired
//    private MockMvc mvc;

    @Test
    void whenPathVariableIsInvalid_thenReturnsStatus400() throws Exception {
//        mvc.perform(get("/validatePathVariable/3"))
//                .andExpect(status().isBadRequest());
    }

    @Test
    void whenRequestParameterIsInvalid_thenReturnsStatus400() throws Exception {
//        mvc.perform(get("/validateRequestParameter")
//                        .param("param", "3"))
//                .andExpect(status().isBadRequest());
    }
}
