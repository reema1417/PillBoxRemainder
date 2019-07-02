package com.example.android.pillboxremainder.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Drugs extends RealmObject {

    @PrimaryKey

    private String drug_id;
    @Required
    private String drug_name;
    @Required
    private String drug_type;
    @Required
    private String drug_time;

    private int drug_day;

//    @LinkingObjects("drugs")
//    public RealmList<Seniors> senior;

    public Drugs(){}

    public Drugs(String drug_id, String drug_name, String drug_type, String drug_time, int drug_day) {
        this.drug_id = drug_id;
        this.drug_name = drug_name;
        this.drug_type = drug_type;
        this.drug_time = drug_time;
        this.drug_day = drug_day;
    }

    public String getDrug_id() {
        return drug_id;
    }

    public void setDrug_id(String drug_id) {
        this.drug_id = drug_id;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public String getDrug_type() {
        return drug_type;
    }

    public void setDrug_type(String drug_type) {
        this.drug_type = drug_type;
    }

    public String getDrug_time() {
        return drug_time;
    }

    public void setDrug_time(String drug_time) {
        this.drug_time = drug_time;
    }

    public int getDrug_day() {
        return drug_day;
    }

    public void setDrug_day(int drug_day) {
        this.drug_day = drug_day;
    }
}
