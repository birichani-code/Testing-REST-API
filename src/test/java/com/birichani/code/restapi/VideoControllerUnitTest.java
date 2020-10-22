package com.birichani.code.restapi;

import com.birichani.code.restapi.api.VideoApiController;
import com.birichani.code.restapi.constant.InfoMessage;
import com.birichani.code.restapi.repository.VideoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DisplayName("Video API Controller Unit Test")
public class VideoControllerUnitTest {

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

