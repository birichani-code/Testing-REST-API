package com.birichani.code.restapi.service;

import com.birichani.code.restapi.constant.ErrorMessage;
import com.birichani.code.restapi.constant.InfoMessage;
import com.birichani.code.restapi.model.Video;
import com.birichani.code.restapi.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author - JoeSeff
 * @created - 22/10/2020 23:57
 */

@Service
public class VideoService {
    private final VideoRepository videoRepository;
    
    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }
    
    public String getVideosByTopic(String videoTopic) {
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
    
    // TODO: Correct me
    public List<Video> filterVideosByTopic(String topic) {
        List<Video> videoList = videoRepository.findAll();
        
        return videoList.stream()
                .filter(Objects::nonNull)
                .filter(video -> video.getTopic() != null)
                .filter(video -> video.getTopic().equalsIgnoreCase(topic))
                .collect(Collectors.toList());
    }
}
