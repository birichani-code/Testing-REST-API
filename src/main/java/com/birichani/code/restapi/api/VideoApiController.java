package com.birichani.code.restapi.api;

import com.birichani.code.restapi.model.Video;
import com.birichani.code.restapi.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.birichani.code.restapi.service.VideoService;

import java.util.List;

@RequestMapping("/videos")
@RestController
public class VideoApiController {
	private final VideoRepository videoRepository;
	private final VideoService videoService;
	
	@Autowired
	 public VideoApiController(VideoRepository videoRepository, VideoService videoService) {
		this.videoRepository = videoRepository;
		this.videoService = videoService;
	}
	
	@GetMapping("/{videoTopic}")
	public String getVideosByTopic(@PathVariable String videoTopic) {
		return videoService.getVideosByTopic(videoTopic);
	}
	@GetMapping()
	public List<Video> getAllVideos(){
		return videoRepository.findAll();
	}
}
