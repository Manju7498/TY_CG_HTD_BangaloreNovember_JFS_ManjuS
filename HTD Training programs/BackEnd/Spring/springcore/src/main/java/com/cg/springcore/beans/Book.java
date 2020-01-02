package com.cg.springcore.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Book {
	public Book() {
		
	}
	
	public Book(String bookname, Author author) {
		super();
		this.bookname = bookname;
		this.author = author;
	}

	private String bookname;
	@Autowired
	private Author author;
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
