package com.jihyun.stockcommunity.mapper;

import com.jihyun.stockcommunity.domain.ContentCommunity;
import com.jihyun.stockcommunity.domain.StockCommunity;
import com.jihyun.stockcommunity.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    User login(String username, String password);

    List<User> myinfo();

    void updateMyInfo(String username, String password, String newpassword);

    List<ContentCommunity> updateGrade(String username);
}
