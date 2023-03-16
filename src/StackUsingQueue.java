import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public StackUsingQueue() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();

    }

    public void push(int x) {
        if(q1.size()>0){
            q1.add(x);}
        else{
            q2.add(x);
        }
    }

    public int pop() {
        if(empty()){
            return -1;
        }
        int peek=-1;
        if(q1.size()>0){
            while(q1.size()>0){
                peek=q1.remove();
                if(q1.size()==0){
                    break;
                }
                q2.add(peek);
            }
        }
        else{
            while(q2.size()>0){
                peek=q2.remove();
                if(q2.size()==0){
                    break;
                }
                q1.add(peek);
            }
        }
        return peek;
    }

    public int top() {
        int peek=-1;
        if(q1.size()>0){
            while(q1.size()>0){
                peek=q1.remove();

                q2.add(peek);
            }
        }
        else{
            while(q2.size()>0){
                peek=q2.remove();

                q1.add(peek);
            }
        }
        return peek;

    }

    public boolean empty() {
        return q1.isEmpty()&&q2.isEmpty();
    }
}
