package com.birichani.code.restapi.api;

import com.birichani.code.restapi.model.Video;
import com.birichani.code.restapi.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoApiController {
	private VideoRepository videoRepository;
	
	@Autowired
	 public VideoApiController(VideoRepository videoRepository) {
		this.videoRepository = videoRepository;
	}
	
	@GetMapping("/Getvideos/{videoTopic}")
	public String video(@PathVariable String videoTopic) {
		
		switch(videoTopic) {
		case"python":
		
		return String.format("This is our python contents") ;
		case "java": 
			return String.format("This is our java contents") ;
			default:
				return String.format("sorry,Incorrect input") ;
			
	}
		
}
	@GetMapping("/GetAll")
	public List<Video> getAllvideos(){
		return videoRepository.findAll();
	}
}
