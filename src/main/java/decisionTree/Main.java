/**
 * CS4242 Artificial Intelligence
 * @Date 9/19/2016
 * @Author Jun Nguyen
 */
package decisionTree;

import java.io.InputStreamReader;
import java.util.Scanner;

import static decisionTree.Utility.createTree;


public class Main {
    public static void main(String[] args) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Node root = createTree(new InputStreamReader(classLoader.getResourceAsStream("sample.xml")));
        System.out.println("----------------------------------");
        System.out.println("Behavior Tree Loaded...");
        root.printTree();
        System.out.println("----------------------------------");
        String input = "";
        Scanner in = new Scanner(System.in);

        while (!input.equals("q")) {
            System.out.println("Event ('q' to exit) : ");
            input = in.nextLine();
            root.search(input);

        }
    }
}
