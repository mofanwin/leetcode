package daily_exercise.I1776;
import java.util.*;
class Solution {
    class Pojo{
        Pojo(Double startPosition,Double speed, Double hitPosition, Double hitTime) {
            this.startPosition = startPosition;
            this.speed = speed;
            this.hitPosition = hitPosition;
            this.hitTime = hitTime;
        }
        Double startPosition;
        Double speed;
        Double hitPosition;
        Double hitTime;
    }
    public double[] getCollisionTimes(int[][] cars) {
        double[] result = new double[cars.length];
        LinkedList<Pojo> queue = new LinkedList<>();
        for(int i = cars.length-1 ;i>=0;i--) {
            while(!queue.isEmpty() && queue.peekFirst().speed >= cars[i][1]) {
                queue.removeFirst();
            }
            if(queue.isEmpty()) {
                queue.addFirst(new Pojo((double)cars[i][0], (double)cars[i][1], null, null));
                result[i] = -1;
            }else {
                double position = cars[i][0];
                double speed = cars[i][1];
                while(!queue.isEmpty()) {
                    Pojo front = queue.getFirst();
                    double expTime = (front.startPosition - position) / (speed - front.speed);
                    if(front.hitTime == null || expTime <= front.hitTime) {
                        result[i] = expTime;
                        queue.addFirst(new Pojo((double)cars[i][0], (double)cars[i][1], position + expTime * speed, expTime));
                        break;
                    }else {
                        queue.removeFirst();
                    }
                }
            }
        }
        return result;
    }
}