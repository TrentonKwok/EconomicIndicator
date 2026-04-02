import java.util.Iterator;

public class SequenceList <T> implements Iterable<T>{
    private T[] eles;
    private int N;

    public SequenceList(int capacity){
        eles = (T[]) new Object[capacity];
        N = 0;
    }

    public void clear(){
        N = 0;
    }

    public int length(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int indexOf(T t){
        for(int i = 0; i < N; i++){
            if(eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    public T get(int i){
        if(i >= N || i < 0){
            throw new RuntimeException("Out of index");
        }
        else{
            return eles[i];
        }
    }

    public void insert(T t){
        if(N == eles.length){
            resize(eles.length == 0 ? 1 : eles.length * 2);
        }

        eles[N] = t;
        N++;
    }

    public void insert(int i, T t) {
        if (i > N || i < 0) {
            throw new RuntimeException("Out of Index");
        }

        if (N == eles.length) {
            resize(eles.length == 0 ? 1 : eles.length * 2);
        }

        for (int index = N; index > i; index--) {
            eles[index] = eles[index - 1];
        }

        eles[i] = t;
        N++;
    }

    public void resize(int newCapacity){
        T[] temp = eles;
        eles = (T[]) new Object[newCapacity];

        for(int i = 0; i < eles.length; i++)
            eles[i] = temp[i];
    }

    public T remove(int i){
        if (i < 0 || i >= N){
            throw new RuntimeException("Out of Index");
        }

        T current = eles[i];
        for(int index = i; index < N - 1; index++){
            eles[index] = eles[index + 1];
        }

        eles[N + 1] = null;
        N--;

        if(N > 0 && N <= eles.length / 4){
            resize(eles.length / 2);
        }
        return current;
    }

    public Iterator<T> iterator(){
        return new SIterator();
    }

    private class SIterator implements Iterator<T>{
        private int cursor;

        public SIterator(){
            cursor = 0;
        }

        public boolean hasNext(){
            return cursor < N;
        }

        public T next(){
            return eles[cursor++];
        }

    }
}
