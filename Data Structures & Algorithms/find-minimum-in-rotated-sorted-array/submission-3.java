class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid == 0 && mid + 1 <= n - 1) {
                if (nums[mid] < nums[mid + 1]) {
                    return nums[mid];
                }
            } else if (mid == (n - 1) && mid - 1 >= 0) {
                if (nums[mid] < nums[mid - 1]) {
                    return nums[mid];
                }
            } else if (nums[mid] <= nums[mid + 1] && nums[mid] <= nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[left] < nums[mid]) {
                if (nums[right] < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
