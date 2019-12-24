package com.wanyibing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanyibing.entity.Article;
import com.wanyibing.mapper.ArticleMapper;
import com.wanyibing.service.ArticleService;

@Service
public class ArticleServiceimpl implements ArticleService {

	@Autowired
	ArticleMapper mapper;

	@Override
	public void addA(Article article) {
		// TODO Auto-generated method stub
		mapper.addA(article);
	}
	
	@Override
	public List<Article> getlist() {
		// TODO Auto-generated method stub
		return mapper.getlist();
	}	
}

