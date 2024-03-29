// Java implementation of a O(n) time
// method for Zigzag order traversal
import java.util.*;

// Binary Tree node
class MyNode
{
    int data;
    MyNode leftChild;
    MyNode rightChild;
    MyNode(int data)
    {
        this.data = data;
    }
}

class BinaryTree {
    MyNode rootNode;

    // function to print the
// zigzag traversal
    void printZigZagTraversal() {

        // if null then return
        if (rootNode == null) {
            return;
        }

        // declare two stacks
        Stack<MyNode> currentLevel = new Stack<>();
        Stack<MyNode> nextLevel = new Stack<>();

        // push the root
        currentLevel.push(rootNode);
        boolean leftToRight = true;

        // check if stack is empty
        while (!currentLevel.isEmpty()) {

            // pop out of stack
            MyNode node = currentLevel.pop();

            // print the data in it
            System.out.print(node.data + " ");

            // store data according to current
            // order.
            if (leftToRight) {
                if (node.leftChild != null) {
                    nextLevel.push(node.leftChild);
                }

                if (node.rightChild != null) {
                    nextLevel.push(node.rightChild);
                }
            }
            else {
                if (node.rightChild != null) {
                    nextLevel.push(node.rightChild);
                }

                if (node.leftChild != null) {
                    nextLevel.push(node.leftChild);
                }
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<MyNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }
}

public class ZigZagTreeTraversal {

    // driver program to test the above function
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.rootNode = new MyNode(1);
        tree.rootNode.leftChild = new MyNode(2);
        tree.rootNode.rightChild = new MyNode(3);
        tree.rootNode.leftChild.leftChild = new MyNode(7);
        tree.rootNode.leftChild.rightChild = new MyNode(6);
        tree.rootNode.rightChild.leftChild = new MyNode(5);
        tree.rootNode.rightChild.rightChild = new MyNode(4);

        System.out.println("ZigZag Order traversal of binary tree is");
        tree.printZigZagTraversal();
    }
}