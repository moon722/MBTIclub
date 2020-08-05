package com.example.mbticlub;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.Arrays;

public class MListViewItem {
    private int icon ;
    private String title ;
    private String content ;
    private String user_id;
    private String board_title;

    public MListViewItem(String user_id, String board_title, String title, String content) {
        this.user_id = user_id;
        this.title = title ;
        this.content = content ;
        this.board_title = board_title ;
    }

    public void setUser_id(String user_id){this.user_id = user_id;}
    public void setIcon(int icon) {
        this.icon = icon ;
    }
    public void setTitle(String title) {
        this.title = title ;
    }
    public void setContent(String content) {
        this.content = content ;
    }
    public void setBoard_title(String board_title) {
        this.board_title = board_title ;
    }


    public int getIcon() {
        return this.icon ;
    }
    public String getTitle() {
        return this.title ;
    }

    public String getContent() {
        return this.content ;
    }
    public String getUser_id(){ return this.user_id;}
    public String getBoard_title(){ return this.board_title;}


}