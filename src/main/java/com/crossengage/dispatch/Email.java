package com.crossengage.dispatch;

public class Email implements MessageDispatcher {

    public String email;
    public boolean trigger;

    public Email(String email, boolean trigger) {
        this.email = email;
        this.trigger = trigger;
    }

    public void send() {
        if(trigger) {
            System.out.println("Email message : " + email);
        }
    }
}
