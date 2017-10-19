
public class MyDoubleDynamicQueue<T> implements MyQueue<T> {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	MyDoubleLinkedNode<T> head;
	MyDoubleLinkedNode<T> tail;
	int numItems;
	int tailItems;
	int headItems;
	
	//-------------------------------------------------------------------
	// Basic Operation --> Check if myQueue is empty: myCreateEmpty
	//-------------------------------------------------------------------	
	public MyDoubleDynamicQueue(){
		this.numItems = 0;
		this.headItems = 0;
		this.tailItems = 0;
		this.head = null;
		this.tail = null;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Check if myQueue is empty: isEmpty
	//-------------------------------------------------------------------	
	public boolean isEmpty(){
		return this.numItems == 0;
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyQueue: first
	//-------------------------------------------------------------------
	public T first(){
		return this.head.getInfo();
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: addByFirst 
	//-------------------------------------------------------------------
	public void addByFirst(T element){
		if(this.head == null && this.tail == null) {
			this.head = new MyDoubleLinkedNode<T>(null, element, this.tail);
			this.tail = new MyDoubleLinkedNode<T>(this.head, null, null);
		}
		else {
			MyDoubleLinkedNode<T> currentNode = this.head;
			this.head = new MyDoubleLinkedNode<T>(null,element,currentNode);
			currentNode.setLeft(this.head);

		}
		this.numItems++;
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: removeByFirst 
	//-------------------------------------------------------------------	
	public void removeByFirst(){

	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyQueue: last
	//-------------------------------------------------------------------
	public T last(){
		return this.tail.getInfo();
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: addByLast 
	//-------------------------------------------------------------------
	public void addByLast(T element){

	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: removeByFirst 
	//-------------------------------------------------------------------	
	public void removeByLast(){

	}

}
