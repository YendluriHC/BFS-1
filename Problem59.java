//Time Complexity: O(V + E)
//Space Complexity: O(V + E)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Array to store the in-degree (number of prerequisites) of each course
        int[] inDegree = new int[numCourses];
        
        // Adjacency list to store the courses dependent on a particular course
        List<List<Integer>> adjList = new ArrayList<>();
        
        // Initialize the adjacency list
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // Fill in the in-degree array and adjacency list
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            inDegree[course]++;
            adjList.get(pre).add(course);
        }
        
        // Queue for performing BFS
        Queue<Integer> queue = new LinkedList<>();
        
        // Add all courses with in-degree of 0 (no prerequisites) to the queue
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        // Number of courses that can be completed
        int completedCourses = 0;
        
        // Process the courses in topological order
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completedCourses++;
            
            // Reduce the in-degree of dependent courses
            for (int dependentCourse : adjList.get(course)) {
                inDegree[dependentCourse]--;
                
                // If a course now has no prerequisites, add it to the queue
                if (inDegree[dependentCourse] == 0) {
                    queue.add(dependentCourse);
                }
            }
        }
        
        // If we have completed all courses, return true
        return completedCourses == numCourses;
    }
}
