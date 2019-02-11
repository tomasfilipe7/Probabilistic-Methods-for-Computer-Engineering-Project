package mpei;

import java.io.*;
import java.util.*;

public class CreateFile {
		int tele, price, store = 0;
		List <Integer> lojadaesquina = new ArrayList<>();
		List <Integer> phonehouse = new ArrayList<>();
		List <Integer> compraaqui = new ArrayList<>();
		List <Integer> cheapsales = new ArrayList<>();
		List <Integer> tele4u = new ArrayList<>();
		

		public void createFile() throws IOException {
			File f = new File("src/Projeto/phones.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
			for(int i = 0; i < 1000; i++) {
				store = (int) (Math.random() * 5);
				tele = (int) (Math.random() * 40);
				price = (int) (Math.random() * 600) + 200;	
			
				PHONES[] p = PHONES.values();
				STORES[] stores = STORES.values();
			
				switch(store) {
					case 0:
						if(this.lojadaesquina.contains(tele)) {
							break;
						}
						lojadaesquina.add(tele);
						bw.write(stores[store] + "\t" + p[tele] + "\t" + price + "\n");
						break;	
					case 1:
						if(phonehouse.contains(tele)) {
							break;
						}
						phonehouse.add(tele);
						bw.write(stores[store] + "\t" + p[tele] + "\t" + price + "\n");
						break;
					case 2:
						if(compraaqui.contains(tele)) {
							break;
						}
						compraaqui.add(tele);
						bw.write(stores[store] + "\t" + p[tele] + "\t" + price + "\n");
						break;
					case 3:
						if(cheapsales.contains(tele)) {
							break;
						}
						cheapsales.add(tele);
						bw.write(stores[store] + "\t" + p[tele] + "\t" + price + "\n");
						break;
					case 4:
						if(tele4u.contains(tele)) {
							break;
						}
						tele4u.add(tele);
						bw.write(stores[store] + "\t" + p[tele] + "\t" + price + "\n");
						break;
					default: break;	
				}
			
			}
			bw.close();
		}
		
}