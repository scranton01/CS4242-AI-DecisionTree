package decisionTree;

import java.util.List;


public class Node {
    private String behavior;
    private String response;
    private List<Node> children;

    public Node(String behavior, String response){
        this.behavior = behavior;
        this.response = response;
    }

    public void setChildren(List<Node> children){
        this.children = children;
    }
}
