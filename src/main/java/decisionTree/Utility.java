package decisionTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Utility {
    public static void xmlParser(InputStreamReader xml) {
        BufferedReader inputReader = new BufferedReader(xml);
        String input;
        try {
            while ((input = inputReader.readLine()) != null) {
                System.out.println(input);
                String[] split = input.split("\\s+");
                if (Arrays.asList(split).contains("<node")) {
                    String behavior = "";
                    String response = "";
                    for (int i = 0; i < split.length; i++) {
                        if (split[i].contains("behavior")) {
                            String[] attribute = split[i].split("\"");
                            behavior = attribute[1];
                        } else if (split[i].contains("response")) {
                            String[] attribute = split[i].split("\"");
                            response = attribute[1];
                        }
                    }
                    new Node(behavior,response);
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    static void parse(String line) {

    }
}
