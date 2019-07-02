package com.odaguiri.articles.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.odaguiri.articles.domain.Article;
import com.odaguiri.articles.dto.ArticleDto;
import com.odaguiri.articles.service.ArticleService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ArticleController {
	
	private final ArticleService articleService;
	
	@Autowired
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@RequestMapping(path = "/v1/articles")	
	public List<ArticleDto> findAll() {
		return articleService.findAll();
	}
	
	@RequestMapping(path = "/v1/articles/{id}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Article not found") })
	public ArticleDto getArticle(@PathVariable("id") Long id) {
		return articleService.getById(id);
	}
	
	@PostMapping(path = "/v1/articles")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Article created") })
	public void save(@Valid @RequestBody ArticleDto article) {
		
	}
	
}
