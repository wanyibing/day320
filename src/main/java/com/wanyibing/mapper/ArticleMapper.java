package com.wanyibing.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.wanyibing.entity.Article;

public interface ArticleMapper {

	@Insert("insert into article values(null,#{aname},#{address})")
	void addA(Article article);

	@Select("select * from article")
	List<Article> getlist();

}
