class Solution {
    public int[] productExceptSelf(int[] nums) {
        // find the zeros
        int n = nums.length;

        int countZero = 0;
        int totalMultiple = 1;
        int index = -1;
        for (int it = 0; it < n; it++) {
            if (nums[it] == 0) {
                countZero++;
                index = it;
            } else {
                totalMultiple *= nums[it];
            }
        }

        if (countZero > 1) {
            return new int[n];
        }
        if (countZero == 1) {
            int[] temp = new int[n];
            temp[index] = totalMultiple;
            return temp;
        }

        for (int i = 0; i < n; i++) {
            nums[i] = totalMultiple / nums[i];
        }
        return nums;
    }
}
