package com.cg.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cg.springcore.beans.Author;
import com.cg.springcore.beans.Book;
import com.cg.springcore.config.BookConfig;

public class AuthorBookApp {

	public static void main(String[] args) {
		ApplicationContext context=new 
				AnnotationConfigApplicationContext(BookConfig.class);
		Author author=context.getBean(Author.class);
		System.out.println(author.getName());
		System.out.println("******************");
		Book book=context.getBean(Book.class);
		System.out.println(book.getBookname());
		System.out.println(book.getAuthor().getName());
	}

}
