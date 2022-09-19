public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String path: paths){
            String[] values = path.split(" ");
            for(int i = 1; i < values.length; i++){
                String[] strs = values[i].split("\\(");
                strs[1] = strs[1].replace(")", "");
                if(!map.containsKey(strs[1]))
                    map.put(strs[1], new ArrayList<>());
                map.get(strs[1]).add(values[0] + "/" + strs[0]);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for(String key: map.keySet()){
            if(map.get(key).size() > 1)
                list.add(map.get(key));
        }
        return list;
    }
}
