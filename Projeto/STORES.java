package mpei;

public enum STORES {
	LOJADAESQUINA(1),
	PHONEHOUSE(2),
	COMPRAAQUI(3),
	CHEAPSALES(4),
	TELE4U(5);
	
	private int index;
	
	STORES(int i){
		this.index = i;
	}
	
	public int index() { return index; }
}
