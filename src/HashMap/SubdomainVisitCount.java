package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.
 * <p>
 * Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".
 * <p>
 * We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.
 * <p>
 * Example 1:
 * Input:
 * ["9001 discuss.leetcode.com"]
 * Output:
 * ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
 * Explanation:
 * We only have one website domain: "discuss.leetcode.com". As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.
 * <p>
 * Example 2:
 * Input:
 * ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * Output:
 * ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 * Explanation:
 * We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times. For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
 * <p>
 * 思路: 正常的hashmap加indexof和substring去一个一个遍历做。 没什么难的算法。
 */

public class SubdomainVisitCount {

    public List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> map = new HashMap<>();
        for (String cd : cpdomains) {
            int spaceIndex = cd.indexOf(' ');
            int n = Integer.valueOf(cd.substring(0, spaceIndex));
            String fullDomain = cd.substring(spaceIndex + 1);
            map.put(fullDomain, map.getOrDefault(fullDomain, 0) + n);
            for (int i = 0; i < fullDomain.length(); i++) {
                if (fullDomain.charAt(i) == '.') {
                    String subDomain = fullDomain.substring(i + 1);
                    map.put(subDomain, map.getOrDefault(subDomain, 0) + n);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (String domain : map.keySet()) {
            res.add(map.get(domain) + " " + domain);
        }
        return res;
    }
}
