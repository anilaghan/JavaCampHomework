
public abstract class BaseCreditManager implements CreditService {
	public abstract void Calculate();

	public void Save(){
		System.out.println("Kaydedildi");
	}
}
