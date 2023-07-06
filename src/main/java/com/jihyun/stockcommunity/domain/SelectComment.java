package com.jihyun.stockcommunity.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SelectComment {

    private String commentSelectAuthor;
    private String commentSelectContent;
    private Date commentSelectDate;
    private int commentSelectId;
    private int commentSelectContentId;
    private int likeCount;
}
