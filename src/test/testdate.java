package test;

import java.util.HashMap;

import common.datetime.DoDate;

public class testdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String time=DoDate.getnowdatetime("12");
//		System.out.println(time);
		HashMap<Integer, Integer> days=DoDate.getmonthdays(2011, 2);
		for(int i:days.keySet()){
			System.out.println(2011+"/"+days.get(i)+"/"+i);
		}
	}

}
