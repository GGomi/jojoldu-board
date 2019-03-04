package com.essri.board.webservice.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class WebRestControllerTest {
    private TestRestTemplate restTemplate;

    @Test
    public void profile확인() {
        String profile = this.restTemplate.getForObject("/profile",String.class);
        assertThat(profile).isEqualTo("local");
    }


}
