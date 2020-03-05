package com.crossengage;

import com.crossengage.dispatch.MessageDispatcher;
import com.crossengage.model.User;
import com.crossengage.repository.UserRepository;

import java.io.File;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        UserRepository repository = new UserRepository(new File(args[0]));
        for(int i = 1; i < args.length; i++) {
            if(args[i].equals("email_text"))
                for(User user : repository.populateUserList()) {
                    user.email.send();
                }
            else if(args[i].equals("sms_text"))
                for(User user : repository.populateUserList()) {
                    user.phone.send();
                }
        }
    }
}
