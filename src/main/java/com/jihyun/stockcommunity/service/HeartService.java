package com.jihyun.stockcommunity.service;

import com.jihyun.stockcommunity.domain.Heart;
import com.jihyun.stockcommunity.domain.SelectComment;
import com.jihyun.stockcommunity.mapper.HeartMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeartService {

    private final HeartMapper heartMapper;

    public HeartService(HeartMapper heartMapper) {
        this.heartMapper = heartMapper;
    }

    public void Heart(int commentSelectId, String nowUserName) {
        heartMapper.insertHeart(commentSelectId, nowUserName);
    }


}
