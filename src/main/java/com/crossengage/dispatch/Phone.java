package com.crossengage.dispatch;

public class Phone implements MessageDispatcher {

    public String phone;
    public boolean trigger;

    public Phone(String phone, boolean trigger) {
        this.phone = phone;
        this.trigger = trigger;
    }

    public void send() {
        if(trigger) {
            System.out.println("Phone message : " + phone);
        }
    }
}
