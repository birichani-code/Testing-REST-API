package com.birichani.code.restapi.service;

import com.birichani.code.restapi.constant.InfoMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author - JoeSeff
 * @created - 23/10/2020 00:08
 */
class VideoServiceTest {
    private final VideoService videoService = new VideoService();
    
    @Test
    @DisplayName("Test That Correct Video Topic Is Returned")
    void testThatCorrectVideoTopicIsReturned() {
        String response = videoService.getVideosByTopic("Java");
        assertEquals(InfoMessage.JAVA_RESPONSE_MESSAGE, response);
    }
    
}