import java.util.Scanner;
public class CreditCard {
	Scanner scan=new Scanner(System.in);
	private String number="13";
	private String balance="0";
	public void setBalance(String newBalance)
	{
		balance=newBalance;
	}
	public String getNumber()
	{
		return number;
	}
	public String getBalance()
	{
		return balance;
	}
}