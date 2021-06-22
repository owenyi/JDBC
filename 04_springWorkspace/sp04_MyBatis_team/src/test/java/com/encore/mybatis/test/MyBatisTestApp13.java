package com.encore.mybatis.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.encore.mybatis.book.BookDAO;
import com.encore.mybatis.book.BookService;
import com.encore.mybatis.vo.Book;

public class MyBatisTestApp13 {
	///Main method
	public static void main(String[] args) throws Exception{

		ApplicationContext context =
			new ClassPathXmlApplicationContext(
							new String[] {	"/config/bookservice13.xml"	 }
								                                                    );
	//==> IoC Container 로 부터 획득한 UserDAO 인스턴스 획득
	BookService bookService = (BookService)context.getBean("myBatisBookServiceImpl13");
	
	Book book = new Book();
	book.setAuthor("베르나르베르베르");
	book.setCatalogue("aaa");
	book.setCurrency("bbb");
	book.setDescription("ccc");
	book.setIsbn("191-191-191");
	book.setNation("프랑스");
	book.setPrice(20000);
	book.setPublishDate("1995-12-05");
	book.setPublisher("ddd");
	book.setTitle("개미");	
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//1.UserService.addBook(book) Test
	System.out.println(":: 1. add(INSERT)  ? ");
	bookService.addBook(book);
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//2.BookService.getBook(isbn) Test
	book = bookService.getBook("191-191-191");
	System.out.println(":: 2. get(SELECT)  ? "+book);
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//3.BookService.uadateBook(book) Test                                :: 주몽 ==> 온달 수정
	book.setTitle("신");
	System.out.println(":: 3. update(UPDATE)  ? ");
	bookService.updateBook(book);
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//4.BookService.getBook(isbn) Test
	book = bookService.getBook("191-191-191");
	System.out.println(":: 2. get(SELECT)  ? "+book);

	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//5.BookDAO.removeBook(isbn) Test
	//==> BookService에는 removeBook이 없으므로, DAO에서 직접 호출 Test
	BookDAO bookDAO = (BookDAO)context.getBean("myBatisBookDAOImpl13");
	System.out.println(":: 5. remove(DELETE)  ? "+bookDAO.removeBook("191-191-191"));
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//6.BookService.getBookList() Test
	System.out.println(":: 6. all Book(SELECT)  ? ");
	List<Book> list = bookService.getBookList(new Book());
	for (int i =0 ;  i < list.size() ; i++) {
		System.out.print( "<"+ ( i +1 )+"> 번째 책 정보... ");
		System.out.println( list.get(i).toString() );
	}
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		
	}//end of main
}//end of class