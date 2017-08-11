package common.txt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;

import net.sf.json.JSONObject;

public class DoTxt {
	public static void createtxt(String path, String name) {
		try {
			File file = new File(path + name);
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("create file " + path + name + " success!");
			} else {
				System.out.println("create file " + path + name + " fail! rs:exist");
			}
		} catch (Exception e) {
			System.out.println("create file " + path + name + " fail! rs:" + e.toString());
			e.printStackTrace();
		}
	}

	public static void writetxt(String content, String name) {
		try {
			File file = new File(name);
			if (file.exists()) {
				RandomAccessFile randomFile = new RandomAccessFile(name, "rw");
				long fileLength = randomFile.length();
				randomFile.seek(fileLength);
				randomFile.writeBytes(content+"\r\n");
				randomFile.close();
				System.out.println("write content " + content + " to file " + name + " rs:success!");
			} else {
				System.out.println("write content " + content + " to file " + name + " fail! rs:no file exist");
			}
		} catch (Exception e) {
			System.out.println("write content " + content + " to file " + name + " fail! rs:" + e.toString());
			e.printStackTrace();
		}
	}

	public static JSONObject readtxt(String name) {
		JSONObject txtjob = new JSONObject();
		int i = 1;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			File file = new File(name);
			if (file.exists()) {
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				String read = null;
				while ((read = bufferedReader.readLine()) != null) {
					System.out.println(read);
					txtjob.element(i + "", read);
					i++;
				}
				System.out.println("read txt " + name + " success!");
			} else {
				System.out.println("read txt " + name + " fail! rs:no file exist");
			}
		} catch (Exception e) {
			System.out.println("read txt " + name + " fail! rs:" + e.toString());
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (Exception e) {
				System.out.println("close io fail rs:" + e.toString());
				e.printStackTrace();
			}
		}

		return txtjob;
	}
}
