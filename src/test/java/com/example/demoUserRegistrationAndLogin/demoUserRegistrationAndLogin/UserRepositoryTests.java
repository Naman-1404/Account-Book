package com.example.demoUserRegistrationAndLogin.demoUserRegistrationAndLogin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("anuj1234@gmail.com");
        user.setPassword("anujganjedi");
        user.setFirstName("Anuj");
        user.setLastName("Ganjedi");

         User savedUser = repo.save(user);

         User exitUser= entityManager.find(User.class,savedUser.getId());

         assertThat(user.getEmail()).isEqualTo(exitUser.getEmail());
    }

//    @Test
//    public void testFindUserByEmail(){
//        String email="naman1234@gmail.com";
//        User user = repo.findByEmail(email);
//
//        assertThat(user).isNotNull();
//    }
}
