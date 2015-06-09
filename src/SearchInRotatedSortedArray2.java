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
                if(isLeftNormal){//���������г�
                    if(nums[l] <= target){//��С
                        r = mid - 1;//�����
                    }else{
                        l = mid + 1;
                    }
                }else{//���������г��������
                    r = mid - 1;
                }
            }else{//��С,Ŀ���
                if(isLeftNormal){//������
                    l = mid + 1;//���ұ�
                }else{//������
                    if(nums[r] >= target){//�Ҵ�
                        l = mid + 1;//���ұ�
                    }else{//��С��ҲС���϶����۵������
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
