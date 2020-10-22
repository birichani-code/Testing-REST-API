package com.birichani.code.restapi.api;

import com.birichani.code.restapi.constant.ErrorMessage;
import com.birichani.code.restapi.constant.InfoMessage;
import com.birichani.code.restapi.model.Video;
import com.birichani.code.restapi.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/videos")
@RestController
public class VideoApiController {
	private final VideoRepository videoRepository;
	
	@Autowired
	 public VideoApiController(VideoRepository videoRepository) {
		this.videoRepository = videoRepository;
	}
	
	@GetMapping("/{videoTopic}")
	public String video(@PathVariable String videoTopic) {
		String message;
		
		switch (videoTopic.toLowerCase()) {
			case "python":
				message = InfoMessage.PYTHON_RESPONSE_MESSAGE;
				break;
			case "java":
				message = InfoMessage.JAVA_RESPONSE_MESSAGE;
				break;
			default:
				message = ErrorMessage.VIDEO_TOPIC_SELECTION_MESSAGE;
		}
		
		return message;
}
	@GetMapping()
	public List<Video> getAllvideos(){
		return videoRepository.findAll();
	}
}
