package com.jihyun.stockcommunity.mapper;

import com.jihyun.stockcommunity.domain.ContentCommunity;
import com.jihyun.stockcommunity.domain.StockCommunity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@Mapper
public interface SampleMapper {

    int selectSample();

    String selectStock();


//    @Insert("INSERT INTO stockmember (username, password) VALUES (#{username}, #{password})")
    void insertStock(StockCommunity stockCommunity);

    void insertContentStock(ContentCommunity contentCommunity);

}
