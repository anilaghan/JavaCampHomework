
public class CustomerManager {
	private Customer customer;
	CreditService creditService;

	public CustomerManager(Customer customer, CreditService creditService) {
		this.customer = customer;
		this.creditService = creditService;
	}

	public void Save() {
		System.out.println("Müşteri Kaydedildi: ");
	}

	public void Delete() {
		System.out.println("Müşteri Silindi: ");
	}

	public void GiveCredit() {
		creditService.Calculate();
		System.out.println("Kredi Verildi");
	}
}
