package com.jihyun.stockcommunity.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Comment {


    private String commentAuthor;
    private String commentContent;
    private Date commentDate;
    private int commentId;
    private int commentContentId;


}
