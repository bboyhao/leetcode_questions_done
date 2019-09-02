import java.util.*;

public class EvaluateDivision{
    class Node {
        String label;
        Map<Node, Double> neighbours;
        
        public Node(String label) {
            this.label = label;
            neighbours = new HashMap<>();
        }
        
        public int hashCode() {
            return label.hashCode();
        }
        
        public boolean equals(Object node) {
            if (this == node) return true;
            if (node == null) return false;
            Node other = (Node)node;
            if (label == null) {
                if (other.label != null)
                    return false;
            } else if (!label.equals(other.label)) {
                return false;
            }
            return true;
        }
    }
    
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Node> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            
            if (!graph.containsKey(a)) graph.put(a, new Node(a));
            if (!graph.containsKey(b)) graph.put(b, new Node(b));
            Node nodeA = graph.get(a);
            Node nodeB = graph.get(b);
            nodeA.neighbours.put(nodeB, values[i]);
            nodeB.neighbours.put(nodeA, 1/values[i]);
        }
        
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            Set<String> visited = new HashSet<>();
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (!graph.containsKey(a) || !graph.containsKey(b)) res[i] = -1;
            else res[i] = dfs(graph.get(a), graph.get(b), visited, 1D);
        }
        return res;
        
    }
    
    private double dfs(Node a, Node b, Set<String> visited, double coef) {
        visited.add(a.label);
        if (a.neighbours.containsKey(b)) {
            // Avoid going deep if b is a's neighbour
            return coef * a.neighbours.get(b);
        }
        for (Map.Entry<Node, Double> entry : a.neighbours.entrySet()) {
            if (!visited.contains(entry.getKey().label)) {
                double res = dfs(entry.getKey(), b, visited, coef* entry.getValue());
                if ( -1D != res) {
                    return res;
                }
            }
        }
        return -1D;
    }
}
