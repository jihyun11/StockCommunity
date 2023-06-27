package com.jihyun.stockcommunity.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContentCommunity {
    private String username;
    private String content;
    private String title;

    private int id;

    public ContentCommunity(String username, String content, String title) {
        this.username = username;
        this.content = content;
        this.title = title;
    }

    public ContentCommunity() {

    }
}
