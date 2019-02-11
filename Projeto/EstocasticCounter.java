package mpei;

public class EstocasticCounter {
	private int counter;
	
	EstocasticCounter(){
		this.counter = 0;
	}
	
	public void increment() {
		double r = Math.random();
		if(r > 0.5)
			counter++;
	}
	
	public int getCounter() { return counter * 2; }
}