package generic;
/*
 * 제네릭(generic) 프로그래밍
 *  : 변수의 선언이나 메서드의 매개변수를 하나의 참조 자료형이 아닌
 *    여러 자료형으로 변환 될 수 있도록 프로그래밍 하는 방식
     *컬렉션에 많이 사용됨
 */
public class ThreeDPrinterPlastic {

	private Plastic material;

	public Plastic getMaterial() {
		return material;
	}

	public void setMaterial(Plastic material) {
		this.material = material;
	}
	
}
