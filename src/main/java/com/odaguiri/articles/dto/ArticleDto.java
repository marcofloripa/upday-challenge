package com.odaguiri.articles.dto;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ArticleDto {

	private Long id;
	
	private String header;
	private String shortDescription;
	private String text;
	
	private LocalDateTime publishDate;
	
	private Set<KeywordDto> keywords;
}
