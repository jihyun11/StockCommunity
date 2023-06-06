package com.jihyun.stockcommunity.service;

import com.jihyun.stockcommunity.domain.StockCommunity;
import com.jihyun.stockcommunity.mapper.SampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    private final SampleMapper sampleMapper;

    @Autowired
    public StockService(SampleMapper sampleMapper) {
        this.sampleMapper = sampleMapper;
    }

    public String sampleStock() {
        return sampleMapper.selectStock();
    }

    public String insertStock() {
        return sampleMapper.insertStock();
    }
}
