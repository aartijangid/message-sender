package com.crossengage.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRepositoryTest {

    private UserRepository repository;
    private File dataFile = new File(this.getClass().getResource("/test_user_data.txt").getFile());

    @BeforeEach
    void setUp() {
        repository = new UserRepository(dataFile);
    }

    @Test
    void givenDataFile_ShouldReturnListOfAllActiveUsers(){
        assertThat(repository.populateUserList()).hasSize(4);
    }
}
