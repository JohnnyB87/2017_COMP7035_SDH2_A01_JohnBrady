
public class MyDoubleDynamicQueue<T> implements MyQueue<T> {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	MyDoubleLinkedNode<T> head;
	MyDoubleLinkedNode<T> tail;
	MyDoubleLinkedNode<T> originalHead;
	MyDoubleLinkedNode<T> originalTail;
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
		if(this.head == null)
			return this.originalTail.getInfo();
		return this.head.getInfo();
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: addByFirst 
	//-------------------------------------------------------------------
	public void addByFirst(T element){
		if(this.head == null) {
			this.head = new MyDoubleLinkedNode<>(null, element, this.originalTail);
			this.originalHead = this.head;
		}
		else {
			MyDoubleLinkedNode<T> currentNode = this.head;
			this.head = new MyDoubleLinkedNode<>(null,element,currentNode);
			currentNode.setLeft(this.head);
		}
		this.numItems++;
		this.headItems++;
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: removeByFirst 
	//-------------------------------------------------------------------	
	public void removeByFirst(){
		MyDoubleLinkedNode<T> currentNode;
		MyDoubleLinkedNode<T> nextNode;
		if(this.numItems == 0)
			System.out.println("ERROR: list is empty.");
		else if(this.head == null){
			currentNode = this.originalTail;
			nextNode = currentNode.getRight();
			this.originalTail = nextNode;
			this.numItems--;
			this.tailItems--;
		}
		else{
			currentNode = this.head;
			nextNode = currentNode.getRight();
			this.head = nextNode;
			this.numItems--;
			this.headItems--;
		}
	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyQueue: last
	//-------------------------------------------------------------------
	public T last(){
		if(this.tail==null)
			return this.originalHead.getInfo();
		return this.tail.getInfo();
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: addByLast 
	//-------------------------------------------------------------------
	public void addByLast(T element){
		if(this.tail == null){
			this.tail = new MyDoubleLinkedNode<>(this.originalHead,element,null);
			this.originalTail = this.tail;
		}
		else{
			MyDoubleLinkedNode<T> currentNode = this.tail;
			this.tail = new MyDoubleLinkedNode<>(currentNode,element,null);
			currentNode.setRight(this.tail);
		}
		this.numItems++;
		this.tailItems++;
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: removeByFirst 
	//-------------------------------------------------------------------	
	public void removeByLast(){
		MyDoubleLinkedNode<T> currentNode;
		MyDoubleLinkedNode<T> nextNode;
		if(this.numItems == 0)
			System.out.println("ERROR: list is empty.");
		else if(this.tail == null){
			currentNode = this.originalHead;
			nextNode = currentNode.getLeft();
			this.originalHead = nextNode;
			this.numItems--;
			this.headItems--;
		}
		else{
			currentNode = this.tail;
			nextNode = currentNode.getLeft();
			this.tail = nextNode;
			this.numItems--;
			this.tailItems--;
		}
	}

}
