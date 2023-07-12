package com.jihyun.stockcommunity.mapper;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface HeartMapper {

    void insertHeart(int commentSelectId, String nowUserName);

    void insertContentHeart(int contentSelectId, String nowUserName);

}
