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

    //페이지네이션 포함
    public List<ContentCommunity> getContentListView(int offset) {
        return contentMapper.contentListView(offset);
    }
    //페이지네이션
    public int getContentCount() {
        return contentMapper.getContentCount();
    }


    public ContentCommunity getContentDetailView(String idValue, String username) {
        return contentMapper.contentDetailView(idValue, username);
    }

    public ContentCommunity getContentDetailUpdateForView(String idValue) {
        return contentMapper.contentDetailUpdateView(idValue);
    }

    public void updateContentDetail(String contentTitle, String contentContent, String contentUsername, int contentId) {
        contentMapper.contentDetailUpdate(contentTitle, contentContent, contentUsername, contentId);
    }

    public void deleteContentDetail(String contentTitle, String contentContent, String contentUsername, int contentId) {
        contentMapper.contentDetailDelete(contentTitle, contentContent, contentUsername, contentId);
    }
}
