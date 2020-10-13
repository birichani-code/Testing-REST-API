package com.birichaniCode.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class VideoPresenter {
	
	@Autowired
	 public VideoRepositoryController videoRepositoryController;
	@RequestMapping(method=RequestMethod.GET,path="/Getvideos/{videoTopic}")
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
	@RequestMapping(method=RequestMethod.GET,path="/GetAll")
	public List<Videos>getAllvideos(){
		return videoRepositoryController.getAllvideos();
	}
}
