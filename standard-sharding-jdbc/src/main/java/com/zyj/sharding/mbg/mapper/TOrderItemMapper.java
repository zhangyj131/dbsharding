package com.zyj.sharding.mbg.mapper;

import com.zyj.sharding.mbg.model.TOrderItem;
import com.zyj.sharding.mbg.model.TOrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderItemMapper {
    long countByExample(TOrderItemExample example);

    int deleteByExample(TOrderItemExample example);

    int deleteByPrimaryKey(Long itemId);

    int insert(TOrderItem record);

    int insertSelective(TOrderItem record);

    List<TOrderItem> selectByExample(TOrderItemExample example);

    TOrderItem selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") TOrderItem record, @Param("example") TOrderItemExample example);

    int updateByExample(@Param("record") TOrderItem record, @Param("example") TOrderItemExample example);

    int updateByPrimaryKeySelective(TOrderItem record);

    int updateByPrimaryKey(TOrderItem record);
}