package com.odaguiri.articles.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odaguiri.articles.domain.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
