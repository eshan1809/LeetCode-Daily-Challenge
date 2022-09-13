class Solution {
    public boolean validUtf8(int[] data) {
        int rem = 0;
        for (int val : data) {
            if ((val >> 7) == 0b0) {
                if (rem > 0)
                    return false;
            } else if ((val >> 5) == 0b110) {
                if (rem > 0)
                    return false;
                rem = 1;
            } else if ((val >> 4) == 0b1110) {
                if (rem > 0)
                    return false;
                rem = 2;
            } else if ((val >> 3) == 0b11110) {
                if (rem > 0)
                    return false;
                rem = 3;
            } else {
                if ((val >> 6) == 0b10 && rem > 0)
                    rem--;
                else
                    return false;
            }
        }
        return rem == 0;
    }
}
