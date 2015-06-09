/**
 * Created by lte on 2015/6/7.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null) return -1;
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l < r - 1) {//避免 mid = l 陷入死循环
            int mid = l + (r - l) / 2;
            boolean isLeftNormal = (nums[mid] > nums[l]) ? true : false;//判断左边是否是正常数列

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {

                if (isLeftNormal) {//左边是正常数列
                    l = mid + 1;
                } else {//右边是正常数列
                    //因为之折叠一次，左边不正常右边一定正常
                    if (nums[r] < target) {//中小右小，在左边
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }

            } else {//中大
                if (isLeftNormal) {//左正常
                    if (nums[l] > target) {//中大左大，在右边
                        l = mid + 1;
                    } else {//中大左小等
                        r = mid - 1;
                    }
                } else {//右正常，中大右正常，一定在左边
                    r = mid - 1;
                }

            }

        }
        if (nums[l] == target) {
            return l;
        } else if (nums[r] == target) {
            return r;
        } else {
            return -1;
        }
    }
    public static void main(String[] args){
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 4;
        System.out.println(new SearchInRotatedSortedArray().search(nums, target));
    }
}
