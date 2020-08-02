package com.example.mbticlub;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.Arrays;

public class BoardListViewItem {
    private int iconDrawable ;
    private String titleStr ;
    private String content ;

    public void setIcon(int icon) {
        iconDrawable = icon ;
    }
    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setDesc(String desc) {
        content = desc ;
    }

    public int getIcon() {
        return this.iconDrawable ;
    }
    public String getTitle() {
        return this.titleStr ;
    }


    public String getDesc() {
        return this.content ;
    }

}