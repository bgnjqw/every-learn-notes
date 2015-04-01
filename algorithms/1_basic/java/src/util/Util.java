package util;

public class Util {

	public static void print(Object s){
		if(s == null){
			System.out.println("null");
		}else{
			System.out.println(s.toString());
		}
	}

    public static void printList(Object[] list){
        if(list == null){
            System.out.println("list is null");
        }else{
            for(Object o : list){
                if(o != null){
                    System.out.print(o.toString() + "   ,   ");
                }else{
                    System.out.print("null" + "   ,   ");
                }
            }
            System.out.println("");
        }
    }

}
