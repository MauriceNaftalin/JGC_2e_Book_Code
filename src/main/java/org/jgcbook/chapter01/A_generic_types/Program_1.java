package org.jgcbook.chapter01.A_generic_types;
// ch01_0_1
import java.util.List;
import java.util.ArrayList;

public class Program_1 {
	public static void main(String[] args)  {
		List<String> words = new ArrayList<String>();      
		words.add("Hello ");
		words.add("world!");
		String s = words.get(0)+words.get(1);              
		assert s.equals("Hello world!");

	}
}