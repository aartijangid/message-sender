package com.crossengage.repository;

import com.crossengage.exception.InvalidUserEmailAddress;
import com.crossengage.exception.InvalidUserException;
import com.crossengage.model.ContactType;
import com.crossengage.model.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserRepository {

    private File data;

    public UserRepository(File data) {
        this.data = data;
    }

    public List<User> populateUserList() {
        List<User> userList = new ArrayList<User>();
        try {
            userList = Files.lines(data.toPath())
                    .skip(1)
                    .map(UserRepository::readEachLine)
                    .filter(user -> user.status)
                    .collect(Collectors.toList());
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

    private static User readEachLine(String currentLine) throws InvalidUserException{
        String[] token = currentLine.split(",");
        Pattern regexPattern;
        Matcher regMatcher;
        regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
        regMatcher   = regexPattern.matcher(token[3].trim());

        if(token.length != 5)
            throw new InvalidUserException("Invalid User Details");

        return new User(Integer.parseInt(token[0].trim()),
                Boolean.parseBoolean(token[1].trim()),
                ContactType.valueOf(token[2].trim().toUpperCase()),
                token[3].trim(),
                token[4].trim());
    }
}
