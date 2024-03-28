package com.example.forrelease;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class IntegrationTest {

    @Autowired
    HiService hiService;

    @Test
    void test01(){
        hiService.createHi("IntegrationTest - test01");
    }

    @Test
    void test02(){
        hiService.createHi("IntegrationTest - test02");
        hiService.getHi("IntegrationTest - test02");
    }
}
