class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
        // Calculate the carry bits
        int carry = (a & b) << 1;

        
        // Sum of bits where at least one of the bits is not set (addition without carry)
        a = a ^ b;
        
        // Carry becomes the new 'b' to be added in the next iteration
        b = carry;
    }
    return a;
    }
}

