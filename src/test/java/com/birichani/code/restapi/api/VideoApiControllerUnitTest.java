package com.birichani.code.restapi.api;

import com.birichani.code.restapi.constant.InfoMessage;
import com.birichani.code.restapi.repository.VideoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author - JoeSeff
 * @created - 22/10/2020 09:57
 */

@DisplayName("Video API Controller Unit Test")
class VideoApiControllerUnitTest {
    
    @Mock
    VideoRepository videoRepository;
    VideoApiController controller = new VideoApiController(videoRepository);
    
    @Test
    @DisplayName("Test That Correct Video Topic Is Returned")
    void testThatCorrectVideoTopicIsReturned() {
        String response = controller.video("Java");
        assertEquals(InfoMessage.JAVA_RESPONSE_MESSAGE, response);
    }

}