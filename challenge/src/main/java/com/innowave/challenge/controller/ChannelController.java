package com.innowave.challenge.controller;


import com.innowave.challenge.dto.ChannelDto;
import com.innowave.challenge.entity.Channel;
import com.innowave.challenge.service.ChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "channel")
@RestController
@RequestMapping("/channels")
public class ChannelController {


	private static final ModelMapper modelMapper = new ModelMapper();
	@Autowired
	ChannelService channelService;

	@ApiOperation("Create Channel")
	@PostMapping("/create")
	public ResponseEntity<String> createChannel(@RequestBody ChannelDto channelDto) {
		try {
			String _id = channelService.createChannel(covertToEntity(channelDto));
			return new ResponseEntity<>(_id, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Retrieve Channel")
	@GetMapping("")
	public ResponseEntity<List<ChannelDto>> getAllChannels(@RequestParam(required = false) String id) {
		try {
			List<Channel> _channels = channelService.getAllChannels(id);

			if (_channels.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(_channels.stream().map(this::convertToDto).collect(Collectors.toList()), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private ChannelDto convertToDto(Channel channel) {
		return modelMapper.map(channel, ChannelDto.class);
	}

	private Channel covertToEntity(ChannelDto channelDto){
		return modelMapper.map(channelDto, Channel.class);
	}

}
