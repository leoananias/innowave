package com.innowave.challenge.service;

import com.innowave.challenge.dto.CreateProgramDto;
import com.innowave.challenge.entity.Program;
import com.innowave.challenge.entity.Channel;
import com.innowave.challenge.repository.ProgramRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProgramService {

    @Autowired
    private ProgramRepository programRepository;

    public String createProgram(CreateProgramDto createProgramDto){

        Channel channel = new Channel();

        channel.setId(createProgramDto.getChannelId());

        Program program = new Program(createProgramDto.getDescription(),
                createProgramDto.getEndtime(),
                createProgramDto.getImageUrl(),
                createProgramDto.getStartTime(),
                createProgramDto.getTitle(),
                channel);

        return programRepository.save(program).getId();
    }

    public List<Program> getAllPrograms(String programId){

        List<Program> programs = new ArrayList<>();

        programRepository.findByChannelId(programId).forEach(programs::add);

        return programs;
    }

    public void deleteByProgramId(String programId){

        Program program = new Program();

        program.setId(programId);

        programRepository.delete(program);
    }

    public Program getProgramById(String programId){

        return programRepository.findByIdString(programId);
    }

    public Program updateProgram(Program program){

        return programRepository.save(program);
    }

}
