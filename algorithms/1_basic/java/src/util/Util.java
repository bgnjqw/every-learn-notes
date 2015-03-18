package util;

public class Util {

	public static void print(Object s){
		if(s == null){
			System.out.println("null");
		}else{
			System.out.println(s.toString());
		}
	}
}
