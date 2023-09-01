package com.jihyun.stockcommunity.mapper;

import com.jihyun.stockcommunity.domain.Maple;
import com.jihyun.stockcommunity.domain.Miracle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MiracleMapper {
    void insertMiracle(String miracle);

    List<Miracle> selectMiracle();

    void deleteMiracle(String miracle_id, String miracle, String miracle_date);
}
