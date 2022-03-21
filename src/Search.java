public class Search {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1, pivot = 0;
        while(start <= end){
            int mid = start + (end - start) / 2;

            if(mid != nums.length - 1 && nums[mid] > nums[mid + 1]){
                pivot = mid;
                break;
            }

            else if(mid != 0 && nums[mid] < nums[mid - 1]){
                pivot = mid - 1;
                break;
            }

            else{

                if(nums[start] > nums[mid]){
                    end = mid - 1;
                }

                else if(nums[start] < nums[mid]){
                    start = mid + 1;
                }
            }


            if(nums[start] == nums[mid]){

                if(start != nums.length - 1 && nums[start] > nums[start + 1]){
                    pivot = start;
                    break;
                }
                else if(start != 0 && nums[start] < nums[start - 1]){
                    pivot = start - 1;
                    break;
                }

                else{
                    ++start;
                }
            }


            if(nums[end] == nums[mid]){

                if(end != nums.length - 1 && nums[end] > nums[end + 1]){
                    pivot = end;
                    break;
                }
                else if(end != 0 && nums[end] < nums[end - 1]){
                    pivot = end - 1;
                    break;
                }

                else{
                    --end;
                }
            }
        }


        start = 0;
        end = pivot;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return true;
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }


        start = pivot + 1;
        end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return true;
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }


        return false;
    }
}
