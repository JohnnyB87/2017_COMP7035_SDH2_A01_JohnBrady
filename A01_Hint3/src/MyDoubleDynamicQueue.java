
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
			System.out.println("ERROR: list is empty.");
			return null;
		}
		return this.head.getInfo();
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: addByFirst 
	//-------------------------------------------------------------------
	public void addByFirst(T element){
		if(this.head == null) {
			this.head = new MyDoubleLinkedNode<>(null, element, null);
			this.tail = this.head;
		}
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
		MyDoubleLinkedNode<T> currentNode;
		MyDoubleLinkedNode<T> nextNode;
		this.numItems--;
		if(this.numItems <= 0) {
			System.out.println("ERROR: list is empty.");
			this.numItems = 0;
			this.tail.setInfo(null);
			this.head.setInfo(null);
		}
		else{
			currentNode = this.head;
			nextNode = currentNode.getRight();
			this.head = nextNode;
		}
	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyQueue: last
	//-------------------------------------------------------------------
	public T last(){
		if(this.numItems == 0) {
			System.out.println("ERROR: list is empty.");
			return null;
		}
		return this.tail.getInfo();
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: addByLast 
	//-------------------------------------------------------------------
	public void addByLast(T element){
		if(this.tail == null){
			this.tail = new MyDoubleLinkedNode<>(null,element,null);
			this.head = this.tail;
		}
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
		MyDoubleLinkedNode<T> currentNode;
		MyDoubleLinkedNode<T> nextNode;
		this.numItems--;
		if(this.numItems <= 0) {
			System.out.println("ERROR: list is empty.");
			this.numItems = 0;
			this.tail.setInfo(null);
			this.head.setInfo(null);
		}
		else{
			currentNode = this.tail;
			nextNode = currentNode.getLeft();
			this.tail = nextNode;
		}
	}

	public String toString(){
		String str = "[";
		int count = 0;
		MyDoubleLinkedNode<T> currentNode = this.head;

		while(count < this.numItems){
			str = count < this.numItems-1 ? str + currentNode.getInfo() + ", ": str + currentNode.getInfo();
			currentNode = currentNode.getRight();
			count++;
		}
		System.out.println(this.head.getInfo() + " " + this.tail.getInfo());
		return str + "]";
	}
}
