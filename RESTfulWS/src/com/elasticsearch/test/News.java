package com.elasticsearch.test;

import io.searchbox.annotations.JestId;

/**
 * Created by Administrator on 2016/4/18.
 */
public class News {

    @JestId
    private int id;
    private String title;
    private String content;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
