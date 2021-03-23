package exception.user.test;

import java.util.Scanner;

class AmountInputException extends Exception {

	AmountInputException() {
		this("10000������ �Ա� �����մϴ�.");
	}

	AmountInputException(String message) {
		super(message);
	}
	
}

class InvalidAmountException extends Exception {

	public InvalidAmountException() {
		this("�ܾ��� �����մϴ�.");
	}

	public InvalidAmountException(String message) {
		super(message);
	}
	
}

class Account {
	int balance;
	
	public Account(int balance) {
		super();
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}
	
	public void deposit(int amt) throws AmountInputException {
		if (amt < 10000)
			throw new AmountInputException();
		else {
			balance += amt;
			System.out.println("�Աݵƽ��ϴ�. �Ա� �� �ܾ��� " + balance + "�� �Դϴ�.");
		}
	}
	
	public void withdraw(int amt) throws InvalidAmountException {
		if (amt > balance)
			throw new InvalidAmountException();

		else {
			balance -= amt;
			System.out.println("��ݵƽ��ϴ�. ��� �� �ܾ��� " + balance + "�� �Դϴ�.");
		}
	}
}

public class BankAccountExceptionTest4 {

	public static void main(String[] args) {

		Account ac = new Account(10000);
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. �Ա�    2. ���    3. ���� ����");
			int num = sc.nextInt();
			
			switch (num) {
				case 1:
					System.out.println("�󸶸� �Ա��Ͻðڽ��ϱ�?");
					int amount1 = sc.nextInt();
					try {
						ac.deposit(amount1);
					} catch (AmountInputException e){
						System.out.println(e.getMessage());
					}
					break;
					
				case 2:
					System.out.println("�󸶸� ����Ͻðڽ��ϱ�?");
					int amount2 = sc.nextInt();
					try {
						ac.withdraw(amount2);
					} catch (InvalidAmountException e){
						System.out.println(e.getMessage());
					}
					break;
					
				case 3:
					System.out.println("�̿����ּż� �����մϴ�.");
					sc.close();
					return;
					
				default:
					System.out.println("�߸��� �Է��Դϴ�.");
					break;
			}
		}

	}

}
