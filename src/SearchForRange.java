/**
 * Created by lte on 2015/6/6.
 */
public class SearchForRange {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if(nums == null || nums.length == 0) return ans;
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while(left < right){//����߽�
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        if(nums[left] == target){
            ans[0] = left;
        }else{
            return ans;
        }

        //���ұ߽�
        left = 0;
        right = len - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        if(nums[right] == target){//������ܵ��ⲿ��˵��ǰ��һ���ҵ���߽��ˣ��������ifelse�����е���ࣿ
            ans[1] = right;
        }else{
            return ans;
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {8, 8};
        int target = 8;
        System.out.println(new SearchForARange2().searchRange(nums, target));
    }
}
