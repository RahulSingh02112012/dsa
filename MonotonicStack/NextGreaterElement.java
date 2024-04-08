package Tree.MonotonicStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NextGreaterElement {
    //arr = [13, 8, 1, 5, 2, 5, 9, 7, 6, 12]
    public static void main(String[] args) {
        int[] input = new int[] {13, 8, 1, 5, 2, 5, 9, 7, 6, 12};
        int[] res = nextGreaterElementIndexes(input);

        System.out.println(Arrays.stream(input).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));

    }

    private static int[] nextGreaterElementIndexes(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stk = new Stack<>();
        Arrays.fill(res,-1);

        for(int i =0;i< nums.length;i++) {
            while(!stk.isEmpty() && nums[stk.peek()] < nums[i]) {
                int top = stk.pop();
                res[top] = nums[i];
            }
            stk.push(i);
        }
        return res;
    }
}
