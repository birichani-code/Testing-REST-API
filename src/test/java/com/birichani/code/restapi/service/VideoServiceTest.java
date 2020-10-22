package com.birichani.code.restapi.service;

import com.birichani.code.restapi.constant.InfoMessage;
import com.birichani.code.restapi.model.Video;
import com.birichani.code.restapi.repository.VideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

/**
 * @author - JoeSeff
 * @created - 23/10/2020 00:08
 */
@ExtendWith(MockitoExtension.class)
class VideoServiceTest {
    
    @Mock
    private VideoRepository videoRepository;
    
    @InjectMocks
    private VideoService videoService;
    
    List<Video> videoList;
    Video goneIn60Seconds, transporter, whiteHouseDown, loveAtFirstHiccup;
    Video blended, pyaarImpossible, iAmInLoveWithAChurchGirl, saw, houseOfWax;
    Video exorcismOfEmilyRose, mrBones, funWithDickAndJane, weAreTheMillers, threeIdiots;
    
    @BeforeEach
    void setup() {
        goneIn60Seconds = new Video(1L, "Gone in 60 Seconds", "None", "Thriller");
        transporter = new Video(2L, "Transporter", "None", "Action");
        whiteHouseDown = new Video(3L, "White House Down", "None", "Action");
        loveAtFirstHiccup = new Video(4L, "Love at First Hiccup", "None", "Romance Comedy");
        blended = new Video(5L, "Blended", "None", "Romance Comedy");
        pyaarImpossible = new Video(6L, "Pyaar Impossible", "None", "Romance");
        iAmInLoveWithAChurchGirl = new Video(7L, "I am In Love with A Church Girl", "None", "Romance");
        saw = new Video(8L, "SAW", "None", "Horror");
        houseOfWax = new Video(9L, "House of Wax", "None", "Horror");
        exorcismOfEmilyRose = new Video(10L, "The Exorcism of Emily Rose", "None", "Horror");
        mrBones = new Video(11L, "Mr Bones", "None", "Comedy");
        funWithDickAndJane = new Video(12L, "Mr Bones", "None", "Comedy");
        weAreTheMillers = new Video(13L, "We Are The Millers", "None", "Comedy");
        threeIdiots = new Video(14L, "3 Idiots", "None", "Comedy");
    
        videoList = Arrays.asList(goneIn60Seconds, transporter, whiteHouseDown, loveAtFirstHiccup,
                blended, pyaarImpossible, iAmInLoveWithAChurchGirl, saw, houseOfWax, exorcismOfEmilyRose, mrBones,
                funWithDickAndJane, weAreTheMillers, threeIdiots);
    }
    
    @Test
    @DisplayName("Test That Correct Video Topic Is Returned")
    void testThatCorrectVideoTopicIsReturned() {
        String response = videoService.getVideosByTopic("Java");
        assertEquals(InfoMessage.JAVA_RESPONSE_MESSAGE, response);
    }
    
    @Test
    @DisplayName("Filter videos based on topic attribute")
    void shouldFilterVideosByTitle() {
        // when
        when(videoRepository.findAll()).thenReturn(videoList);
        
        // then
        List<Video> filteredVideoList = videoService.filterVideosByTopic("Horror");
        assertThat(filteredVideoList).containsExactlyInAnyOrder(saw, houseOfWax, exorcismOfEmilyRose);
    }
    
    
    
}