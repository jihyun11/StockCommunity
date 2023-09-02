package com.jihyun.stockcommunity.service;

import com.jihyun.stockcommunity.domain.Miracle;
import com.jihyun.stockcommunity.mapper.MiracleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiracleService {
    private final MiracleMapper miracleMapper;


    @Autowired
    public MiracleService(MiracleMapper miracleMapper) {
        this.miracleMapper = miracleMapper;
    }

    public void insertMiracle(String miracle) {
        miracleMapper.insertMiracle(miracle);
    }

    public List<Miracle> selectMiracle() {
        return miracleMapper.selectMiracle();
    }

    public void deleteMiracle(String miracle_id, String miracle, String miracle_date) {
        miracleMapper.deleteMiracle(miracle_id, miracle, miracle_date);
    }
}
