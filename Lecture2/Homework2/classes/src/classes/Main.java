package classes;

public class Main {

	public static void main(String[] args) {
		CustomerManager customerManager = new CustomerManager();
		CustomerManager customerManager2 = new CustomerManager();
		customerManager = customerManager2;
		customerManager.Add();
		customerManager.Remove();
		customerManager.Update();

		int [] sayilar1 = {1,2,3};
		int [] sayilar2 = {4,5,6};
		
		sayilar2=sayilar1;
		sayilar1[0]=10;
		
		System.out.println(sayilar2[0]);
	}

}
