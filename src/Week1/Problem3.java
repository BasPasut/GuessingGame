package Week1;

public class Problem3 {
public static void main(String[] args) {
	StringBuilder sb = new StringBuilder("I");  // 1
	System.out.println(sb);
	 sb.append("Str").append("ings!"); // 2
	 System.out.println(sb);
	 sb.insert(1," hate "); // 3
	 System.out.println(sb);
	 sb.replace(2,6,"love"); // 4
	 System.out.println(sb);
	 sb.append("123456");
	 System.out.println(sb);
	 
	}

}
