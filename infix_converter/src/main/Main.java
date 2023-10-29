package main;

import java.util.Scanner;

import infix_converter.ExpressionTree;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
            System.out.println("Enter your expression (type 'exit' to close): ");
            String expression = scanner.nextLine();

            if (expression.equalsIgnoreCase("exit")) {
                System.out.println("Closing the program");
                break;
            }

            ExpressionTree expressionTree = new ExpressionTree(expression);
            System.out.print("Prefix: ");
            expressionTree.Prefix();
            System.out.print("Infix: ");
            expressionTree.Infix();
            System.out.print("Postfix: ");
            expressionTree.Postfix();
        }

        scanner.close(); 
	}
}
