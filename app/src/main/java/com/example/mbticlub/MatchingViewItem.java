package com.example.mbticlub;

public class MatchingViewItem {
    private String title;
    private String content;


    public MatchingViewItem(String title, String content) {
        this.title = title;
        this.content = content;


    }

    public void setTitle(String title) {
        this.title = title ;
    }
    public void setContent(String content) {
        this.content = content ;
    }


    public String getTitle() {
        return this.title ;
    }

    public String getContent() {
        return this.content ;
    }


}
