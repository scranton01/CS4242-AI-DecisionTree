package decisionTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.server.ExportException;

/**
 * Created by Jun on 9/10/2016.
 */
public class Utility {
    public static void xmlParser(InputStreamReader xml){
        BufferedReader inputReader = new BufferedReader(xml);
        String input;
        try {
            while ((input = inputReader.readLine()) != null) {
                System.out.println(input);
            }
        }catch(IOException exception){
            exception.printStackTrace();
        }

    }
}
