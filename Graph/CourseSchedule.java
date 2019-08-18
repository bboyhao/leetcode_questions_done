import java.util.*;

public class CourseSchedule{
    public boolean canFinish(int numCourses, int[][] prerequisites){
        List<List<Integer>> g = new ArrayList<>();
        int[] visited = new int[numCourses];
        for(int i = 0;i < numCourses; i+=1){
            g.add(new ArrayList<Integer>());
        }
        for(int[] pair : prerequisites){
            g.get(pair[1]).add(pair[0]);
        }
        for(int i = 0;i<numCourses;i++){
            if(!dfs(g, i, visited)) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> g, int i, int[] visited){
        if(visited[i] == 1) return true;
        if(visited[i] == -1) return false;
        visited[i] = -1;
        for(int n : g.get(i)){
            if(!dfs(g, n, visited)) return false;
        }
        visited[i] = 1;
        return true;
    }
}
