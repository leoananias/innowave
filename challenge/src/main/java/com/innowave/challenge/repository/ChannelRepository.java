package com.innowave.challenge.repository;

import com.innowave.challenge.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, String> {

    List<Channel> findByIdString(String id);

}
