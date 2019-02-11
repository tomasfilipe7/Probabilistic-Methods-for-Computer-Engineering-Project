package mpei;
import java.util.*;

public class MinHash {
	private final int shingLength = 3;
	private final double threshold = 0.8;
	private int numHash;
	private List<Elemento> elem;
	private int[] values_a;
	private int[] values_b;
	
	public MinHash(int numHash) {
		this.numHash = numHash;
		this.elem = new ArrayList<>();
		this.values_a = new int[numHash];
		this.values_b = new int[numHash];
		for(int i = 0; i < numHash; i++) {
			values_a[i] = (int) (Math.random() * 104728) + 1;
			values_b[i] = (int) (Math.random() * 104728) + 1;
		}
	}
	
	public void add(String texto) {
		elem.add(GetMinHash(texto));
	}
	
	public Elemento GetMinHash(String texto) {
		Elemento e = new Elemento(texto, numHash);

		for(int i = 0; i < texto.length() - shingLength; i++) {
			String shingle = "";
			
			for(int j = 0; j < shingLength; j++) {
				shingle += texto.charAt(i + j);
			}
			
			int[] hashes = HashFunction.func(shingle, values_a, values_b);
			for(int j = 0; j<hashes.length; j++) {
				if(e.getRecord(j) > hashes[j] || e.getRecord(j) == -1) {
					e.setRecord(j, hashes[j]);
				}
			}
		}
				
		return e;
	}
	
	public boolean DistanciaJaccard(String alvo) {
		int find = 0;
		Elemento elemAlvo = GetMinHash(alvo);
		for(Elemento e : elem){
			int isEqual = 0;
			for(int k = 0; k < numHash; k++) {
				if(e.getRecord(k) == elemAlvo.getRecord(k)) {
					isEqual++;
				}
			}
			double distJaccard = 1 - ((double) isEqual/(double) numHash); 
			
			if(distJaccard < threshold) {
				System.out.printf("%s --> semelhante a: %s  | Dist. Jaccard: %f\n", alvo, e.getString(), distJaccard);
				find++;
			}
		}
		if(find > 0) return true;
		System.out.println("Nenhum elemento semelhante encontrado!");
		return false;
	}
	
	public List<String> isMember(String alvo) {
		List<String> members = new ArrayList<String>();
		Elemento elemAlvo = GetMinHash(alvo);
		System.out.println("\nSearching for \"" + alvo + "\":");
		for(Elemento e : elem){
			int isEqual = 0;
			for(int k = 0; k < numHash; k++) {
				if(e.getRecord(k) == elemAlvo.getRecord(k)) {
					isEqual++;
				}
			}
			double distJaccard = 1 - ((double) isEqual/(double) numHash); 
			
			if(distJaccard < threshold) {
				//System.out.printf("%s --> found: %s  \n", alvo, e.getString());
				members.add(e.getString());
			}
		}
		return members;
	}
	
}
