package decisionTree;

import java.util.ArrayList;
import java.util.List;


public class Node {
    private String behavior;
    private String response;
    private List<Node> children;

    public Node(String behavior, String response){
        this.behavior = behavior;
        this.response = response;
        this.children = new ArrayList<>();
    }

    public void setChildren(Node children){
        this.children.add(children);
    }

    public void traverseDfs(){}
    public void traverseBfs(){}
}
