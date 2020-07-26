package com.pay.mapper;

import com.pay.entity.Channel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 描述
 *
 * @author Luke
 * @date 2020/3/10
 */
public interface ChannelMapper {
    @Select("select * from channel where id = #{id}")
    Channel getChannel(int id);

    @Select("select * from channel")
    List<Channel> selectChannelList();
}
