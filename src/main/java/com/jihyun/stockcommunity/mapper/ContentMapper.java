package com.jihyun.stockcommunity.mapper;

import com.jihyun.stockcommunity.domain.ContentCommunity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContentMapper {

    List<ContentCommunity> contentListView();

    ContentCommunity contentDetailView(String idValue, String username);

    ContentCommunity contentDetailUpdateView(String idValue);

    void contentDetailUpdate(String contentTitle, String contentContent, String contentUsername, int contentId);

    void contentDetailDelete(String contentTitle, String contentContent, String contentUsername, int contentId);
}
