package org.mp.sesion03;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> extends AbstractList<E> {

	private static final int CAPACIDAD_INICIAL = 16;
	private E[] data = (E[]) new Object[CAPACIDAD_INICIAL];

	public ArrayList() {
	}

	public ArrayList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	@Override

	public void add(int index, E e) {
		ensureCapacity();

		if (index < 0) {
			throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size);
		}

		for (int i = size - 1; i >= index; i--)
			data[i + 1] = data[i];

		data[index] = e;

		size++;
	}

	private void ensureCapacity() {
		if (size == data.length) {
			E[] nuevo = (E[]) new Object[size * 2 + 1];
			System.arraycopy(data, 0, nuevo, 0, size);
			data = nuevo;
		}
	}

	@Override
	public void clear() {
		data = (E[]) new Object[CAPACIDAD_INICIAL];

		size = 0;
	}

	@Override

	public boolean contains(E e) {
		for (int i = 0; i < size; i++) {
			if (e.equals(data[i])) {
				return true;
			}
		}
		return false;
	}

	@Override

	public E get(int index) {
		checkIndex(index);
		return data[index];
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size);
	}

	@Override

	public int indexOf(E e) {
		for (int i = 0; i < size; i++) {
			if (e.equals(data[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override

	public int lastIndexOf(E e) {
		for (int i = size - 1; i >= 0; i--) {
			if (e.equals(data[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override

	public E remove(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size);
		}
		if (data[index] == null) {
			throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size);
		}

		E element = data[index];

		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		size--;
		return element;
	}

	@Override

	public E set(int index, E e) {
		checkIndex(index);
		E antiguo = data[index];
		data[index] = e;
		return antiguo;

	}

	@Override

	public String toString() {
		StringBuilder resultado = new StringBuilder("[");
		for (int i = 0; i < size; i++) {
			resultado.append(data[i]);
			if (i < size - 1)
				resultado.append(", ");
		}
		return resultado.toString() + "]";
	}

	public void trimToSize() {

		if (size != data.length) {
			E[] nuevo = (E[]) new Object[size];

			System.arraycopy(data, 0, nuevo, 0, size);

			data = nuevo;
		} else {
			throw new RuntimeException("Guapit@ no necesitas hacer un trim, el tamaño coincide con la capacidad");
		}

	}

	@Override

	public Iterator<E> iterator() {
		return new ArrayListIterator();

	}

	private class ArrayListIterator implements Iterator<E> {

		private int current = 0;

		@Override
		public boolean hasNext() {
			return current < size;
		}

		@Override
		public E next() {
			if (current == size) {
				throw new NoSuchElementException("No hay más elementos en la lista");
			}
			return data[current++];
		}

		@Override
		public void remove() {
			ArrayList.this.remove(current);
		}

	}
}