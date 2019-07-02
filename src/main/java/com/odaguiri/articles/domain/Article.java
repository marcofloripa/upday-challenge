package com.odaguiri.articles.domain;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@Column
	private String header;
	
	@Column(name = "short_description")
	private String shortDescription;
	
	@Column
	private String text;
	
	@Column(name = "publish_date")
	@JsonIgnore
	private LocalDateTime publishDate = LocalDateTime.now();
	
	@ManyToMany
	@JoinTable(
		name = "article_keyword",
		joinColumns = @JoinColumn(name = "article_id"),
		inverseJoinColumns = @JoinColumn(name = "keyword_id"))
	private Set<Keyword> keywords;
}
