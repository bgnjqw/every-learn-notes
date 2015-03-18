package _1_bag_queue_stack;

import util.Util;

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
	
	public Item pop(){
		Item retult = a[N];
		a[--N] = null;
		return retult;
	}
	
	public void print(){
		for(Item item : a){
			Util.print(item);
		}
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
		fcs.pop();
		fcs.print();
		Util.print(fcs.size());
	
	}
}
