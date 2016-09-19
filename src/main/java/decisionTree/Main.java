package decisionTree;

import java.io.InputStreamReader;

import static decisionTree.Utility.createTree;
import static decisionTree.Utility.xmlParser;

public class Main {
    public static void main(String[] args){

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Node root = createTree(new InputStreamReader(classLoader.getResourceAsStream("sample.xml")));

    }
}
