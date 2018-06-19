package com.cd.taobao.model;

/**
 * Created by KID on 2016/12/5.
 */
public class Book {

    public String content;

    public String imgRes;

    public int  width;

    public int height;

    public Book(String content, String imgRes, int width, int height) {
        this.content = content;
        this.imgRes = imgRes;
        this.width=width;
        this.height=height;
    }
}
