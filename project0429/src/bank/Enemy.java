package bank;
class Enemy{
	public static void main(String[] args){
		Account acc= new Account();
		System.out.println(acc.master+"ÀÇ ÀÜ°í´Â "+acc.balance);
		acc.balance= acc.balance-acc.balance;
		System.out.println(acc.master+"ÀÇ ÀÜ°í´Â "+acc.balance);
	}
}