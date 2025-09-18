package Leetcode;

// similar to yesterday one
class TaskManager {
    HashMap<Integer, Task> mp;
    PriorityQueue<Task> pq;
    class Task{
        int userId;
        int taskId;
        int priority;
        boolean isActive = true;
        public Task(int userId, int taskId, int priority){
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
        public String toString(){
            return userId + " " + taskId + " " + priority + " " + isActive;
        }
    }
    public TaskManager(List<List<Integer>> tasks) {
        mp = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> b.priority-a.priority == 0 ? b.taskId-a.taskId : b.priority-a.priority);
        for(List<Integer> task : tasks){
            Task curr = new Task(task.get(0), task.get(1), task.get(2));
            mp.put(task.get(1), curr);
            pq.add(curr);
        }
        // System.out.println(mp);
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        mp.put(taskId, task);
        pq.add(task);
        // System.out.println(mp);
    }

    public void edit(int taskId, int newPriority) {
        Task task = mp.get(taskId);
        task.isActive = false;
        Task newTask = new Task(task.userId, task.taskId, newPriority);
        pq.add(newTask);
        mp.put(taskId, newTask);
        // System.out.println(mp);
    }

    public void rmv(int taskId) {
        Task task = mp.get(taskId);
        task.isActive = false;
        mp.remove(taskId);
        // System.out.println(mp);
    }

    public int execTop() {
        while(!pq.isEmpty() && !pq.peek().isActive) pq.remove();
        if(pq.isEmpty()) return -1;
        Task task = pq.remove();
        mp.remove(task.taskId);
        // System.out.println(mp);
        return task.userId;
    }
}