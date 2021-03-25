package broker.three.shares;

import java.util.ArrayList;
import java.util.Collection;
/*
 * Result 클래스는 한 칸짜리 ArrayList...왜 한 칸짜리인가??
 * 성공/실패 여부를 확인할 수 있는 status 값을 갖고 있고
 * db에서 받아오는 결과값을 담을 수 있는 모듈
 */
public class Result extends ArrayList { // 결과가 어떤지 (-) or (0) 빈 통 보내고 결과값 받아올 통
	
	private int status = -1; // 기본값...일이 잘 안된 경우를 디폴트...프로그램은 보수적이여야 하니까

	public Result() {
		super(1);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
