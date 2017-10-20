
public class MyDoubleDynamicQueue<T> implements MyQueue<T> {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private MyDoubleLinkedNode<T> head;
	private MyDoubleLinkedNode<T> tail;
	private MyDoubleLinkedNode<T> originalHead;
	private MyDoubleLinkedNode<T> originalTail;
	private int numItems;
	
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
			this.head = new MyDoubleLinkedNode<>(null, element, this.originalTail);
			if(this.originalTail != null)
				this.originalTail.setLeft(this.head);
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
			this.tail = new MyDoubleLinkedNode<>(this.originalHead,element,null);
			if(this.originalHead != null)
				this.originalHead.setRight(this.tail);
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
		else{
			currentNode = this.tail;
			nextNode = currentNode.getLeft();
			this.tail = nextNode;
		}
	}

}
