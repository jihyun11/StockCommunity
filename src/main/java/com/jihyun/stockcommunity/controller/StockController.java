package com.jihyun.stockcommunity.controller;

import com.jihyun.stockcommunity.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping(value = "/content")
    public String stockcontent() {
        return stockService.sampleStock();
    }
}
