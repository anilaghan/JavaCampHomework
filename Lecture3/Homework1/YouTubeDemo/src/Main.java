
public class Main {

	public static void main(String[] args) {
//		CreditManager creditManager = new CreditManager();
//		creditManager.Calculate();
//		creditManager.Calculate();
//		creditManager.Save();
//
//		Customer customer = new Customer();
//		customer.id = 1;
//		customer.city = "Ankara";
//
//		CustomerManager customerManager = new CustomerManager(customer);
//		customerManager.Save();
//		customerManager.Delete();
//
//		Company company = new Company();
//		company.TaxNumber = "1341564";
//		company.CompanyName = "Arçelik";
//		company.id = 100;
//		
//		CustomerManager customerManager2 = new CustomerManager(company);
//
//		Person person = new Person();
//		person.nationalIdentity = "4654646";
//		person.firstName = "Engin";
//		person.lastName = "Demiroğ";
//
//		Customer c1 = new Customer();
//		Customer c2 = new Person();
//		Customer c3 = new Company();
		
		CustomerManager customerManager = new CustomerManager(new Customer(), new TeacherCreditManager());
		customerManager.GiveCredit();
	}

}
