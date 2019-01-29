package com.example.pby.diffutildemo;

public class Bean {
    private String mId;
    private String mContent;
    private int mColor;

    public Bean(String id, String content, int color) {
        this.mId = id;
        this.mContent = content;
        this.mColor = color;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        this.mContent = content;
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        this.mColor = color;
    }

    public Bean deepCopy() {
        return new Bean(mId, mContent, mColor);
    }
}
