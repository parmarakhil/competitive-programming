import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {


    public static int[] dailyTemperatures(int[] array) {
        int[] answer = new int[array.length];
        for (int i=0; i<array.length; i++) {
            int tempDays=0;
            int pivot = array[i];
            for (int j=i+1; j<array.length; j++) {
                if (pivot==array[j]) {
                    break;
                }
                if (pivot<array[j]) {
                    tempDays++;
                    break;
                } else {
                    tempDays++;
                }
            }
            answer[i]=tempDays;
        }
        return answer;
    }
    public static void main(String[] args) {
        Arrays.stream(dailyTemperatures1(new int[]{73,74,75,71,69,72,76,73})).forEach(System.out::println);
    }

    public static int[] dailyTemperatures1(int[] array) {
        int[] answer = new int[array.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[i] > array[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        return answer;
    }
}
