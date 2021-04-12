package datatype;

public class WhiteBoard {

	public int size;
	public char color;
	public float price;
	public String company;
	public boolean scratch;
	
	public void setFeild(int size, char color, float price, String company, boolean scratch) {
		this.size = size;
		this.color = color;
		this.price = price;
		this.company = company;
		this.scratch = scratch;
	}
	
	public String toString() {
		return size + "\t" + color + "\t" + price + "\t" + company + "\t" + scratch;
	}
	
}
