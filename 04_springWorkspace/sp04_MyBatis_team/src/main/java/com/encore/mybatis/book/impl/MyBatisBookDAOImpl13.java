package com.encore.mybatis.book.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.mybatis.book.BookDAO;
import com.encore.mybatis.vo.Book;

@Repository
public class MyBatisBookDAOImpl13 implements BookDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int addBook(Book book) throws Exception {
		int result = sqlSession.insert("Book10.addBook", book);
		return result;
	}

	@Override
	public int updateBook(Book book) throws Exception {
		int result = sqlSession.update("Book10.updateBook", book);
		return result;
	}

	@Override
	public int removeBook(String isbn) throws Exception {
		int result = sqlSession.delete("Book10.removeBook", isbn);
		return result;
	}

	@Override
	public Book getBook(String isbn) throws Exception {
		return sqlSession.selectOne("Book10.getBook", isbn);
	}

	@Override
	public List<Book> getBookList(Book book) throws Exception {
		return sqlSession.selectList("Book10.getBookList", book);
	}
	
}
