class Pair{
    String name;
    int t;
    Pair(String name, int t){
        this.name = name;
        this.t = t;
    }
}

class Pair2{
    int t, f;
    Pair2(int t, int f){
        this.t = t;
        this.f = f;
    }
}

class UndergroundSystem {
    Map<Integer, Pair> map;
    Map<String, Pair2> map2;

    public UndergroundSystem() {
        map = new HashMap<>();
        map2 = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        map.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair p = map.get(id);
        String key = p.name + " " + stationName;
        if(map2.containsKey(key)){
            Pair2 p2 = map2.get(key);
            map2.put(key, new Pair2(p2.t + t - p.t, p2.f + 1));
        } else
            map2.put(key, new Pair2(t - p.t, 1));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Pair2 p = map2.get(startStation + " " + endStation);
        return 1.0 * p.t / p.f;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
