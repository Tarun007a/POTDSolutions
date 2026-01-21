package GFG;

// tc - O(n), sc - O(n)
class Solution {
    ArrayDeque<Character> undoSt = new ArrayDeque<>();
    ArrayDeque<Character> content = new ArrayDeque<>();

    public void append(char x) {
        content.push(x);
    }

    public void undo() {
        undoSt.push(content.pop());
    }

    public void redo() {
        content.push(undoSt.pop());
    }

    public String read() {
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> temp = new ArrayDeque<>();

        while(!content.isEmpty()){
            char ch = content.pop();
            temp.push(ch);
            sb.append(ch);
        }

        while(!temp.isEmpty()) content.push(temp.pop());
        return sb.reverse().toString();
    }
}

