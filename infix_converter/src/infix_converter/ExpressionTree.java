package infix_converter;

public class ExpressionTree {
	
	private Node root;

    public ExpressionTree(String infixExpression) {
        Converter converter = new Converter(infixExpression);
        String post = converter.toPostFix();
        buildTree(post);
    }

    private void buildTree(String post) {
        ArrayStack<Node> stack = new ArrayStack<>();
        for (String x : post.split(" ")) {
            if (Converter.isOperator(x)) {
                Node right = stack.pop();
                Node left = stack.pop();
                Node opNode = new Node(x, left, right);
                stack.push(opNode);
            } else {
                stack.push(new Node(x));
            }
        }

        root = stack.pop();
    }

    public void Prefix() {
        Prefix(root);
        System.out.println();
    }

    private void Prefix(Node x) {
        if (x != null) {
            System.out.print(x + " ");
            Prefix(x.leftChild);
            Prefix(x.rightChild);
        }
    }

    public void Infix() {
        Infix(root);
        System.out.println();
    }

    private void Infix(Node x) {
        if (x != null) {
            if (x.leftChild != null || x.rightChild != null) {
                System.out.print("(");
            }
            Infix(x.leftChild);
            System.out.print(x);
            Infix(x.rightChild);
            if (x.leftChild != null || x.rightChild != null) {
                System.out.print(")");
            }
        }
    }

    public void Postfix() {
        Postfix(root);
        System.out.println();
    }

    private void Postfix(Node x) {
        if (x != null) {
            Postfix(x.leftChild);
            Postfix(x.rightChild);
            System.out.print(x + " ");
        }
    }
}
