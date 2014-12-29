package com.github.K0zka.dummywarhead;

import java.util.Date;

public class AdvancedHello {
    Date timeStamp;
    Person greetingFrom;
    Person greetingTo;
    String langCode;
    boolean official;
    String message;

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setGreetingFrom(Person greetingFrom) {
        this.greetingFrom = greetingFrom;
    }

    public void setGreetingTo(Person greetingTo) {
        this.greetingTo = greetingTo;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public Person getGreetingFrom() {
        return greetingFrom;
    }

    public Person getGreetingTo() {
        return greetingTo;
    }

    public String getLangCode() {
        return langCode;
    }

    public boolean isOfficial() {
        return official;
    }

    public String getMessage() {
        return message;
    }

}
