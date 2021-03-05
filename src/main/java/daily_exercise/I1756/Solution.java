package daily_exercise.I1756;
import java.util.*;

class MRUQueue {
    LinkedList<Integer> list = new LinkedList<>();

    public MRUQueue(int n) {
        for(int i = 1 ; i <=n;i++)list.addLast(i);
    }

    public int fetch(int k) {
        int result = list.remove(k-1);
        list.addLast(result);
        return result;

    }
}
