class UndergroundSystem {
public:
    map<int, pair<string, int> > arrival;
    map<string, pair<int, int> > mp;
    
    UndergroundSystem() {
        arrival.clear();
        mp.clear();
    }
    
    void checkIn(int id, string stationName, int t) {
        arrival[id] = make_pair(stationName, t);
    }
    
    void checkOut(int id, string stationName, int t) {
        auto p = arrival[id];
        string key = p.first + " " + stationName;
        if(mp.find(key) == mp.end())
            mp[key] = make_pair(t - p.second, 1);
        else{
            auto p2 = mp[key];
            mp[key] = make_pair(p2.first + t - p.second, p2.second + 1);
        }
    }
    
    double getAverageTime(string startStation, string endStation) {
        auto p = mp[startStation + " " + endStation];
        return 1.0 * p.first / p.second;
    }
};

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem* obj = new UndergroundSystem();
 * obj->checkIn(id,stationName,t);
 * obj->checkOut(id,stationName,t);
 * double param_3 = obj->getAverageTime(startStation,endStation);
 */
