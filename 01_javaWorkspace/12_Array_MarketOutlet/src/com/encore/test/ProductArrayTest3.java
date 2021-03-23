package com.encore.test;

import com.encore.service.ProductStoreService;
import com.encore.vo.Product;

public class ProductArrayTest3 {

	public static void main(String[] args) {
		// service 객체 생성...service 클래스 기능들을 메모리에 올린다.
		ProductStoreService service = new ProductStoreService();
		
		Product[] pros = {
				new Product("댕기머리샴푸", 23000, 2, "LG"), 
				new Product("삼다수생수", 2000, 7, "HP"), 
				new Product("컵라면", 1200, 10, "SAMSUNG"),
				new Product("켓타워", 340000, 1, "LG")
		};
		
		System.out.println("======1. 모든 상품들의 메이커를 출력합니다..=======");
		service.printAllProductMaker(pros);
		
		System.out.println("======2. 모든 상품의 총 구입액을 받아옵니다..=======");
		System.out.println(service.getTotalPrice(pros));
		
		System.out.println("======3. 1만원 이상의 제품들을 받아옵니다.=======");
		Product[] returnPros = service.getMorePrice(pros, 10000);
		for (Product p : returnPros) {
			if (p == null) continue;
			System.out.println(p.getDetail());
			// if (p != null) System.out.println(p.getDetail());
		}
		
		System.out.println("======4. LG의 제품들을 받아옵니다.=======");
		Product[] returnPros1 = service.getCertainCompany(pros, "LG");
		for (Product p : returnPros1) {
			if (p == null) continue;
			System.out.println(p.getDetail());
		}
		
		System.out.println("======5. 제품들의 평균가입니다..=======");
		System.out.println(service.getAvgPrice(pros) + "원 입니다.");
	}

}
