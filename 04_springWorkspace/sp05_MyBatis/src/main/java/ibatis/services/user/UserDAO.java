package ibatis.services.user;

import java.util.List;

import ibatis.services.domain.User;

/*
 * 비지니스 로직의 템플릿이 들어있는 인터페이스
 * 재사용성을 높이기 위해서는
 * 1) 인터페이스와 연결
 * 2) 실체 클래스의 객체 생성을 DI 컨테이너에게 맡긴다...
 *    개발자는 주문서 작성만 한다.
 *    
 *    mybatis-userservice-mapping10.xml
 *    설정문서를 보고 비지니스 로직 몇 개 정의해야 하는지 판단한다...보통 5개
 *    
 *    메소드 이름은    mybatis-userservice-mapping10.xml의 아이디 값
 *    메소드 인자값은	mybatis-userservice-mapping10.xml의 parameterType 참고
 *    메소드 리턴값은	mybatis-userservice-mapping10.xml의 resultType 참고
 */
public interface UserDAO {
	int addUser(User user) throws Exception;
	int updateUser(User user) throws Exception;
	int removeUser(String userId) throws Exception;
	User getUser(String userId) throws Exception;
	List<User> getUserList(User user) throws Exception;
}
