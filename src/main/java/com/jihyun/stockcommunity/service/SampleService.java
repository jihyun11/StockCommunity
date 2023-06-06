package com.jihyun.stockcommunity.service;

import com.jihyun.stockcommunity.mapper.SampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    private final SampleMapper sampleMapper;

    @Autowired
    public SampleService(SampleMapper sampleMapper) {
        this.sampleMapper = sampleMapper;
    }

    public int selectSample() {
        return sampleMapper.selectSample();
    }

}
