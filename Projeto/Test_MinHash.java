package mpei;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Test_MinHash {
	static MinHash minhash;
	public static void main(String[] args) throws IOException {
		minhash = new MinHash(200);
		
		int escolha = 0;
		
		Scanner menu = new Scanner(System.in);
			
		do{
			System.out.println("|-------------------------------------------------|");
			System.out.println("|                 Teste MinHash                   |");
			System.out.println("|-------------------------------------------------|");
			System.out.println("| 1 - Adicionar valores                           |");
			System.out.println("| 2 - Procurar                                    |");
			System.out.println("| 3 - Ler ficheiro e procurar valores identicos   |");
			System.out.println("| 4 - Sair do programa                            |");
			System.out.println("|_________________________________________________|");
			
			System.out.print("Escolha: ");		
			
			try {
				escolha = menu.nextInt();
			}catch(Exception e) {
				System.err.println("Insira um numero!");
			}
			
			switch(escolha) {
			
			case 1:	{
				addValues();
				escolha = 0;
				break;
			}
			case 2:	{
				jaccard();
				escolha = 0;
				break;
			}

			case 3:	{
				if(readFile()) { 	// so faz a distancia de jaccard se conseguir ler o ficheiro
					jaccard();
				}
				escolha = 0;
				break;
			}
			case 4: System.exit(0);
			default: 
				escolha = 0;
			}
			
		}while(true);
	}
	
	public static void addValues() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserir: ");
		String s = sc.nextLine();
		
		minhash.add(s);
	}
	
	public static void jaccard() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nProcurar: ");
		String s = sc.nextLine();
		
		minhash.DistanciaJaccard(s);
		
	}
	
	public static boolean readFile() {					// lê ficheiro e adiciona todas as linhas ao MinHash
		Path path = Paths.get("src/mpei/voos.txt");
		try {
			List<String> lines = Files.readAllLines(path);
			
			lines.stream().flatMap(x -> Arrays.stream(x.split("\t")))
					      .forEach(x -> {
					    	  minhash.add(x);
					    	  System.out.println(x);
					      });
			return true;
			
		}catch(IOException e) {
			System.err.println("Impossivel ler ficheiro! " + e);
			return false;
		}
	}

}
