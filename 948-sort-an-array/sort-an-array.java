class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        // One temp array reused in all merge steps
        int[] temp = new int[n];
        mergeSort(nums, temp, 0, n - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left >= right) return; // 0 or 1 element is already sorted

        int mid = left + (right - left) / 2;

        // Sort left half and right half
        mergeSort(nums, temp, left, mid);
        mergeSort(nums, temp, mid + 1, right);

        // Merge two sorted halves
        merge(nums, temp, left, mid, right);
    }

    private void merge(int[] nums, int[] temp, int left, int mid, int right) {
        // Copy current range into temp
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;     // pointer for left half
        int j = mid + 1;  // pointer for right half
        int k = left;     // pointer for nums (result)

        // Merge back into nums
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                nums[k++] = temp[i++];
            } else {
                nums[k++] = temp[j++];
            }
        }

        // Copy remaining elements of left half, if any
        while (i <= mid) {
            nums[k++] = temp[i++];
        }

        // Remaining of right half are already in place if any,
        // because they are in correct order in temp and nums segment.
    }
}