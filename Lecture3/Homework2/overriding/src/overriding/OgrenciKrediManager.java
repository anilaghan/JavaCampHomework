package overriding;

public class OgrenciKrediManager extends BaseCreditManager{
	public double hesapla(double tutar) {
		return tutar*1.10;
	}
}
