package com.codejocks.absolutedarhk.model;

import java.io.Serializable;

/**
 * Created by hp on 14-08-2017.
 */

public class HallOfFame implements Serializable {
    private String person1name, person2name, person1description, person2description;
    private String small, medium, large;

    public HallOfFame() {
    }

    public HallOfFame(String person1name, String person2name, String person1description, String person2description, String small, String medium, String large) {
        this.person1name = person1name;
        this.person2name = person2name;
        this.person1description = person1description;
        this.person2description = person2description;
        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    public String getPerson1name() {
        return person1name;
    }

    public void setPerson1name(String name) {
        this.person1name = person1name;
    }

    public String getPerson2name() {
        return person2name;
    }

    public void setPerson2name(String name) {
        this.person2name = person2name;
    }

    public String getPerson1description() {
        return person1description;
    }

    public void setPerson1description(String name) {
        this.person1description = person1description;
    }

    public String getPerson2description() {
        return person2description;
    }

    public void setPerson2description(String name) {
        this.person2description = person2description;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }
}

