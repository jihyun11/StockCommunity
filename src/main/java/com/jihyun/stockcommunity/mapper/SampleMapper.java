package com.jihyun.stockcommunity.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@Mapper
public interface SampleMapper {
    int selectSample();

    String selectStock();

}
