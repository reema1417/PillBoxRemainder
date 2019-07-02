package com.example.android.pillboxremainder.Models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Seniors extends RealmObject {

    @PrimaryKey

    private String senior_id;
    @Required
    private String senior_name;
    @Required
    private String senior_age;
    @Required
    private RealmList<String> disease;

    private int caretaker_id;
//    public RealmList<Drugs> drugs;

    public Seniors(){}

    public Seniors(String senior_id, String senior_name, String senior_age, RealmList<String> disease, int caretaker_id) {
        this.senior_id = senior_id;
        this.senior_name = senior_name;
        this.senior_age = senior_age;
        this.disease = disease;
        this.caretaker_id = caretaker_id;
    }

    public String getSenior_id() {
        return senior_id;
    }

    public void setSenior_id(String senior_id) {
        this.senior_id = senior_id;
    }

    public String getSenior_name() {
        return senior_name;
    }

    public void setSenior_name(String senior_name) {
        this.senior_name = senior_name;
    }

    public String getSenior_age() {
        return senior_age;
    }

    public void setSenior_age(String senior_age) {
        this.senior_age = senior_age;
    }

    public int getCaretaker_id() {
        return caretaker_id;
    }

    public void setCaretaker_id(int caretaker_id) {
        this.caretaker_id = caretaker_id;
    }

    public RealmList<String> getDisease() {
        return disease;
    }

    public void setDisease(RealmList<String> disease) {
        this.disease = disease;
    }
}
