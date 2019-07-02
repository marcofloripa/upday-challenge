package com.odaguiri.articles.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class KeywordDto {

	private Long id;
	
	private String content;
}
