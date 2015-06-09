/**
 * Created by lte on 2015/6/6.
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if(nums == null) return ans;
        int len = nums.length;
        int l = 0, r = len - 1;
        int matchIndex = -1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target){
                matchIndex = mid;
                break;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }

        }
        if(matchIndex == -1) return ans;
        int leftAns = matchIndex - 1;
        int rightAns = matchIndex + 1;
        while(leftAns >=0 && nums[matchIndex] == nums[leftAns]){
            leftAns--;
        }
        while(rightAns <= len - 1 && nums[matchIndex] == nums[rightAns]){
            rightAns++;
        }
        ans[0] = leftAns + 1;
        ans[1] = rightAns - 1;
        return ans;

    }
    public static void main(String[] args){
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(new SearchForARange().searchRange(nums, target)[1]);
    }
}
