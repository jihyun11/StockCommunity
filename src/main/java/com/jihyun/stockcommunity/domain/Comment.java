package com.jihyun.stockcommunity.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Comment {

    private String comment_author;
    private String comment_content;
    private Date comment_date; //date 타입도 됨?

    private int comment_id;
}
