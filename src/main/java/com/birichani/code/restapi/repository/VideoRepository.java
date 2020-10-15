package com.birichani.code.restapi.repository;

import com.birichani.code.restapi.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {

}
