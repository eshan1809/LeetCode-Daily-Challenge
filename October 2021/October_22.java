class Solution {
    public class Pair implements Comparable<Pair>{
        char ch;
        int freq;
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
        public int compareTo(Pair o){
            return o.freq - this.freq;
        }
    }
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(char ch : map.keySet())
            pq.add(new Pair(ch, map.get(ch)));
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair rem = pq.remove();
            for(int i = 0; i < rem.freq; i++)
                sb.append(rem.ch);
        }
        return sb.toString();
    }
}
