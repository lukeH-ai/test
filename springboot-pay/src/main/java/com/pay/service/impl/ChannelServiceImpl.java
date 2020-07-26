package com.pay.service.impl;

import com.pay.entity.Channel;
import com.pay.mapper.ChannelMapper;
import com.pay.service.IChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述
 *
 * @author Luke
 * @date 2020/3/10
 */
@Service
public class ChannelServiceImpl implements IChannelService {

    @Autowired
    private ChannelMapper channelMapper;

    @Override
    public Channel getChannel(int id) {
        return channelMapper.getChannel(id);
    }

    @Override
    public List<Channel> selectChannelList() {
        return channelMapper.selectChannelList();
    }
}
