package com.jihyun.stockcommunity.service;

import com.jihyun.stockcommunity.mapper.HeartMapper;
import org.springframework.stereotype.Service;


@Service
public class HeartService {

    private final HeartMapper heartMapper;

    public HeartService(HeartMapper heartMapper) {
        this.heartMapper = heartMapper;
    }

    public void Heart(int commentSelectId, String nowUserName) {
        heartMapper.insertHeart(commentSelectId, nowUserName);
    }

    public void HeartContent(int contentSelectId, String nowUserName) {
        heartMapper.insertContentHeart(contentSelectId, nowUserName);
    }


}
