package com.innowave.challenge.controller;

import com.innowave.challenge.dto.CreateProgramDto;
import com.innowave.challenge.dto.ProgramDto;
import com.innowave.challenge.entity.Program;
import com.innowave.challenge.service.ProgramService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "program")
@RestController
@RequestMapping("/programs")
public class ProgramController {

	private static final ModelMapper modelMapper = new ModelMapper();
	@Autowired
	ProgramService programService;

	@ApiOperation("Create Program")
	@PostMapping("/create")
	public ResponseEntity<String> createProgram(@RequestBody CreateProgramDto createProgramDto) {
		try {
			String _id = programService.createProgram(createProgramDto);
			return new ResponseEntity<>(_id, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Retrieve Program by Channel ID")
	@GetMapping("/{channelid}")
	public ResponseEntity<List<ProgramDto>>  getProgramsByChannel(@RequestParam() String channelId) {
		try {
			List<Program> _programs = programService.getAllPrograms(channelId);

			if (_programs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(_programs.stream().map(this::convertToDto).collect(Collectors.toList()), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Retrieve Program Detail by Program ID")
	@GetMapping("/{id}")
	public ResponseEntity<ProgramDto> getProgramDetailById(@RequestParam() String id) {
		try {
			Program _programs = programService.getProgramById(id);

			return new ResponseEntity<>(convertToDto(_programs), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Delete Program by Channel ID")
	@DeleteMapping ("/{id}")
	public ResponseEntity<HttpStatus> deleteProgramById(@RequestParam() String id) {
		try {
			programService.deleteByProgramId(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Update Program by Program ID")
	@PutMapping  ("/{id}")
	public ResponseEntity<ProgramDto> updateProgramById(@RequestBody ProgramDto programDto) {
		try {
			Program _program = programService.updateProgram(convertToEntityUpdate(programDto));

			return new ResponseEntity<>(convertToDto(_program), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private ProgramDto convertToDto(Program program) {
		return modelMapper.map(program, ProgramDto.class);
	}

	private Program convertToEntity(CreateProgramDto createProgramDto){
		return modelMapper.map(createProgramDto, Program.class);
	}

	private Program convertToEntityUpdate(ProgramDto programDto){
		return modelMapper.map(programDto, Program.class);
	}



}
