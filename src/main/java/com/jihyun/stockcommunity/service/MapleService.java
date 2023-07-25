package com.jihyun.stockcommunity.service;

import com.jihyun.stockcommunity.domain.ContentCommunity;
import com.jihyun.stockcommunity.domain.Maple;
import com.jihyun.stockcommunity.mapper.MapleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapleService {
    private final MapleMapper mapleMapper;

    @Autowired
    public MapleService(MapleMapper mapleMapper) {
        this.mapleMapper = mapleMapper;
    }

    public void insertMaple(Maple maple) {
        mapleMapper.insertMapleLevel(maple);
    }

    public List<Maple> selectMaple() {
        return mapleMapper.mapleLevel();
    }

    public void deleteMaple(String name, String world) {
        mapleMapper.deleteMaple(name, world);
    }

}
