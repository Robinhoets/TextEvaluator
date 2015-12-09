public class ArrayList<E> implements List<E> {
    
    private static final int DEFAULTSIZE = 10;
    private E [] elements;
    private int size;
    
    /*
    * Java does not permit declaration of generic arrays. This constructor creates
    * an array of Objects and then casts the array to the generic type. This cast
    * will result in a compiler warning about unchecked types. The
    * @SuppressWarnings annotation is used to indicate that we know what
    * we are doing here; it suppresses the "unchecked" warning.
    */
    public ArrayList(int size) {
        @SuppressWarnings("unchecked")
        E[] newdata = (E[]) new Object[size];
        elements = newdata;
        size = 0;
    }

    public ArrayList() {
        this(DEFAULTSIZE);
    }

    public int size() {
        return size;
    }
    
    public void clear() {
        size = 0;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean contains(Object obj) {
        for (int i=0; i<size; i++)
            if (elements[i].equals(obj))
                return true;
        return false;
    }
    
    public int indexOf(Object obj) {
        for (int i=0; i<size; i++)
            if (elements[i].equals(obj))
                return i;
        return -1;
    }
    
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index: " + index);
        return elements[index];
    }
    
    public void add(E element) {
        if (size == elements.length)
            extendArray();
        elements[size] = element;
        size++;
    }
    
    public void add(int index, E element) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index: " + index);
        if (size == elements.length)
            extendArray();        
        for (int i=size; i>index; i--) 
            elements[i] = elements[i-1];
        elements[index] = element;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index > size-1)
            throw new IndexOutOfBoundsException("index: " + index);
        for (int i=index; i<size-1; i++)
            elements[i] = elements[i+1];
        size--;
    }
    
    public boolean remove(Object obj) {
        if (obj == null) return false;
        @SuppressWarnings("unchecked")
        E item = (E) obj;
        int index = indexOf(item);
        if (index == -1) return false;
        remove(index);
        return true;
    }
    
    public void set(int index, E element) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index: " + index);
        elements[index] = element;
    } 
    
    @Override
    public String toString() {
        if (size == 0) return "[ ]";
        StringBuilder sb = new StringBuilder("[");
        for (int i=0; i<size-1; i++)
            sb.append(elements[i] + ", ");
        sb.append(elements[size-1] + "]\n");
        return sb.toString();
    }
    
    private void extendArray() {
        @SuppressWarnings("unchecked")
        E[] newdata = (E[]) new Object[elements.length*2];
        for (int i=0; i<size; i++)
            newdata[i] = elements[i];
        elements = newdata;
    }
}