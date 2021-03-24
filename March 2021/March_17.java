class Solution {
    double r, x, y;

    public Solution(double radius, double x_center, double y_center) {
        this.r = radius;
        this.x = x_center;
        this.y = y_center;
    }
    
    public double[] randPoint() {
        double minx = x - r, maxx = x + r, miny = y - r, maxy = y + r;
        double[] result = new double[2];
        result[0] = Math.random() * (maxx - minx) + minx;
        result[1] = Math.random() * (maxy - miny) + miny;
        while((result[0] - x) * (result[0] - x) + (result[1] - y) * (result[1] - y) >= r * r){
            result[0] = Math.random() * (maxx - minx) + minx;
            result[1] = Math.random() * (maxy - miny) + miny;
        }
        return result;
    }
}
    

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
