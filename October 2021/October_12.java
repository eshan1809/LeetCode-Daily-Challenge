/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1, hi = n;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2, x = guess(mid);
            if(x > 0)
                lo = mid + 1;
            else if(x < 0)
                hi = mid - 1;
            else
                return mid;
        }
        return 0;
    }
}
