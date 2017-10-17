
public class MyStaticQueue implements MyQueue {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private int items[];
	private int numItems;
	private int maxItems;

	//-------------------------------------------------------------------
	// Basic Operation --> Check if myQueue is empty: myCreateEmpty
	//-------------------------------------------------------------------	
	public MyStaticQueue(int m){
		this.items = new int[m];
		this.numItems = 0;
		this.maxItems = m;
	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyQueue is empty: isEmpty
	//-------------------------------------------------------------------	
	public boolean isEmpty(){
		return this.numItems == 0;
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyQueue: first
	//-------------------------------------------------------------------
	public int first(){
		if(this.numItems == 0) {
			System.out.println("Queue is empty.");
			return -1;
		}
		return this.items[0];
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Add element to back of MyQueue: add 
	//-------------------------------------------------------------------
	public void add(int element){
		if (this.numItems == this.maxItems) 
			System.out.println("Queue is full.");
		else {
			this.items[this.numItems] = element;
			this.numItems++;
		}
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: remove 
	//-------------------------------------------------------------------	
	public void remove(){
		if(this.numItems > 0) {
			for(int i=1; i<this.numItems; i++) 
				this.items[i-1] = this.items[i];
			this.numItems--;
		}
		else
			System.out.println("Array is empty");
	}
	
	public String toString() {
		String str = "";
		for(int i=0; i<items.length; i++) 
			str = i < this.items.length-1 ?
					str + this.items[i]+", ": str + this.items[i];
		return str;
	}
}
