package design.pattern.interview;

import java.util.*;
//compare array of string to see when 5 inserted in the numbers which is the biggest possible number formed
public class OracleInt1 {

	//driver method
	public static void main(String[] args) {
		int[] arr= {268,670,0,-999};		
		for(int str:arr) {
			System.out.println(solution(str));
		}
	}
	
	public static int solution(int N) {
		String str=String.valueOf(N);
		List<Integer> list=new ArrayList<Integer>();
		int i = Integer.parseInt(str) < 0 ? 1:0;
		for(;i<=str.length();i++)
		{
			StringBuilder sb=new StringBuilder(str);
			sb.insert(i,'5');
			list.add(Integer.parseInt(sb.toString()));
		}
		return Collections.max(list);
	}

}
