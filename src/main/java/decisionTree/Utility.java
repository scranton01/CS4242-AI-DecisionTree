package decisionTree;


import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class Utility {
    public static Node createTree(InputStreamReader xml){

    }

    public static void xmlParser(InputStreamReader xml) {
        BufferedReader inputReader = new BufferedReader(xml);
        String input;
        try {
            while ((input = inputReader.readLine()) != null) {
                System.out.println(input);
                if (input.contains("<node")) {
                    Map map = xmlToMap(input);
                    if (map.get("behavior") == null) {
                        Node node = new Node("", map.get("response").toString());
                    } else if (map.get("response") == null) {
                        Node node = new Node(map.get("behavior").toString(), "");
                    } else {
                        Node node = new Node(map.get("behavior").toString(), map.get("response").toString());
                    }
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    static Map xmlToMap(String line) {
        String[] split = line.split("\\s+");
        Map map = new HashMap<String, String>();

        for (int i = 0; i < split.length; i++) {
            Object key;
            Object value;
            if (!split[i].contains("<")) {
                if (StringUtils.countMatches(split[i], "\"") == 2) {
                    key = split[i].split("=")[0];
                    if (split[i].contains("\"\"")) {
                        value = null;
                    } else {
                        value = split[i].split("\"")[1];
                    }
                    map.put(key, value);
                    if(split[i].contains("/>")){
                        break;
                    }
                } else if (StringUtils.countMatches(split[i], "\"") == 1) {
                    AtomicInteger atomicInteger = new AtomicInteger(0);
                    while(StringUtils.countMatches(split[i],"\"")!=2) {
                        split[i] = split[i] + " " + split[i + atomicInteger.incrementAndGet()];
                    }

                    key = split[i].split("=")[0];
                    if (split[i].contains("\"\"")) {
                        value = null;
                    } else {
                        value = split[i].split("\"")[1];
                    }
                    map.put(key, value);
                    if(split[i].contains("/>")){
                        break;
                    }
                    i+=atomicInteger.get();
                }
            }
        }

        return map;
    }
}
