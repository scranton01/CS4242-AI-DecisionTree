/**
 * CS4242 Artificial Intelligence
 * @Date 9/19/2016
 * @Author Jun Nguyen
 */
package decisionTree;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Node {
    private String behavior;
    private String response;
    private List<Node> children;

    public Node(String behavior, String response) {
        this.behavior = behavior;
        this.response = response;
        this.children = new ArrayList<>();
    }

    public void setChildren(Node children) {
        this.children.add(children);
    }

    public void printTree() {
        printTreeDfs(this, "");

    }

    private void printTreeDfs(Node node, String space) {

        if (!node.behavior.isEmpty()) {
            System.out.print("behavior = " + node.behavior);
        }
        if (!node.response.isEmpty()) {
            System.out.print("response = " + node.response);
        }
        System.out.println();
        if (!node.children.isEmpty()) {
            space += "\t";
            for (Node child : node.children) {
                System.out.print(space);
                printTreeDfs(child, space);
            }
        }
    }

    public void search(String keyword) {
        AtomicInteger bfsStep = new AtomicInteger(0);
        AtomicInteger dfsStep = new AtomicInteger(0);
        Queue<Node> queue = new LinkedList<>();
        queue.add(this);
        System.out.println("Response = " + bfs(queue, keyword, bfsStep));
        System.out.println("Response = " + dfs(this, keyword, dfsStep));
        System.out.println("Item found in " + bfsStep + " steps with BFS, " + dfsStep + " steps with DFS.");
    }

    private String bfs(Queue<Node> queue, String keyword, AtomicInteger step) {
        String result = "";
        step.getAndIncrement();
        if (!queue.isEmpty()) {
            if (queue.peek().behavior.equals(keyword)) {
                return randomTraverse(queue.peek());
            } else {
                if (!queue.peek().children.isEmpty()) {
                    queue.addAll(queue.peek().children);
                }
                queue.remove();
                result = bfs(queue, keyword, step);
            }
        }
        return result;
    }

    private String dfs(Node node, String keyword, AtomicInteger step) {
        String result = "";
        step.getAndIncrement();
        if (node.behavior.equals(keyword)) {
            return randomTraverse(node);
        }
        if (!node.children.isEmpty()) {
            for (Node child : node.children) {
                result = dfs(child, keyword, step);
                if (!result.equals("")) {
                    break;
                }
            }
        }
        return result;
    }

    private String randomTraverse(Node node) {
        String input;
        Random random = new Random();
        Node childNode = node.children.get(random.nextInt(node.children.size()));
        if (childNode.response.isEmpty()) {
            input = randomTraverse(childNode);
        } else {
            return childNode.response;
        }
        return input;
    }
}
