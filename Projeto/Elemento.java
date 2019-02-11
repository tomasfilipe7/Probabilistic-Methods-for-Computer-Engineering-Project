package mpei;

public class Elemento {
	private int[] record;
	private String string;
	
	public Elemento(String string, int numHash) {
		this.string = string;
		record = new int[numHash];
		for(int i = 0; i < numHash; i++) {	
			record[i] = -1;
		}
	}

	public int getRecord(int index) {
		return record[index];
	}
	public void setRecord(int index, int value) {
		record[index] = value;
	}

	public String getString() {
		return string;
	}
}
