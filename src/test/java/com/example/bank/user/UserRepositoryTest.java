package com.example.bank.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsernameAndPassword_test(){
        //given
        String username = "ssar";
        String password = "1234";
        //when
        Optional<User> userOp = userRepository.findByUsernameAndPassword(username,password);

        //eye
//        User user = userOp.get();
//        System.out.println(user.getUsername());

        //then
//        Assertions.assertThat(userOp.get()).isNotNull();
        Assertions.assertThat(userOp.get().getUsername()).isEqualTo("ssar");
    }
}
