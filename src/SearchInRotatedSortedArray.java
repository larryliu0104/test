/**
 * Created by lte on 2015/6/7.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null) return -1;
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l < r - 1) {//���� mid = l ������ѭ��
            int mid = l + (r - l) / 2;
            boolean isLeftNormal = (nums[mid] > nums[l]) ? true : false;//�ж�����Ƿ�����������

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {

                if (isLeftNormal) {//�������������
                    l = mid + 1;
                } else {//�ұ�����������
                    //��Ϊ֮�۵�һ�Σ���߲������ұ�һ������
                    if (nums[r] < target) {//��С��С�������
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }

            } else {//�д�
                if (isLeftNormal) {//������
                    if (nums[l] > target) {//�д�������ұ�
                        l = mid + 1;
                    } else {//�д���С��
                        r = mid - 1;
                    }
                } else {//���������д���������һ�������
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
