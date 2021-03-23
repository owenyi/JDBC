package exception.user.test;

import java.util.Scanner;

class AmountInputException extends Exception {

	AmountInputException() {
		this("10000원부터 입금 가능합니다.");
	}

	AmountInputException(String message) {
		super(message);
	}
	
}

class InvalidAmountException extends Exception {

	public InvalidAmountException() {
		this("잔액이 부족합니다.");
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
			System.out.println("입금됐습니다. 입금 후 잔액은 " + balance + "원 입니다.");
		}
	}
	
	public void withdraw(int amt) throws InvalidAmountException {
		if (amt > balance)
			throw new InvalidAmountException();

		else {
			balance -= amt;
			System.out.println("출금됐습니다. 출금 후 잔액은 " + balance + "원 입니다.");
		}
	}
}

public class BankAccountExceptionTest4 {

	public static void main(String[] args) {

		Account ac = new Account(10000);
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. 입금    2. 출금    3. 서비스 종료");
			int num = sc.nextInt();
			
			switch (num) {
				case 1:
					System.out.println("얼마를 입금하시겠습니까?");
					int amount1 = sc.nextInt();
					try {
						ac.deposit(amount1);
					} catch (AmountInputException e){
						System.out.println(e.getMessage());
					}
					break;
					
				case 2:
					System.out.println("얼마를 출금하시겠습니까?");
					int amount2 = sc.nextInt();
					try {
						ac.withdraw(amount2);
					} catch (InvalidAmountException e){
						System.out.println(e.getMessage());
					}
					break;
					
				case 3:
					System.out.println("이용해주셔서 감사합니다.");
					sc.close();
					return;
					
				default:
					System.out.println("잘못된 입력입니다.");
					break;
			}
		}

	}

}
