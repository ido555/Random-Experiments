package adapter;

public class Stackitest {

	public static void main(String[] args) {
		ArrayList_Stackified<Integer> list = new  ArrayList_Stackified<Integer>();
		System.out.println(list);
		list.push(1);
		System.out.println(list);
		list.push(2);
		System.out.println(list);
		list.push(3);
		System.out.println(list);
		list.push(4);
		System.out.println(list);
		list.push(5);
		System.out.println(list);
		list.pop();
		list.pop();
		System.out.println(list);
	}

}
