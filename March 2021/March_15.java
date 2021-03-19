public class Codec {
    Map<Integer, String> map = new HashMap<>();
    int val = 0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(val, longUrl);
        return "http://tinyurl.com/" + val++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int val = Integer.parseInt(shortUrl.substring(19));
        return map.get(val);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
