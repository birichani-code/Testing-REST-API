package com.birichani.code.restapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vid;
	private String title;
	private String description;
	private String link;
	
	public Video(String title, String description, String link) {
		this.title = title;
		this.description = description;
		this.link = link;
	}
}
