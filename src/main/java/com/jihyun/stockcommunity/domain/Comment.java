package com.jihyun.stockcommunity.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Comment {

    private String commentAuthor;
    private String commentContent;
    private Date commentDate; //date 타입도 됨?

    private int commentId;
}
