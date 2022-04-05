class Solution {
public:
    int find(vector<pair<int, int> > &arr, int val){
        int ans = arr.size(), lo = 0, hi = ans - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(arr[mid].first < val)
                lo = mid + 1;
            else{
                ans = mid;
                hi = mid - 1;
            }
        }
        return ans;
    }
    
    int maxArea(vector<int>& height) {
        int n = height.size();
        vector<int> left(n), right(n);
        
        vector<pair<int, int> > arr;
        for(int i = 0; i < n; i++){
            int idx = find(arr, height[i]);
            if(idx == arr.size())
                arr.push_back(make_pair(height[i], i));
            left[i] = arr[idx].second;
        }
        
        arr.clear();
        for(int i = n - 1; i >= 0; i--){
            int idx = find(arr, height[i]);
            if(idx == arr.size())
                arr.push_back(make_pair(height[i], i));
            right[i] = arr[idx].second;
        }
        
        int area = 0;
        for(int i = 0; i < n; i++)
            area = max(area, (right[i] - left[i]) * height[i]);
        
        return area;
    }
};
