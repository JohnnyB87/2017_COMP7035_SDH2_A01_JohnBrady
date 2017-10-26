
public class MyDoubleDynamicQueue<T> implements MyQueue<T> {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private MyDoubleLinkedNode<T> head;
	private MyDoubleLinkedNode<T> tail;
	private int numItems;
	
	//-------------------------------------------------------------------
	// Basic Operation --> Check if myQueue is empty: myCreateEmpty
	//-------------------------------------------------------------------	
	public MyDoubleDynamicQueue(){
		this.numItems = 0;
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
		if(this.numItems == 0) {
			System.out.println("ERROR: List is empty.");
			return null;
		}
		return this.head.getInfo();
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: addByFirst 
	//-------------------------------------------------------------------
	public void addByFirst(T element){
		if(this.head == null)
			this.head = this.tail = new MyDoubleLinkedNode<>(null, element, null);
		else {
			MyDoubleLinkedNode<T> currentNode = this.head;
			this.head = new MyDoubleLinkedNode<>(null,element,currentNode);
			currentNode.setLeft(this.head);
		}
		this.numItems++;
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: removeByFirst 
	//-------------------------------------------------------------------	
	public void removeByFirst(){
		if(this.numItems == 0)
			System.out.println("ERROR: List is empty.");
		else {
			this.head = this.head.getRight();
			this.numItems--;
		}
	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyQueue: last
	//-------------------------------------------------------------------
	public T last(){
		if(this.numItems == 0) {
			System.out.println("ERROR: List is empty.");
			return null;
		}
		return this.tail.getInfo();
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: addByLast 
	//-------------------------------------------------------------------
	public void addByLast(T element){
		if(this.tail == null)
			this.head = this.tail = new MyDoubleLinkedNode<>(null,element,null);
		else{
			MyDoubleLinkedNode<T> currentNode = this.tail;
			this.tail = new MyDoubleLinkedNode<>(currentNode,element,null);
			currentNode.setRight(this.tail);
		}
		this.numItems++;
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: removeByFirst 
	//-------------------------------------------------------------------	
	public void removeByLast(){
		if(this.numItems == 0)
			System.out.println("ERROR: List is empty.");
		else{
			this.tail = this.tail.getLeft();
			this.numItems--;
		}
	}

}
