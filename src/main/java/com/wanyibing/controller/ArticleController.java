package com.wanyibing.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wanyibing.entity.Article;
import com.wanyibing.service.ArticleService;

@Controller
public class ArticleController {

	@Autowired
	ArticleService service;
	
	@RequestMapping("add")
	public String add() {
		
		return "add";
	}
	
	
	@RequestMapping("addArticle")
	public String addArticle(HttpServletRequest request,@RequestParam("f")MultipartFile file,Article article) {
		
		
		try {
			File path = new File("D:\\晋向阳"+file.getOriginalFilename());
			
			if(!path.exists()) {
				path.mkdirs();
			}
			
			file.transferTo(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path1="D:\\晋向阳"+"\\"+file.getOriginalFilename();
		article.setAddress(path1);
		System.out.println(article.getAddress());
		
		service.addA(article);
		return "redirect:list";
	}
	
	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		
		List<Article> articles  = service.getlist();
		
		request.setAttribute("list", articles);
		
		return "list";
	}
	
}
