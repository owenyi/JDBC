package com.encore.mybatis.book.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.mybatis.book.BookDAO;
import com.encore.mybatis.book.BookService;
import com.encore.mybatis.vo.Book;

@Service
public class MyBatisBookServiceImpl13 implements BookService {
	@Autowired
	private BookDAO bookDAO;

	@Override
	public void addBook(Book book) throws Exception {
		bookDAO.addBook(book);
	}

	@Override
	public void updateBook(Book book) throws Exception {
		bookDAO.updateBook(book);
	}

	@Override
	public Book getBook(String isbn) throws Exception {
		return bookDAO.getBook(isbn);
	}

	@Override
	public List<Book> getBookList(Book book) throws Exception {
		return bookDAO.getBookList(book);
	}

}
