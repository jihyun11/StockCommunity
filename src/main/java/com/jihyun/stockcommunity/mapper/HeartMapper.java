package com.jihyun.stockcommunity.mapper;

import com.jihyun.stockcommunity.domain.Heart;
import com.jihyun.stockcommunity.domain.SelectComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HeartMapper {

    void insertHeart(int commentSelectId, String nowUserName);

    void insertContentHeart(int contentSelectId, String nowUserName);

}
