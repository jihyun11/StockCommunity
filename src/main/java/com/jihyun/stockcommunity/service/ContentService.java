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

    public ContentCommunity getContentDetailView(String idValue) {
        return contentMapper.contentDetailView(idValue);
    }

    public List<ContentCommunity> getContentDetailUpdateForView(String idValue) {
        return contentMapper.contentDetailUpdateView(idValue);
    }

    public void updateContentDetail(String contentTitle, String contentContent, String contentUsername, int contentId) {
        contentMapper.contentDetailUpdate(contentTitle, contentContent, contentUsername, contentId);
    }

    public void deleteContentDetail(String contentTitle, String contentContent, String contentUsername, int contentId) {
        contentMapper.contentDetailDelete(contentTitle, contentContent, contentUsername, contentId);
    }
}
