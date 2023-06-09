package com.jihyun.stockcommunity.mapper;

import com.jihyun.stockcommunity.domain.ContentCommunity;
import com.jihyun.stockcommunity.domain.StockCommunity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface SampleMapper {

    int selectSample();

    String selectStock();

    //등록
    void insertStock(StockCommunity stockCommunity);

    void insertContentStock(ContentCommunity contentCommunity);

    //조회
    List<StockCommunity> selectAllStock();

    List<ContentCommunity> selectAllContentStock();

    //삭제
    void deleteStock(String username, String password);

    void deleteContentStock(String username, String title);
    //insert는 StockCummunity를 받아와야하는데 왜 delete는 그냥 input상자에서 받은 애로 바로 처리가 됨?
    //insert는 클라이언트로부터 받은 매개변수를 객체로 한꺼번에 담아 처리하는 게 편하고,
    //delete는 클라이언트로부터 받은 매개변수를 직접 활용하여 처리하는 게 더 편하기 때문.


    //수정
    void updateStock(String username, String password, String newpassword);

    void updateContentStock(String username, String newcontent, String newtitle);

}
