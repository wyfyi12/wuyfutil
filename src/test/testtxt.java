package test;

import common.txt.DoTxt;

public class testtxt {
	public static void main(String[] args) {
		DoTxt.createtxt("d://", "test111.txt");
		DoTxt.writetxt("1234", "d://test111.txt");
		DoTxt.writetxt("5678", "d://test111.txt");
		DoTxt.readtxt("d://test111.txt");
	}
}
