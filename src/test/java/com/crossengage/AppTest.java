package com.crossengage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private File dataFile = new File(this.getClass().getResource("/test_user_data.txt").getFile());

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void givenInputDataFile_ShouldSendPhoneMessages() throws IOException {
        App.main(new String[]{String.valueOf(dataFile), "sms_text"});
        assertEquals("Phone message : +999999999996\n", outContent.toString());
    }

    @Test
    void givenInputDataFile_ShouldSendEmailAndPhoneMessages() throws IOException {
        App.main(new String[]{String.valueOf(dataFile), "email_text", "sms_text"});
        assertEquals("Email message : test1@mail.com\n" +
                "Email message : test4@mail.com\n" +
                "Email message : test5@mail.com\n" +
                "Phone message : +999999999996\n", outContent.toString());
    }
}