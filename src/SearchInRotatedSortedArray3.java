/**
 * Created by lte on 2015/6/7.
 */
public class SearchInRotatedSortedArray3 {
    public int search(int[] nums, int target) {
        if(nums == null){
            return -1;
        }
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while(l < r - 1){
            int mid = l + (r - l) / 2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[l] < nums[mid]){//左边小于mid，左有序
                if(nums[mid] < target){
                    l = mid + 1;//左有序，目标比中大，目标在右边；
                }else{//目标比中小
                    if(target >= nums[l]){//比左大，在左边
                        r = mid - 1;
                    }else{//比左也小，在右边
                        l = mid + 1;
                    }
                }
            }else if(nums[l] > nums[mid]){//左边大于mid，右有序
                if(nums[mid] > target){
                    r = mid - 1;//右有序，中间比目标大，结果在左边；
                }else{//中间比目标小
                    if(target <= nums[r]){//并且右边比目标大，在右边
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                }
            }
        }
        if(nums[l] == target){
            return l;
        }else if(nums[r] == target){
            return r;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 4;
        System.out.println(new SearchInRotatedSortedArray3().search(nums, target));
    }
}
