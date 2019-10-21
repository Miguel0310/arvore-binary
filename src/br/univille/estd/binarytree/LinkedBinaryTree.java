package br.univille.estd.binarytree;

import org.hamcrest.core.IsEqual;

/**
 * Implementacao de uma √°rvore bin√°ria usando estrutura encadeada
 * @author leandersonandre
 *
 * @param <E>
 */
public class LinkedBinaryTree<E> {
	
	protected BTPosition<E> root; // Referencia para a raiz
	protected int size;           // Numero de nodos
	
	/**
	 * Construtor de uma √°rvore vazia
	 */
	public LinkedBinaryTree() {
		root = null; // inicia com uma √°rvore vazia
		size = 0;
	}
	
	/**
	 * Retorna o numero de nodos da √°rvore
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Retorna se um nodo √© interno
	 */
	public boolean isInternal(BTPosition<E> v) throws InvalidPositionException{
		if ((hasLeft(v) == true) || (hasRight(v) == true)) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Retorna se um nodo √© externo
	 */
	public boolean isExternal(BTPosition<E> v) throws InvalidPositionException{
		if (isInternal(v) != true) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna se um nodo √© a raiz
	 */
	public boolean isRoot(BTPosition<E> v) throws InvalidPositionException{
		root.equals(v);
		return false;
	}
	/**
	 * Retorna se um nodo tem o filho da esquerda
	 */
	public boolean hasLeft(BTPosition<E> v) throws InvalidPositionException{
		if (v == null) {
			throw new InvalidPositionException("deu pau");
		}else {
			if(v.getLeft() != null) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Retorna se um nodo tem o filho da direita
	 */
	public boolean hasRight(BTPosition<E> v) throws InvalidPositionException{
		if (v == null) {
			throw new InvalidPositionException("deu pau");
		}else {
			if(v.getRight() != null) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Retorna a raiz da √°rvore
	 */
	public BTPosition<E> root() throws EmptyTreeException{
		if(root == null) {
			throw new EmptyTreeException("Arvore vazia");
		}
		return root;
	}
	
	/**
	 * Retorna o filho da esquerda de um nodo
	 * Lan√ßa BoundaryViolationException se nao tiver filho da esquerda
	 */
	public BTPosition<E> left(BTPosition<E> v) throws InvalidPositionException, BoundaryViolationException{
		if(v == null) {
			throw new InvalidPositionException("valor nulo");
		}
		if(v.getLeft() != null) {
			return v.getLeft();
		}else {
			throw new BoundaryViolationException("N„o tem filho da esquerda");
		}
	}
	
	/**
	 * Retorna o filho da direita de um nodo
	 * Lan√ßa BoundaryViolationException se nao tiver filho da direita
	 */
	public BTPosition<E> right(BTPosition<E> v) throws InvalidPositionException, BoundaryViolationException{
		if(v.getRight() != null) {
			return v.getRight();
		}else {
			throw new BoundaryViolationException("N„o tem filho da direita");
		}
	}
	
	/**
	 * Retorna o pai de um nodo
	 * Lan√ßa BoundaryViolationException se nao tiver pai
	 */
	public BTPosition<E> parent(BTPosition<E> v) throws InvalidPositionException, BoundaryViolationException{
		if(v.getParent() != null) {
			return v.getParent();
		}else {
			throw new BoundaryViolationException("N„o tem pai");
		}
	}
	
	/**
	 * Substitui o elemento armazenado no nodo
	 * Retorna o elemento substituido
	 */
	public E replace(BTPosition<E> v, E o) throws InvalidPositionException{
		if(v == null) {
			throw new InvalidPositionException("posiÁ„o invalida");
		}
		E temp = v.getElement();
		v.setElement(o);
		return temp;
	}
	
	/**
	 * Retorna o irmao de um nodo
	 * Lan√ßa BoundaryViolationException se nao tiver um irmao
	 */
	public BTPosition<E> sibling(BTPosition<E> v) throws InvalidPositionException, BoundaryViolationException{
		if(v == null) {
			throw new InvalidPositionException("elemento invalido");
		}
		if(v.getParent() == null) {
			throw new BoundaryViolationException("N„o possui irm„o");
		}
		BTPosition<E> temp = v.getParent();
		if(!hasLeft(temp) || !hasRight(temp)) {
			throw new BoundaryViolationException("N„o possui filhos");
		}
		if(temp.getRight() == v) {
			return temp.getLeft();
		} 
			return temp.getRight(); 
	}
	
	/**
	 * Insere a raiz em uma arvore vazia
	 */
	public BTPosition<E> addRoot(E e) throws NonEmptyTreeException{
		if(root == null) {
			size = 1;
			root = createNode(e, null, null, null);
		}else {
			throw new NonEmptyTreeException("Arvore n„o est· vazia");
		}
		return null;
	}
	
	/**
	 * Insere o filho da esquerda em um nodo
	 */
	public BTPosition<E> insertLeft(BTPosition<E> v, E e) throws InvalidPositionException{
		return null;
	}
	
	/**
	 * Insere o filho da direita em um nodo
	 */
	public BTPosition<E> insertRight(BTPosition<E> v, E e) throws InvalidPositionException{
		return null;
	}
	
	/**
	 * Remove um nodo com zero ou um filho
	 * Nao pode remover um nodo com dois filhos. Deve lancar InvalidPositionException
	 */
	public E remove(BTPosition<E> v) throws InvalidPositionException{
		return null;
	}
	
	/**
	 *  Cria um novo nodo para a arvore binaria
	 */
	protected BTPosition<E> createNode(E element, BTPosition<E> parent, BTPosition<E> left, BTPosition<E> right) {
		return new BTPosition<E>(element, parent, left, right);
	}

}
