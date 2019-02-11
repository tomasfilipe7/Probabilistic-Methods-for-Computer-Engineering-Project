package mpei;

import java.util.*;

public class Teste_BF {
	
	static BloomFilter filter = new BloomFilter(10, 100000);
	
	public static void main(String[] args) {	
		int escolha = 0;
		
		Scanner menu = new Scanner(System.in);
			
		do{
			System.out.println("|-----------------------------------------------|");
			System.out.println("|              Teste BloomFilter                |");
			System.out.println("|-----------------------------------------------|");
			System.out.println("| 1 - Adicionar valores                         |");
			System.out.println("| 2 - Verificar se valor pertence               |");
			System.out.println("| 3 - Contar quantas vezes aparece o valor      |");
			System.out.println("| 4 - Remover valor                             |");
			System.out.println("| 5 - Testar BloomFilter com strings aleatorias |");
			System.out.println("| 6 - Sair do programa                          |");
			System.out.println("|_______________________________________________|");
			
			System.out.print("Escolha: ");		
			
			try {
				escolha = menu.nextInt();
			}catch(Exception e) {
				System.err.println("Insira um numero!");
			}
			
			switch(escolha) {
			
			case 1:	{
				addValores();
				escolha = 0;
				break;
			}
			case 2:	{
				verificar();
				escolha = 0;
				break;
			}
			case 3: {
				contar();
				escolha = 0;
				break;
			}
			case 4: {
				remove();
				escolha = 0;
				break;
			}
			case 5: {
				testBloom();
				escolha = 0;
				break;
			}
			case 6: System.exit(0);
			default: 
				escolha = 0;
			}
			
		}while(true);			
		
	}
	
	public static void addValores() {
		Scanner introduz = new Scanner(System.in);
		String valor;
		
		System.out.println("Valor: ");
		valor = introduz.next();
		filter.insert(valor);
	}

	public static void verificar() {
		Scanner verScan = new Scanner(System.in);
		String verificar;
		
		System.out.println("Verificar: ");
		verificar = verScan.next();
		
		if(filter.isMember(verificar) == false) {
			
			System.out.println("Nao contem");
		}
		else {
			System.out.println("Contem");
		}
		
	}
	
	public static void remove() {
		Scanner rem = new Scanner(System.in);
		System.out.println("Remover: ");
		String s = rem.nextLine();
		filter.remove(s);
	}
	
	public static void contar() {
		Scanner count = new Scanner(System.in);
		String contar;
		System.out.println("Valor: ");
		
		contar = count.next();
		filter.countValue(contar);
		
	}
	
	private static String randomString(int size) {
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVXYZ";
		String s = "";
		
		for(int i = 0; i < size; i++) {
			int rand = (int) (Math.random() * alphabet.length());
			char c = alphabet.charAt(rand);
			s += "" + c;
		}
		
		return s;
	}
	
	public static void testBloom() {					// insere 10000 strings aleatorias ao bloomfilter e
		System.out.println("Testar BloomFilter");		// verifica de outras 1000000 strings pertencem ao bloom
		
		for(int i = 0; i < 10000; i++) {
			String temp = randomString(50);
			filter.insert(temp);
		}
		
		int falsePositives = 0;
		System.out.println("Verificando...");
		for(int i = 0; i < 1000000; i++) {
			String rand = randomString(50);
			if(filter.isMember(rand)) {
				falsePositives++;
			}
		}
		System.out.println("Terminado!\n");
		
		System.out.println("Falsos positivos em 1000000 strings aleatorias: " + falsePositives);
		double percentagem = ((double) falsePositives )/10000000 ;
		System.out.printf("Percentagem de falsos positivos: %1.5f %%  \n", percentagem);
	}
}
