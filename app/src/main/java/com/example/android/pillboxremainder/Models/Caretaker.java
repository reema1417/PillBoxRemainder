package com.example.android.pillboxremainder.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Caretaker extends RealmObject {

    @PrimaryKey

    private String caretaker_id;
    @Required
    private String caretaker_name;
    @Required
    private String caretaker_email;
    @Required
    private String caretaker_password;

    public Caretaker() {}

    public Caretaker(String caretaker_id, String caretaker_name, String caretaker_email, String caretaker_password) {
        this.caretaker_id = caretaker_id;
        this.caretaker_name = caretaker_name;
        this.caretaker_email = caretaker_email;
        this.caretaker_password = caretaker_password;
    }

    public String getCaretaker_id() {
        return caretaker_id;
    }

    public void setCaretaker_id(String caretaker_id) {
        this.caretaker_id = caretaker_id;
    }

    public String getCaretaker_name() {
        return caretaker_name;
    }

    public void setCaretaker_name(String caretaker_name) {
        this.caretaker_name = caretaker_name;
    }

    public String getCaretaker_email() {
        return caretaker_email;
    }

    public void setCaretaker_email(String caretaker_email) {
        this.caretaker_email = caretaker_email;
    }

    public String getCaretaker_password() {
        return caretaker_password;
    }

    public void setCaretaker_password(String caretaker_password) {
        this.caretaker_password = caretaker_password;
    }
}