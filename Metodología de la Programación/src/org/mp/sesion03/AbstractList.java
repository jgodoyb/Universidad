package org.mp.sesion03;

import java.util.Iterator;

public abstract class AbstractList<E> implements List<E> {

	protected int size = 0;

	protected AbstractList() {
	}

	protected AbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	public void add(E e) {
		add(size(), e);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		} else
			return false;
	}
	
	
	public boolean equals(Object o) {
		if(o==null) {
			return false;
		}
		if(this==o) {
			return true;	
		}
		if(!(o instanceof AbstractList)) {
			return false;
		}
		AbstractList a=(AbstractList)o;
		boolean[] cambio=new boolean[this.size()];
		for(int i=0;i<cambio.length;i++) {
			E primero=this.iterator().next();
			E segundo=(E) a.iterator().next();
			cambio[i]=primero.equals(segundo);
			}
		for(int i=0;i<cambio.length;i++) {
			if(cambio[i]==false) {
				return false;	
			}
			
		}
		return true;	
	}
}