package Leetcode;

// leetcode 3433
// tc - O(m*n), sc - O(n+m)
class Solution {
    private void markAllUsers(int[] result){
        int n = result.length;
        for(int i = 0; i < n; i++) result[i]++;
    }

    private void markOnlineUsers(String timeStr, int[] result, int[] onlineTime){
        int n = result.length;
        int time = Integer.parseInt(timeStr);

        for(int i = 0; i < n; i++){
            if(onlineTime[i] <= time) result[i]++;
        }
    }

    private void markUsers(String str, int[] result){
        String[] users = str.split(" ");
        for(String user : users){
            result[Integer.parseInt(user.substring(2))]++;
        }
    }

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] result = new int[numberOfUsers];
        int[] onlineTime = new int[numberOfUsers];

        Collections.sort(events, (a, b) -> {
            int time1 = Integer.parseInt(a.get(1));
            int time2 = Integer.parseInt(b.get(1));
            if(time1 == time2){
                if(a.get(0).charAt(0) == 'O') return -1;
                else return 1;
            }
            return time1-time2;
        });
        System.out.println(events);

        for(List<String> event : events){
            if(event.get(0).equals("MESSAGE")){
                if(event.get(2).equals("ALL")) markAllUsers(result);
                else if(event.get(2).equals("HERE")) markOnlineUsers(event.get(1), result, onlineTime);
                else markUsers(event.get(2), result);
            }
            else{
                int id = Integer.parseInt(event.get(2));
                int time = Integer.parseInt(event.get(1));
                onlineTime[id] = time + 60;
            }
        }

        return result;
    }
}