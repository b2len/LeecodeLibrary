class Solution {
    public void sortColors(int[] nums) {
        // Corner case
        if (nums == null || nums.length <= 1) {
            return;
        }
       
        /** Allocate all ZEROs to index 0 to i, aka. nums[0, i), all TWOs to index j to len -1, aka nums(j, len-1] and
          * All ONEs to index i to j, aka nums[i,j). We need a current pointer to move through the list, call it curr
          * When curr go through the array, we swap zero with ith element, swap two with jth element, and move along when we encouter 1
          * Meanwhile, we advance i and j as the elements get sorted and swapped. so the number of sorted ZEROs [0, i) and TWOs (j, len-1) are growing  
          * What's between index pointer curr to j, aka nums[curr, j]? These are the elements that have not been checked/sorted/swapped
          * Once curr meet j and after checking that final element, we have checked and sorted all elements */
        
        int i = 0, curr = 0, j = nums.length - 1;
        
        while (curr <= j) {               // while curr and j index have not met
            
            // when curr point to a zero, swap with the ith element (end of sorted 0), move i and curr to the next position
            if (nums[curr] == 0) {
                swap(nums, i, curr);
                i++;
                curr++;
                
           // when curr point to a two, swap with the jth element (beginning of sorted 2), move j forward one position. 
           // curr does not move as it has not examined the swapped element 
            } else if (nums[curr] == 2) {
                swap(nums, curr, j);
                j--;
                
           // when curr point to a one, do nothing except move curr to next element
            } else {
                curr++;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;        
    }
}