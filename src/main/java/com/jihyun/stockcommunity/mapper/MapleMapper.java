package com.jihyun.stockcommunity.mapper;

import com.jihyun.stockcommunity.domain.Maple;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MapleMapper {

    void insertMapleLevel(Maple maple);

    List<Maple> mapleLevel();

    void deleteMaple(String name, String world);

    Maple mapleSelectDetail(String idValue);

    void mapleUpdateDetail(int nowLevel,
                           int goalLevel,
                           String world,
                           String name,
                           String phone
                           );
}
