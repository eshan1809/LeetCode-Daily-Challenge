class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if(len == 1){
            if(flowerbed[0] == 0)
                n--;
        } else{
            if(flowerbed[0] == 0 && flowerbed[1] == 0){
                flowerbed[0] = 1;
                n--;
            }
            for(int i = 1; i < len - 1; i++){
                if(flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0){
                    flowerbed[i] = 1;
                    n--;
                }
            }
            if(flowerbed[len - 2] == 0 && flowerbed[len - 1] == 0){
                flowerbed[len - 1] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}
