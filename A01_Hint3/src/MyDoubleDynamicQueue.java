
public class MyDoubleDynamicQueue<T> implements MyQueue<T> {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	MyDoubleLinkedNode<T> head;
	MyDoubleLinkedNode<T> tail;
	MyDoubleLinkedNode<T> originalHead;
	MyDoubleLinkedNode<T> originalTail;
	int numItems;
	
	//-------------------------------------------------------------------
	// Basic Operation --> Check if myQueue is empty: myCreateEmpty
	//-------------------------------------------------------------------	
	public MyDoubleDynamicQueue(){
		this.numItems = 0;
		this.originalHead = this.head = null;
		this.originalTail = this.tail = null;
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
		if(this.numItems == 0)
			return (T) "ERROR: list is empty.";
		return this.head.getInfo();
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: addByFirst 
	//-------------------------------------------------------------------
	public void addByFirst(T element){
		if(this.head == null) {
			this.head = new MyDoubleLinkedNode<>(null, element, this.originalTail);
			if(this.originalTail != null) {
				this.originalTail.setLeft(this.originalHead);
				this.head.setRight(this.originalTail);
			}
			else{
				this.tail = this.head;
				this.originalTail = this.tail;
			}
			this.originalHead = this.head;
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
			this.originalTail = this.tail = this.originalHead = this.head = null;
		}
		else if(this.head == null){
			currentNode = this.originalTail;
			nextNode = currentNode.getRight();
			this.originalTail = nextNode;
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
		if(this.numItems == 0)
			return (T) "ERROR: list is empty.";
		return this.tail.getInfo();
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: addByLast 
	//-------------------------------------------------------------------
	public void addByLast(T element){
		if(this.tail == null){
			this.tail = new MyDoubleLinkedNode<>(this.originalHead,element,null);
			if(this.originalHead != null) {
				this.originalHead.setRight(this.tail);
				this.tail.setLeft(this.originalHead);
			}
			else{
				this.head = this.tail;
				this.originalHead = this.head;
			}
			this.originalTail = this.tail;
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
			this.originalTail = this.tail = this.originalHead = this.head = null;
		}
		else if(this.tail == null){
			currentNode = this.originalHead;
			nextNode = currentNode.getLeft();
			this.originalHead = nextNode;
		}
		else{
			currentNode = this.tail;
			nextNode = currentNode.getLeft();
			this.tail = nextNode;
		}
	}

	public String tailToString(){
		String str = "";
		int count = 0;
		MyDoubleLinkedNode<T> currentNode = this.tail;
		MyDoubleLinkedNode<T> nextNode;
		while(count < this.numItems){
			str += currentNode.getInfo() + ", ";
			nextNode = currentNode.getLeft();
			currentNode = nextNode;
			count++;
		}
		return str;
	}

	public String headToString(){
		String str = "";
		int count = 0;
		MyDoubleLinkedNode<T> currentNode = this.head;
		MyDoubleLinkedNode<T> nextNode;
		while(count < this.numItems){
			str += currentNode.getInfo() + ", ";
			nextNode = currentNode.getRight();
			currentNode = nextNode;
			count++;
		}
		return str;
	}
}
