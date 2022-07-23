class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int add = (int)1e4 + 5;
        FT ft = new FT();
        for(int i = nums.length - 1; i >= 0; i--){
            int curr = nums[i] + add;
            list.add(Math.max(ft.query(1, curr - 1), 0));
            ft.update(curr, 1);
        }
        Collections.reverse(list);
        return list;
    }
    
    class FT {
        int n;
        int[] tree;

        FT() {
            n = (int)2e4 + 10;
            tree = new int[n + 1];
        }

        // 1 based indexing
        void update(int idx, int val) {
            while (idx <= n) {
                tree[idx] += val;
                idx += idx & -idx;
            }
        }

        // 1 based indexing
        int query(int l, int r) {
            return getSum(r) - getSum(l - 1);
        }

        int getSum(int idx) {
            int ans = 0;
            while (idx > 0) {
                ans += tree[idx];
                idx -= idx & -idx;
            }
            return ans;
        }
    }
}
