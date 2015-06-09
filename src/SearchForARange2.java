/**
 * Created by lte on 2015/6/6.
 */
public class SearchForARange2 {
    public int[] searchRange(int[] A, int target) {
        int[] ans = new int[] {-1, -1};
        if (A == null || A.length == 0) {
            return ans;
        }
        int len = A.length;
        int left = 0, right = len - 1;
        while (left < right) {//找左边界，这里不能带等于的直接原因是，等于会死循环
            int mid = left + (right - left) / 2;
            if (A[mid] >= target) {//等于的时候动右不动左，说明是找左边界，这时如果动左，则可能跳过左边界，动右说明右边界随便霍霍，
            // 而左边界只在不等的时候动，不可能错过；
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (A[left] == target) {
            ans[0] = left;
        } else {
            return ans;
        }
        left = 0;
        right = len - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (A[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        ans[1] = right;
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(new SearchForARange2().searchRange(nums, target)[1]);
    }

}
