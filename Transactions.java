
public class Transactions {
	private String currentBalance;
	private String[] history = new String[5];
	int i = 0;

	public void initArray() {
		for (int j = 0; j < 4; j++)
			history[j] = "Unknown, end of history";
	}

	public void setCurrentBalance(String balance) {
		currentBalance = balance;
	}

	public String getCurrentBalance2() {
		if (i > 4) {
			i = 4;
			for (int z = 0; z < 4; z++)
				history[z] = history[z + 1];
		}
		history[i] = "Balance inquiry";
		i++;
		return currentBalance;
	}

	public String getCurrentBalance() {
		return currentBalance;
	}

	public void withdraw(String amount) {
		int currentBalanceAsInt;
		currentBalanceAsInt = Integer.parseInt(currentBalance) - Integer.parseInt(amount);
		currentBalance = Integer.toString(currentBalanceAsInt);
		if (currentBalanceAsInt > 0) {
			if (i > 4) {
				i = 4;
				for (int z = 0; z < 4; z++)
					history[z] = history[z + 1];
			}
			history[i] = "Withdrawal : " + amount;
			i++;
		}

	}

	public void deposit(String amount) {
		int currentBalanceAsInt = Integer.parseInt(currentBalance) + Integer.parseInt(amount);
		currentBalance = Integer.toString(currentBalanceAsInt);
		if (i > 4) {
			i = 0;
			for (int z = 0; z < 4; z++)
				history[z] = history[z + 1];
		}
		history[i] = "Deposit : " + amount;
		i++;
	}

	public String prev() {
		try {
			return history[--i];
		} catch (ArrayIndexOutOfBoundsException e) {
			return "Unknown, end of history";
		}
	}

	public String next() {

		try {
			return history[++i];
		} catch (ArrayIndexOutOfBoundsException e) {
			return "Unknown, end of history";
		}
	}
}
