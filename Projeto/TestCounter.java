package mpei;

public class TestCounter {

	public static void main(String[] args) {
		EstocasticCounter counter;
		int[] result = new int[100];
		
		for(int i = 0; i < 100; i++) {
			counter = new EstocasticCounter();
			for(int j = 0; j < 1000000; j++) {
				counter.increment();
			}
			result[i] = counter.getCounter();
		}
		
		int expected = 1000000;
		int erroTotal = 0;
		for (int i = 0; i < result.length; i++) {
			int erro = Math.abs(expected - result[i]);
			erroTotal += erro;
			System.out.printf("%3d | %7d | %4d | \n", i + 1, result[i], erro);
		}
		System.out.println("---------------------");
		System.out.println("Media de erro -> " + erroTotal/100);
		System.out.println("Percentagem de erro -> " + ((double) erroTotal)/1000000 + "%");
	}

}
