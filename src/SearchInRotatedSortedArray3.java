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
            }else if(nums[l] < nums[mid]){//���С��mid��������
                if(nums[mid] < target){
                    l = mid + 1;//������Ŀ����д�Ŀ�����ұߣ�
                }else{//Ŀ�����С
                    if(target >= nums[l]){//����������
                        r = mid - 1;
                    }else{//����ҲС�����ұ�
                        l = mid + 1;
                    }
                }
            }else if(nums[l] > nums[mid]){//��ߴ���mid��������
                if(nums[mid] > target){
                    r = mid - 1;//�������м��Ŀ��󣬽������ߣ�
                }else{//�м��Ŀ��С
                    if(target <= nums[r]){//�����ұ߱�Ŀ������ұ�
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
