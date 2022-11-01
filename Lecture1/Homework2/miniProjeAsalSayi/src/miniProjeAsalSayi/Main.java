package miniProjeAsalSayi;

public class Main {

	public static void main(String[] args) {
		int number = 23;
		// int remainder = numbers % 2;
		// System.out.println(remainder);
		boolean isPrime = true;

		if(number < 2) {
			System.out.println("Geçersiz Sayı Girdiniz");
			return;
		}
		
			for (int i = 2; i < number; i++) {
				if (number % i == 0) {
					isPrime = false;
				}
			}

			if (isPrime) {
				System.out.println("Sayı Asaldır " + number);
			} else {
				System.out.println("Sayı Asal Değildir " + number);
			}
		
	}

}
