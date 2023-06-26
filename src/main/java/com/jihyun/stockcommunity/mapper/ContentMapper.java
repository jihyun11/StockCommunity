package com.jihyun.stockcommunity.mapper;

import com.jihyun.stockcommunity.domain.ContentCommunity;
import com.jihyun.stockcommunity.domain.StockCommunity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContentMapper {

    List<ContentCommunity> contentListView();

    List<ContentCommunity> contentDetailView(String title);
}
