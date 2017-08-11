package common.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class DoDate {
	public static String getnowdatetime(String type) {
		String rs = null;
		SimpleDateFormat df = null;
		try {
			switch (type) {
			case "y":
				df = new SimpleDateFormat("yyyy");
				rs = df.format(new Date());
				break;
			case "M":
				df = new SimpleDateFormat("yyyy-MM");
				rs = df.format(new Date());
				break;
			case "d":
				df = new SimpleDateFormat("yyyy-MM-dd");
				rs = df.format(new Date());
				break;
			case "h":
				df = new SimpleDateFormat("yyyy-MM-dd HH");
				rs = df.format(new Date());
				break;
			case "m":
				df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				rs = df.format(new Date());
				break;
			case "s":
				df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				rs = df.format(new Date());
				break;
			default:
				df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				rs = df.format(new Date());
				break;
			}
			System.out.println("get date success!");
		} catch (Exception e) {
			System.out.println("get date fail! rs:" + e.toString());
			e.printStackTrace();
		}
		return rs;
	}

	public static HashMap<Integer, Integer> getmonthdays(int year, int month) {
		HashMap<Integer, Integer> days = new HashMap<>();
		switch (month) {
		case 1:
			for (int i = 1; i < 32;i++){
				days.put(i, month);
			}
			break;
		case 2:
			if (year % 4 != 0) {
				for (int i = 1; i < 29; i++) {
					days.put(i, month);
				}
			} else {
				for (int i = 1; i < 30; i++) {
					days.put(i, month);
				}
			}
			break;
		case 3:
			for (int i = 1; i < 32; i++) {
				days.put(i, month);
			}
			break;
		case 4:
			for (int i = 1; i < 31; i++) {
				days.put(i, month);
			}
			break;
		case 5:
			for (int i = 1; i < 32; i++) {
				days.put(i, month);
			}
			break;
		case 6:
			for (int i = 1; i < 31; i++) {
				days.put(i, month);
			}
			break;
		case 7:
			for (int i = 1; i < 32; i++) {
				days.put(i, month);
			}
			break;
		case 8:
			for (int i = 1; i < 32; i++) {
				days.put(i, month);
			}
			break;
		case 9:
			for (int i = 1; i < 31; i++) {
				days.put(i, month);
			}
			break;
		case 10:
			for (int i = 1; i < 32; i++) {
				days.put(i, month);
			}
			break;
		case 11:
			for (int i = 1; i < 31; i++) {
				days.put(i, month);
			}
			break;
		case 12:
			for (int i = 1; i < 32; i++) {
				days.put(i, month);
			}
			break;
		}
		System.out.println("get month days success!");
		return days;
	}

	
	public static String gettimestamp(){
		int seconds = (int) (System.currentTimeMillis() / 1000);
		String time = Integer.toString(seconds);
		return time;
	}
}
