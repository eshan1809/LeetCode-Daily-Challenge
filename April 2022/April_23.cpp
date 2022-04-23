class Solution {
public:
    vector<string> vec;
    int val = 0;
    // Encodes a URL to a shortened URL.
    string encode(string longUrl) {
        vec.push_back(longUrl);
        return "http://tinyurl.com/" + to_string(val++);
    }

    // Decodes a shortened URL to its original URL.
    string decode(string shortUrl) {
        return vec[stoi(shortUrl.substr(19))];
    }
};

// Your Solution object will be instantiated and called as such:
// Solution solution;
// solution.decode(solution.encode(url));
