
public class MyDynamicQueue implements MyQueue {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private MyNode head;
	private int numItems;
	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyQueue is empty: myCreateEmpty
	//-------------------------------------------------------------------		
	public MyDynamicQueue(){
		this.head = null;
		this.numItems = 0;
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
			System.out.print("ERROR: List is empty.");
			return -1;
		}
		return this.head.getInfo();
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: add 
	//-------------------------------------------------------------------
	public void add(int element){
		if(this.numItems == 0)
			this.head = new MyNode(element, null);
		else {
			MyNode previousNode = null;
			MyNode currentNode = this.head;
			MyNode newNode = null;
			int count = 0;
			
			while(count < this.numItems) {
				previousNode = currentNode;
				currentNode = currentNode.getNext();
				count++;
			}
			
			newNode = new MyNode(element,null);
			previousNode.setNext(newNode);
		}
		this.numItems++;
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: remove 
	//-------------------------------------------------------------------	
	public void remove(){
		if(this.head == null) 
			System.out.println("ERROR: List is empty.");
		else {
			this.head = head.getNext();
			numItems--;
		}
	}

}
