package loopDemo;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// For
		for (int i = 2; i < 10; i += 2) {
			System.out.println(i);
		}

		System.out.println("For Döngüsü bitti");

		int i = 1;
		// While
		while (i < 10) {
			System.out.println(i);
			i++;
		}

		System.out.println("While döngüsü bitti");
		
		//Do-while
		int j=100;
		do {
			System.out.println("Loglandı");
			System.out.println(j);
			j+=2;
		}while(j<10);
		
		System.out.println("Do-While döngüsü bitti");
	}

}
