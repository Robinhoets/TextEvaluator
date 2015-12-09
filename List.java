public interface List<E> {

    /**
    *   @return the number of elements in the list
    */
    public int size();

	/**
	*   Determines whether a given object is in the list.
	*   @param obj the object to look for in the list
	*   @return true, if the given object is in the list, false, otherwise
	*/
	public boolean contains(Object obj);
    
    /**
    *   Finds the index of a given object.
    *   @param obj the object to look for in the list.
    *   @return the index of the object in the list
    *   @throws NoSuchElementException
    */
    public int indexOf(Object obj);
    
    /**
    *   @precondition index is >= 0 and < size of the list
    *   @param index an index of an element in the list
    *   @return the element of the list at the given index, null if element not present
    *   @throws IndexOutOfBoundsException
    */
    public E get(int index);

    /**
    *   Adds a new element at the end of the list.
    *   @param element element to be added to the list
    */
	public void add(E element);

    /**
    *   Inserts a new element before a specified index.
    *   @precondition index is >= 0 and <= size of the list
    *   @param element element to be added to the list
    *   @param index index of the element in the list that this element 
    *       is to be inserted before
    *   @throws IndexOutOfBoundsException
    */
	public void add(int index, E element);

    /**
    *   Removes the specified element.
    *   @param element the element that is to be removed from the list
    *   @return true if the element exists and was removed, false if the 
    *   element was not present in the list
    */
	public boolean remove(Object obj);

    /**
    *   Removes the element at a specified index.
    *   @precondition index is >= 0 and < size of the list
    *   @param index index of the element that is to be removed from the list
    *   @throws IndexOutOfBoundsException
    */
    public void remove(int index);

    /**
    *   Replaces the element at a specified index with the given element.
    *   @precondition index is >= 0 and < size of the list
    *   @param element element to place at the specified index
    *   @param index index of the element that is to be replaced
    *   @throws IndexOutOfBoundsException
    */
	public void set(int index, E element);
	
	/**
	*   Removes all elements from the list
	*/
	public void clear();
	
	/**
	*   Determines whether there are any elements in the list
	*   @return true, if there are no elements in the list, false, otherwise
	*/
	public boolean isEmpty();
}