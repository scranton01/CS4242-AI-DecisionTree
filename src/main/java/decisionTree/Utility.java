/**
 * CS4242 Artificial Intelligence
 * @Date 9/19/2016
 * @Author Jun Nguyen
 */
package decisionTree;


import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class Utility {
    public static Node createTree(InputStreamReader xml) {
        BufferedReader inputReader = new BufferedReader(xml);
        Node root = new Node("ROOT", "");
        xmlParser(inputReader, root);
        return root;
    }

    private static void xmlParser(BufferedReader inputReader, Node node) {
        String input;
        try {
            do {
                input = inputReader.readLine();
                if (input.contains("<node")) {
                    Map map = xmlLineToMap(input);
                    Node childNode = new Node(map.get("behavior").toString(), map.get("response").toString());
                    node.setChildren(childNode);
                    if (!input.contains("/")) {
                        xmlParser(inputReader, childNode);
                    }
                }
                if (input.contains("<root>")) {
                    xmlParser(inputReader, node);
                }
                if (input.contains("</")) {
                    return;
                }
            } while (!input.contains("root"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return;
    }

    private static Map xmlLineToMap(String line) {
        String[] split = line.split("\\s+");
        Map map = new HashMap<String, String>();

        for (int i = 0; i < split.length; i++) {
            Object key;
            Object value;
            if (!split[i].contains("<")) {
                if (StringUtils.countMatches(split[i], "\"") == 2) {
                    key = split[i].split("=")[0];
                    if (split[i].contains("\"\"")) {
                        value = "";
                    } else {
                        value = split[i].split("\"")[1];
                    }
                    map.put(key, value);
                    if (split[i].contains("/>")) {
                        break;
                    }
                } else if (StringUtils.countMatches(split[i], "\"") == 1) {
                    AtomicInteger counbineCount = new AtomicInteger(0);
                    while (StringUtils.countMatches(split[i], "\"") != 2) {
                        split[i] = split[i] + " " + split[i + counbineCount.incrementAndGet()];
                    }

                    key = split[i].split("=")[0];
                    if (split[i].contains("\"\"")) {
                        value = "";
                    } else {
                        value = split[i].split("\"")[1];
                    }
                    map.put(key, value);
                    if (split[i].contains("/>")) {
                        break;
                    }
                    i += counbineCount.get();
                }
            }
        }
        return map;
    }
}
