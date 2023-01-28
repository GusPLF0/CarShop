package com.gus.carshop.repository;

import com.gus.carshop.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {


    @Autowired
    private UserRepository underTest;

    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }

    @Test
    void itShouldReturnCorrectUser() {
        //given
        String username = "User3323";
        underTest.save(new User(1L, "User3323", "SecuredPassword"));
        //when
        User user = underTest.findByUsername(username).get();
        //then
        assertNotNull(user);
        assertEquals("User3323", user.getUsername());
    }
}