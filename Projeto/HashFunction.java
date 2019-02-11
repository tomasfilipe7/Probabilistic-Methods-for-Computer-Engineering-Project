package mpei;

public class HashFunction { // (ax+b) % p -> a e b aleatorios, x inteiro (hashcode da string), p numero primo "grande"
	
	public static int[] func(String s, int[] a, int[] b, int length) {
		int[] hash = new int[a.length];
		for(int i = 0; i < hash.length; i++) {
			int p = 104729; 											// primo grande
			hash[i] = Math.abs((((a[i] * (s.hashCode()) + b[i]) % p) % length));
		}			
		return hash;
	}
	
	public static int[] func(String s, int[] a, int[] b) {
		int[] hash = new int[a.length];
		for(int i = 0; i < hash.length; i++) {
			int p = 104729; 											// primo grande
			hash[i] = Math.abs((((a[i] * (s.hashCode()) + b[i]) % p)));
		}			
		return hash;
	}
}

