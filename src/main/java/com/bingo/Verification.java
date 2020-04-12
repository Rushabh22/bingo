package com.bingo;

import java.util.List;

public class Verification {
    private String result;
    private List<Integer> input;
    private List<Integer> notPresent;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Integer> getInput() {
        return input;
    }

    public void setInput(List<Integer> input) {
        this.input = input;
    }

    public List<Integer> getNotPresent() {
        return notPresent;
    }

    public void setNotPresent(List<Integer> notPresent) {
        this.notPresent = notPresent;
    }
}
