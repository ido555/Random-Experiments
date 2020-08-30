package threads_ex5_FillThread_Repo;

import java.util.ArrayList;

public class Repository {

	private ArrayList<Integer> nums;

	public Repository() {
		this.nums = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> getNums() {
		return nums;
	}

	public void addNum(int num) {
		nums.add(num);
	}
}
