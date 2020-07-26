package com.pay.service;

import com.pay.entity.Channel;

import java.util.List;

/**
 * 描述
 *
 * @author Luke
 * @date 2020/3/10
 */
public interface IChannelService {
    Channel getChannel(int id);

    List<Channel> selectChannelList();
}
