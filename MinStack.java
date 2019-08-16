import java.util.Stack;

public class MinStack{
    private long min;
    private Stack<Long> s;

    public MinStack() {
        s = new Stack<>();
    }

    public void push(int x) {
        if(s.isEmpty()){
            s.push(0L);
            min = x;
        }else{
            s.push(x-min);
            if(x<min){
                min = x;
            }
        }
    }

    public void pop() {
        if(s.isEmpty()) return;
        long top = s.pop();
        if(top<0){
            min = min - top;
        }
    }

    public int top() {
        long top = s.peek();
        if(top>0){
            return (int)(top + min);
        }else{
            return (int)min;
        }
    }

    public int getMin() {
        return (int)min;
    }
}
