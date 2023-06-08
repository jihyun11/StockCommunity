package com.jihyun.stockcommunity.service;

import com.jihyun.stockcommunity.domain.ContentCommunity;
import com.jihyun.stockcommunity.domain.StockCommunity;
import com.jihyun.stockcommunity.mapper.SampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void insertStock(StockCommunity stockCommunity) {
        sampleMapper.insertStock(stockCommunity);
    }

    public void insertContentStock(ContentCommunity contentCommunity) {
        sampleMapper.insertContentStock(contentCommunity);
    }

    public List<StockCommunity> getStockList() {
        return sampleMapper.selectAllStock();

    }

    public List<ContentCommunity> getContentStockList() {
        return sampleMapper.selectAllContentStock();
    }


}
