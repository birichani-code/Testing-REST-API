package com.birichaniCode.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VideoRepositoryController {
	@Autowired
	 public VideoRepository videoRepository;
	public List<Videos>getAllvideos(){
		return videoRepository.findAll();
	}

}
