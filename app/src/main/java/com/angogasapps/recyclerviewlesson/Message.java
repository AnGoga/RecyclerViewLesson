package com.angogasapps.recyclerviewlesson;

public class Message {
    private int number = 0;
    private String text = "";

    public Message(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
