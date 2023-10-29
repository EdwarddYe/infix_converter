package infix_converter;

import java.util.List;

public class Converter{
	
	String input;
	List<String> result;
	ArrayStack<String> ints = new ArrayStack<>();
	String fin = "";
	
	public Converter(String input){
		this.input = input;
		char[] x = input.toCharArray();
		result = ParserHelper.parse(x);
	}

	public String toPostFix() {
		for(String x:result) {
			if(value(x)>0) {
				while(ints.isEmpty()==false && value(ints.top())>=value(x)) {
					fin+=ints.pop() + " ";
				}
				ints.push(x);
			}
			else if(x.equals(")")) {
				String y = ints.pop();
				while (!y.equals("(")) {
					fin += y + " ";
					y = ints.pop();
				}
			}
			else if(x.equals("(")) {
				ints.push(x);
			}
			else {
				fin += x + " ";
			}
		}
		while (!ints.isEmpty()) {
            fin +=ints.pop() + " ";
        }
		return fin;
	}
	public int value(String x) {
		if (x.equals("+")||x.equals("-")) {
			return 1;
		}
		else if (x.equals("*")||x.equals("/")) {
			return 2;
		}
		else if (x.equals("^")) {
			return 3;
		}
		return 0;
	}
	public static boolean isOperator(String s)
	   {
	       switch(s)
	       {
	           case "+": case "-": case "/": case "*": case "^":
	               return true;
	       }
	       return false;
	   }
}
