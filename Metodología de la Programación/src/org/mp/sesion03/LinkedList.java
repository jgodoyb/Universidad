package org.mp.sesion03;

public class LinkedList<E> extends AbstractList<E>{
	
	private static class Node<E>{
		E elemento;
		Node next;
		
		public Node(E o) {
			elemento=o;
		}
	}
	
	private Node<E> head;
	private Node<E> tail;
	
	public LinkedList() {
		
	}
	
	public LinkedList(E[]object) {
		for(int i=0;i<object.length;i++) {
			add(object[i]);
		}
	}
	
	public E getFirst() {
		if(head==null) {
			return null;
		}
		return head.elemento;
	}
	
	public E getLast() {
		if(tail==null) {
			return null;
		}
		return tail.elemento;
	}
	
	public void addFirst(E e) {
		Node<E> nuevo=new Node(e);
		nuevo.next=head;
		head=nuevo;
		size++;
		if(tail==null) {
			tail=head;
		}
	}
	
	public void addLast(E e) {
		Node<E>nuevo=new Node(e);
		tail.next=nuevo;
	}
	
	 public void add(int index, E e) {
		 if(index<=0) {
			 addFirst(e);
		 }
		 else if(index>=size) {
			 addLast(e);
		 }
		 else {
			 Node<E>nuevo=new Node(head);
			 for(int i=1;i<index;i++) {
				 nuevo=nuevo.next;
			 }
			 nuevo.next=new Node<E>(e);
			 size++; 
		 }
	 }
	
	 public E removeFirst() {
		 if(size==0) {
			 return null;
		 }else {
			 Node<E> a =new Node(head);
			 head=head.next;
			 size--;
		 
			 if(head==null) 
			 tail=null;
			 
			 return a.elemento;
		 }	 
	 }
	 
	 public E removeLast() {
		 if(size==0) {
			 return null;
		 }
		 if(size==1) {
			 Node <E> viejo= new Node(head);
			 head=tail=null;
			 size--;
			 return viejo.elemento;
		 }
		 
		 Node<E> viejo2=new Node(tail);
		 tail=null;
		 size--;
		 return viejo2.elemento; 
	 }
	 
	 public E remove(int index) {
		 if(index==1) {
			 removeFirst();
		 }
		 if(index==size-1) {
			 removeLast();
		 }
		 
		 if(index<0 || index>=size) {
			 return null;
		 }
		 
		 Node<E>nuevo= new Node(head);
		 for(int i=1;i<index;i++) {
			 nuevo=nuevo.next;
		 }
		 Node <E> nuevo2=new Node(nuevo.next);
		 nuevo=nuevo2.next;
		 size--;
		 return nuevo2.elemento;	 
	 }
	 
	 public void clear() {
		 for(int i=0;i<size;i++) {
			 remove(i);
		 }
		 size=0;
	 }
	
	 public boolean contains(E e) {
		 for(int i=0;i<size;i++) {
			 if(e.equals(get(i))) {
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 public E get (int index) {
		  Node <E> get= new Node(head);
		  for(int i=0;i<index;i++) {
			  get=get.next;  
		  }
		  return get.elemento;
	 }
	 
	 public int indexOf(E e) {
		 for(int i=0;i<size;i++) {
			 if(e.equals(get(i))) {
				 return i;
			 }
		 }
		 return -1;
	 }
	 
	 public int lastIndexOf(E e) {
		 for (int i=size-1;i>=0;i--) {
			 if(e.equals(get(i))) {
				 return i;
			 }
		 }
		 return -1;
	 }
	
	 public E set(int index,E e) {
		   Node <E> cambio= new Node(head);
		   for(int i=0;i<index;i++) {
			   cambio=cambio.next;
		   }
		   Node <E> a=new Node(cambio);
		   cambio.elemento=e;
		   return a.elemento;
	 }
	
}