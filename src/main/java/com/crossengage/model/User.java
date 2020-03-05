package com.crossengage.model;

import com.crossengage.dispatch.Email;
import com.crossengage.dispatch.Phone;

public class User {
    public long id;
    public boolean status;
    public ContactType contactBy;
    public Email email;
    public Phone phone;

    public User(long id, boolean status, ContactType contactBy, String email, String phone) {
        this.id = id;
        this.status = status;
        this.contactBy = contactBy;
        boolean triggerEmail = contactBy == ContactType.ALL || contactBy == ContactType.EMAIL;
        boolean triggerPhone = contactBy == ContactType.ALL || contactBy == ContactType.PHONE;
        this.email = new Email(email, triggerEmail);
        this.phone = new Phone(phone, triggerPhone);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", status=" + status +
                ", contactBy=" + contactBy +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
