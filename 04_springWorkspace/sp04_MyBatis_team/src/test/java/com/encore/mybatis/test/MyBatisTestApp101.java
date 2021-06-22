package com.encore.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.encore.mybatis.vo.Book;
/*
 * FileName : MyBatisTestApp101.java
  * ㅇ SqlMapConfig01.xml / mybatis-userservice-mapping10.xml
  * ㅇ TestUtil.java 을 이용 Test . 
  * ㅇ 이거 돌아가면 MyBatis Framework 단위테스트는 잘 된거다...mybatis-userservice-mapping10.xml은 문제 없다.
  * 
  * ㅇ 다음은 Persistance Logic 단위테스트 : MyBatisTestApp102.java
  * ㅇ MyBatisUserDAOImpl10 / UserADO 추가해야한다.
  */
public class MyBatisTestApp101 {
	///Main method
	public static void main(String[] args) throws Exception{
		
		SqlSession session = null;
		//==> TestUtil 의 getSqlSessionFactory()을 이용 SqlSessionFactory instance GET
		SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
		session=factory.openSession();
		
		//==> Test 용 Book instance 생성  
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
		
		//1. Book10.addBook Test
		System.out.println(":: 1. addBook(INSERT)  ? "
													+ session.insert("Book10.addBook", book));
													  session.commit();
		//2. Book10.getBook Test :: 개미 inert 확인 
		System.out.println(":: 2. getBook(SELECT)  ? ");
		System.out.println(" :: "+session.selectOne("Book10.getBook", book.getIsbn()) );
		
		
		//3. Book10.uadateBook Test
		//                                                    :: 주몽 ==> 온달 수정
		book.setTitle("신");
		System.out.println(":: 3. update(UPDATE)  ? "
													+ session.update("Book10.updateBook", book));
											  		  session.commit();
		 
		//4. Book10.getUserList Test  :: Dynamic Query 확인 isbn="111-222-333"/title="신" 검색
		System.out.println(":: 4. getBookList(SELECT)  ? ");
		TestUtil.printList( (List)session.selectList("Book10.getBookList", book) );
		
		//5. Book10.removeUser Test
		System.out.println(":: 5. Book10.removeBook (DELETE)  ? "
								+session.delete("Book10.removeBook", book.getIsbn()) );//1
								 session.commit();
		
		//6. Book10.getBookList Test  :: Dynamic Query 확인 isbn="111-222-333"/title="신" 검색
		System.out.println(":: 6. getBookList(SELECT)  ? ");
		TestUtil.printList((List) session.selectList("Book10.getBookList", book) ); //이때 위의 기능 리턴타입이 0인걸 확인하자
	
		//7. Book10.getBookList Test  :: Dynamic Query 확인 id=null/name=null 인경우
		book.setIsbn(null);
		book.setTitle(null);
		System.out.println(":: 7. getBookList(SELECT)  ? ");
		TestUtil.printList( (List) session.selectList("Book10.getBookList", book) );
		
		// 추가 Dynamic Query
		//8. Book10.getBookList Test :: price
		book.setIsbn(null);
		book.setTitle(null);
		book.setPrice(20000);
		book.setPublishDate(null);
		book.setNation(null);
		System.out.println(":: 8. getBookList(SELECT)  ? ");
		TestUtil.printList( (List) session.selectList("Book10.getBookList", book) );
		
		//9. Book10.getBookList Test :: publish_date
		book.setIsbn(null);
		book.setTitle(null);
		book.setPrice(0);
		book.setPublishDate("2021");
		book.setNation(null);
		System.out.println(":: 9. getBookList(SELECT)  ? ");
		TestUtil.printList( (List) session.selectList("Book10.getBookList", book) );
		
		//10. Book10.getBookList Test :: nation
		book.setIsbn(null);
		book.setTitle(null);
		book.setPrice(0);
		book.setPublishDate(null);
		book.setNation("한국");
		System.out.println(":: 10. getBookList(SELECT)  ? ");
		TestUtil.printList( (List) session.selectList("Book10.getBookList", book) );
		
	}//end of main
}//end of class




