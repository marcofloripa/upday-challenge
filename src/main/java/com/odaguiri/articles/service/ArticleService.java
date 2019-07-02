package com.odaguiri.articles.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odaguiri.articles.domain.Article;
import com.odaguiri.articles.dto.ArticleDto;
import com.odaguiri.articles.repo.ArticleRepository;

@Service
public class ArticleService {

	private final ArticleRepository articleRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public ArticleService(ArticleRepository articleRepository, ModelMapper modelMapper) {
		this.articleRepository = articleRepository;
		this.modelMapper = modelMapper;
	}
	
	public List<ArticleDto> findAll() {
		return articleRepository.findAll().stream()
				.map(article -> convertToDto(article))
				.collect(Collectors.toList());
	}
	
	public ArticleDto getById(Long id) {
		return convertToDto(articleRepository.findById(id).get());
	}
	
	public ArticleDto save(ArticleDto articleDto) {
		Article newArticle = articleRepository.save(convertToEntity(articleDto));
		return convertToDto(newArticle);
	}
	
	private ArticleDto convertToDto(Article article) {
		return modelMapper.map(article,  ArticleDto.class);
	}
	
	private Article convertToEntity(ArticleDto articleDto) {
		return modelMapper.map(articleDto,  Article.class);
	}
	
}
