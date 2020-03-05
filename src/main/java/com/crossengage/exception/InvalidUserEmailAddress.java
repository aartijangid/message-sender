package com.crossengage.exception;

public class InvalidUserEmailAddress extends Throwable {
    public InvalidUserEmailAddress(String message){
        super(message);
    }
}
