import java.util.*;

class problem_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result= new int[2];
        for (int i = 0; i< nums.length; i++){
            for (int j = i+1; j< nums.length; j++){
                if(nums[i]+nums[j] == target){
                    result[0]= i;
                    result[1]= j;
                }   
            }
        }
        return result;
    }
    public static void main(String[] args){
        problem_1 p = new problem_1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = p.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
/* Two Sum */