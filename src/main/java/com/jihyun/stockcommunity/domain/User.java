package com.jihyun.stockcommunity.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class User implements Serializable {

    private String username;
    private String password;
    private String interest;




    public List<String> getInterestList() {
        if (interest == null) {
            return new ArrayList<>();
        }
        String[] split = interest.split(",");
        return Arrays.stream(split).collect(Collectors.toList());
    }



}
