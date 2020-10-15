package com.birichani.code.restapi.repository;

import com.birichani.code.restapi.model.Video;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author - JoeSeff
 * @created - 16/10/2020 02:02
 */

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
class VideoRepositoryTest {
    
    @Autowired private VideoRepository videoRepository;
    private final Faker faker = new Faker(Locale.ENGLISH);
    
    @Test
    void testThatRecordsAreInserted() {
        assertNotNull(videoRepository);
    
        for (int i = 0; i < 5; i++) {
            videoRepository.save( new Video(faker.name().title(), faker.lorem().paragraph()) );
        }
        
        assertEquals(5, videoRepository.count());
    }
}
