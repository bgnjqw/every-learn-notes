package _1_bag_queue_stack;

import util.Util;

import java.util.Iterator;

/**
 * Created by Administrator on 2015/3/23.
 */
public class ResizingArrayStack<Item> implements Iterable<Item>{

    private Item[] a = (Item[])new Object[1];
    private int N = 0;

    public boolean isEmpty(){ return N == 0; }
    public int size(){ return N; }

    private void resize(int max){
        Item[] b = (Item[])new Object[max];

        for(int i = 0; i< N; i++){
            b[i] = a[i];
        }
        a = b;
    }

    public void push(Item item){
        if( N == a.length){
            resize(2*a.length);
        }
        a[N++] = item;
    }

    public Item pop(){
        Item result = a[--N];
        a[N] = null;
        if( N > 0 && N == a.length/4){
            resize(a.length/2);
        }
        return result;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int i = N;

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public Item next() {
                return a[--i];
            }
    };
    }

    private class ReversAarrayIterator implements Iterator<Item>{
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }

    public static void main(String[] args){
        ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
        stack.push("this");
        stack.push("is");
        stack.push("a");
        stack.push("test");


        Iterator<String> i = stack.iterator();
        while(i.hasNext()){
            Util.print(i.next());
        }
        for(String aaa : stack){
            Util.print(aaa);
        }
    }
}
