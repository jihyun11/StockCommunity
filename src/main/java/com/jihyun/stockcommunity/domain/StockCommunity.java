package com.jihyun.stockcommunity.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StockCommunity {

    private String username;
    private String password;

    private String interests;








    public StockCommunity(String username, String password) {
        this.username = username;
        this.password = password; //혹시몰라 생성자도 추가해봄...
    }
    public StockCommunity() {
        this.username = username;
        this.password = password;
        //혹시몰라 생성자도 추가해봄...



    }
//    private String content;
//    private String title;
}
