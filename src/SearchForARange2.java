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
        while (left < right) {//����߽磬���ﲻ�ܴ����ڵ�ֱ��ԭ���ǣ����ڻ���ѭ��
            int mid = left + (right - left) / 2;
            if (A[mid] >= target) {//���ڵ�ʱ���Ҳ�����˵��������߽磬��ʱ������������������߽磬����˵���ұ߽���������
            // ����߽�ֻ�ڲ��ȵ�ʱ�򶯣������ܴ����
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
