package Design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * TinyURL is a URL shortening service where you enter a URL
 * such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * <p>
 * Design the encode and decode methods for the TinyURL service.
 * There is no restriction on how your encode/decode algorithm should work.
 * You just need to ensure that a URL can be encoded to a tiny URL and
 * the tiny URL can be decoded to the original URL.
 * <p>
 * 思路: 如何handle已经存在的问题。这个是followup需要考虑。
 */

public class EncodeAndDecodeTinyURL {

    Map<Integer, String> map = new HashMap<>();
    String host = "http://tinyurl.com/";


    String mapping = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Map<String, String> map2 = new HashMap<>();

    public String encode(String longUrl) {
        int key = longUrl.hashCode();
        map.put(key, longUrl);
        return host + key;
    }

    public String decode(String shortUrl) {
        int key = Integer.parseInt(shortUrl.replace(host, ""));
        return map.get(key);
    }

    public String encode2(String longUrl) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(mapping.length());
            sb.append(mapping.charAt(index));
        }
        String url = host + sb.toString();
        if (!map2.containsKey(url)) {
            map2.put(url, longUrl);
        }
        return url;
    }

    public String decode2(String shortURL) {
        return map2.get(shortURL);
    }

}
