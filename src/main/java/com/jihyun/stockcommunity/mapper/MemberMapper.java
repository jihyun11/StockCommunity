package com.jihyun.stockcommunity.mapper;

import com.jihyun.stockcommunity.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    User login(String username, String password);
}
