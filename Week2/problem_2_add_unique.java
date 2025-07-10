package Week2;

public class problem_2_add_unique {
    public static void main(String[] args){
        int[] nums = {6, 8, 10, 11, 6, 10};
        System.out.println(sol_1_without_sorting(nums));
    }

    public static int[] sol_1_without_sorting(int[] nums){
        int[] unique = new int[nums.length];
        int index = 0;
        for(int i: nums){
            boolean found = false;
            for(int j: unique){
                if(i == j){
                    found = true;
                    break;
                }
            }
            if(!found){
                unique[index] = i;
                index++;
            }
        }
        return unique;
    }     
}