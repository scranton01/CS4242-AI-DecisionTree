package decisionTree;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Utility {
    public static void xmlParser(InputStreamReader xml) {
        BufferedReader inputReader = new BufferedReader(xml);
        String input;
        try {
            while ((input = inputReader.readLine()) != null) {
                System.out.println(input);
                String[] split = input.split("\\s+",4);
                if (Arrays.asList(split).contains("<node")) {
                    String behavior = "";
                    String response = "";
                    Map map = new HashMap();
                    for (int i = 0; i < split.length; i++) {
//                        if (split[i].contains("behavior")) {
//                            if (!split[i].contains("\"\"")) {
//                                String[] attribute = split[i].split("\"");
//                                behavior = attribute[1];
//                            }
//                        } else if (split[i].contains("response")) {
//                            if (!split[i].contains("\"\"")) {
//                                String[] attribute = split[i].split("\"");
//                                behavior = attribute[1];
//                            }
//                        }
                        if(split[i].contains("=")){
//                            map.put.readXml(split[i]);
                        }
                    }
                    new Node(map.get("behavior").toString(), map.get("response").toString());
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    static Map readXml(String line) {
        String[] split = line.split("=");
        Map result = new HashMap<String,String>();
        result.put(split[0],split[1].split("\"")[1]);
        return result;
    }
}
