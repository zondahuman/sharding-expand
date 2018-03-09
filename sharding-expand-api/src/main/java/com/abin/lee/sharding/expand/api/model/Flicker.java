package com.abin.lee.sharding.expand.api.model;

public class Flicker {
    private Long id;
    private String stub;

    public Flicker() {
    }

    public Flicker(String stub) {
        this.stub = stub;
    }

    public Flicker(Long id, String stub) {
        this.id = id;
        this.stub = stub;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStub() {
        return stub;
    }

    public void setStub(String stub) {
        this.stub = stub;
    }
}