package decisionTree;

import java.io.InputStreamReader;

import static decisionTree.Utility.xmlParser;

public class Main {
    public static void main(String[] args){
        System.out.println("hello");

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        xmlParser(new InputStreamReader(classLoader.getResourceAsStream("sample.xml")));
    }
}
