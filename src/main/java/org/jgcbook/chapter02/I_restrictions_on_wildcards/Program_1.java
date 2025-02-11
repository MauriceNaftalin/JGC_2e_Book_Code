package org.jgcbook.chapter02.I_restrictions_on_wildcards;
// ch02_8_1
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Program_1 {
	public static void main(String[] args)  {
		List<?> list = new ArrayList<?>();  // compile-time error
		Map<String, ? extends Number> map
		  = new HashMap<String, ? extends Number>();  // compile-time error

	}
}