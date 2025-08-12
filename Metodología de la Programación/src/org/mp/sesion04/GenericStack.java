package org.mp.sesion04;

import org.mp.sesion03.ArrayList;


public class GenericStack<E>{
	
	private ArrayList<E> lista=new ArrayList<E>();
	
	public int getSize() {
		return lista.size();
	}
	
	public E peek() {
		return lista.get(getSize()-1);
	}
	
	public void push(E o) {
		lista.add(o);
	}
	
	public boolean isEmpty() {
		return getSize()==0;
	}
	
	public E pop() {
		
		return lista.remove(getSize()-1);
	}
	
	public String toStrin() {
		return "Pila = "+ lista.toString();
	}
}