package com.jihyun.stockcommunity.service;

import com.jihyun.stockcommunity.domain.ContentCommunity;
import com.jihyun.stockcommunity.mapper.ContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {
    private final ContentMapper contentMapper;

    @Autowired
    public ContentService(ContentMapper contentMapper) {
        this.contentMapper = contentMapper;
    }

    public List<ContentCommunity> getContentListView() {
        return contentMapper.contentListView();
    }

    public List<ContentCommunity> getContentDetailView(String title) {
        return contentMapper.contentDetailView(title);
    }
}
