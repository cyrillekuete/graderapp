package com.next.graderapp;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public class Grade {

    @NotBlank(message = "name cannot be blank")
    private String name;
    @NotBlank(message = "subject cannot be blank")
    private String subject;
    @Score(message = "Score must be a letter grade")
    private String score;
    private String id;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Grade(String name, String subject, String score) {
        this.name = name;
        this.subject = subject;
        this.score = score;
    }

    public Grade() {
        this.id = UUID.randomUUID().toString();
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
