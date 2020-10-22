package com.birichani.code.restapi.service;

import com.birichani.code.restapi.constant.ErrorMessage;
import com.birichani.code.restapi.constant.InfoMessage;
import com.birichani.code.restapi.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author - JoeSeff
 * @created - 22/10/2020 23:57
 */

@Service
public class VideoService {
    
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
}
