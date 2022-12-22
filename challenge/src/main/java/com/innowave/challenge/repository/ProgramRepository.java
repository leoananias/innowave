package com.innowave.challenge.repository;

import com.innowave.challenge.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.List;

@Repository
@NamedQuery(name = "Channel.findByIdString", query = "select c from Channel c where c.id = ?1")
public interface ProgramRepository extends JpaRepository<Program, String> {

    List<Program> findByChannelId(String channelId);

    Program findByIdString(String programId);

}
