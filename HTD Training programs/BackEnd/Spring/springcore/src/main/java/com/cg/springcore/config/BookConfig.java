package com.cg.springcore.config;

import org.springframework.context.annotation.Bean;

import com.cg.springcore.beans.Author;
import com.cg.springcore.beans.Book;

public class BookConfig {
	@Bean("book")
	public Book getBook() {
		Book book=new Book();
		book.setBookname("Wings of fire");
		return book;
	}
	@Bean("author")
	public Author getAuthor() {
		Author author=new Author();
		author.setName("APJ Kalam");
		return author;
	}

}
