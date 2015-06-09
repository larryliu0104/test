/**
 * Created by lte on 2015/6/7.
 */
public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        if(nums == null) return false;
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while(l < r - 1){
            int mid = l + (r - l) / 2;
            boolean isLeftNormal = (nums[l] < nums[mid])? true : false;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] > target){
                if(isLeftNormal){//左正常，中超
                    if(nums[l] <= target){//左小
                        r = mid - 1;//在左边
                    }else{
                        l = mid + 1;
                    }
                }else{//右正常，中超，在左边
                    r = mid - 1;
                }
            }else{//中小,目标大
                if(isLeftNormal){//左正常
                    l = mid + 1;//在右边
                }else{//右正常
                    if(nums[r] >= target){//右大
                        l = mid + 1;//在右边
                    }else{//中小右也小，肯定被折到左边了
                        r = mid - 1;
                    }
                }
            }
        }
        if(nums[l] == target || nums[r] == target){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args){
        int[] nums = {1,3,1,1,1};
        int target = 3;
        System.out.println(new SearchInRotatedSortedArray2().search(nums, target));
    }
}
