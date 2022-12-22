package com.innowave.challenge.service;

import com.innowave.challenge.entity.Channel;
import com.innowave.challenge.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    public String createChannel(Channel channel){

        return channelRepository.save(channel).getId();

    }

    public List<Channel> getAllChannels(String id){

        List<Channel> channels = new ArrayList<>();

        if (id == null)
            channelRepository.findAll().forEach(channels::add);
        else
            channelRepository.findByIdString(id).forEach(channels::add);

        return channels;

    }
}
