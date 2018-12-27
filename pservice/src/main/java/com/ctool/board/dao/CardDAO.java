package com.ctool.board.dao;


import com.ctool.model.board.Card;
import com.ctool.model.board.Lane;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: Kylinrix
 * @Date: 2018/12/27 15:21
 * @Email: Kylinrix@outlook.com
 * @Description:
 */

@Mapper
public interface CardDAO {

    String tableName=" card ";
    String selectFields =
            " id," +
            "lane_id," +
            "card_name," +
            "card_content," +
            "last_changer," +
            "created_date," +
            "description ";

    String insertFields = " lane_id,card_name,card_content,last_changer,created_date,description ";


    @Insert({"insert into "
            ,tableName,
            "(",
            insertFields,
            ") values(#{laneId},#{cardName},#{cardContent},#{lastChanger},#{createdDate},#{description})"})
    int addCard(Card card);

    @Select({"select * from " +tableName+" where card_name=#{cardName}"})
    Card selectByName(String cardName);

    @Select({"select ", selectFields, " from ", tableName, " where id=#{id}"})
    Card selectById(int id);

    @Select({"select * from "+tableName+" where lane_id = #{LaneId} order by created_date ASC "})
    List<Card> selectByLaneId(int laneId);
}
