package _1_bag_queue_stack;

import util.Util;

/**
 * 定容栈
 * @param <Item>
 */
public class FixedCapacityStack<Item> {

	private Item[] a;
	private int N;
	
	public FixedCapacityStack(int cap){
//		a = new Item[a];  这样是不行的，在java中不能直接初始化范型数组
		a = (Item[])new Object[cap];
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public void push(Item item){
		if(N == a.length){
			this.resize(a.length*2);
		}
		a[N++] = item;
	}

    //出栈时，如果栈的体积小与长度的四倍，则变为长度的两倍，这样可以保持永远在1/4以上
	public Item pop(){
		Item result = a[--N];
		a[N] = null;
        if(N > 0 && N == a.length/4){
            this.resize(a.length/2);
        }
		return result;
	}
	
	public void print(){
		Util.printList(this.a);
	}
	
	//将数组长度增加
	private void resize(int max){
		Item[] temp = (Item[])new Object[max];
		for(int i=0; i<max; i++ ){
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public static void main(String[] args){
		FixedCapacityStack<String> fcs = new FixedCapacityStack<String>(10);

		fcs.push("this");
		fcs.push("is");
		fcs.push("a");
		fcs.push("test");
        fcs.print();
		fcs.pop();
		fcs.print();
        fcs.pop();
        fcs.print();
		Util.print(fcs.size());

        fcs.pop();
        fcs.pop();
        Util.print(fcs.size());

	}
}
