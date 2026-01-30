class Solution {
    public int search(int[] nums, int target) {
        int pivet = into(nums);
        System.out.println(pivet);
        int ans = search(nums , pivet , target);
        System.out.println(ans);
        return ans;
    }
    static int search(int[] nums,int pivet , int target){
        if (pivet == -1){
            int ans = find(nums , target , 0 , nums.length - 1);
            return ans;
        }
        else{
            if(target == nums[pivet]){
                return  pivet;
            }
            if (pivet != -1){
                if(target > nums[nums.length - 1]){
                    int ans = find(nums , target , 0 , pivet - 1);
                    return ans;
                }else{
                    int ans = find(nums , target , pivet + 1 , nums.length - 1);
                    return ans;
                }
            }}return - 1;
    }
    static int  find(int[] nums, int target,int start ,int end){
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(target > nums[mid]){
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid -1 ;
            }else{
                return mid;
            }
        }return - 1;
    }
    static int into(int[] nums){
        int i = 0;
        int start = 0;
        int end = nums.length - 1 ;
        while(i < end){
            if(nums[i] < nums[i+1]){
                i++;
            }else {
                return i;
            }
        }return-1;
    };
}
