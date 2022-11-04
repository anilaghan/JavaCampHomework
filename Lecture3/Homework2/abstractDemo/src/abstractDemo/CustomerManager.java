package abstractDemo;

public class CustomerManager {
	BaseDatabaseManager dataBaseManager;
	
	public void getCustomers() {
		dataBaseManager.getData();
	}
}
