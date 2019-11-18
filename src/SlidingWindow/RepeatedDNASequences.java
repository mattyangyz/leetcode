package SlidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Linkedin
 * <p>
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * <p>
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * <p>
 * Example:
 * <p>
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * <p>
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 * <p>
 * <p>
 * <p>
 * This is a great solution, and the enhancement in the comments is awesome!
 * It'd be really awesome if there are some comments describing the solution though.
 * <p>
 * So just if someone like me just walked in and might be struggling a bit with understanding what they both did,
 * 1. For the solution in the post
 * The whole idea is to transform the DNA string to numbers (so it'll be quicker for comparison),
 * and this is actually easy since we know for a fact that the sequence only consists of 4 letters (all upper case)
 * 'A', 'C', 'G' and 'T'.
 * <p>
 * If we want to map this to binary, we'd need (log 4 = 2)
 * 00 -> 'A'
 * 01 -> 'C'
 * 10 -> 'G'
 * 11 -> 'T'
 * <p>
 * so we create an array to save these values
 * <p>
 * char[] map = new char[26];
 * //map['A' - 'A'] = 0;
 * map['C' - 'A'] = 1;
 * map['G' - 'A'] = 2;
 * map['T' - 'A'] = 3;
 * Now to transform the sequences.
 * We want to compare every 10 letters to the rest of the sequence, so what we'll do here is:
 * <p>
 * Transform 10 letters
 * Try to add them to a set (if the sequence already exists in the set, it will return false)
 * Try to add them to a second set (If we managed to add it to the set, then this is only the second
 * time we found that sequence, otherwise, it means that we already found it twice, and we don't need
 * to add it to the output list)
 * Add the sequence to the output list only if we couldn't add the sequence to the first set, and
 * we successfully added it to the second set
 * So, let's transform the sequence:
 * First of all, we need 20 bits (10 letters * 2 bits for representing each letter)
 * So we start with a variable V = 0.
 * Then for each letter we shift V to the left by 2 bits and OR it with the letter representation
 * so for sequence "CG" for example:
 * v = 0
 * <p>
 * v <<= 2
 * v = 00
 * <p>
 * v |= map[s.charAt(j) - 'A'];
 * So map[s.charAt(j) - 'A'] = 0 = 01
 * v |= 01 = 01
 * <p>
 * Nex Character "G":
 * v = 01
 * <p>
 * v <<= 2
 * v = 0100
 * <p>
 * v |= map[s.charAt(j) - 'A'];
 * So map[s.charAt(j) - 'A'] = 0 = 10
 * v |= 0100 = 0110
 * <p>
 * and so on for the 10 chars.
 */

public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet<>();
        Set repeated = new HashSet();

        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten)) {
                repeated.add(ten);
            }
        }
        return new ArrayList<>(repeated);
    }

    public static List<String> findRepeatedDnaSequencesOpt(String s) {

        Set<Integer> words = new HashSet<>();
        List<String> ans = new ArrayList<>();
        char[] map = new char[26];
        map['A' - 'A'] = 0;         // 00
        map['C' - 'A'] = 1;         // 01
        map['G' - 'A'] = 2;         // 10
        map['T' - 'A'] = 3;         // 11

        for (int i = 0; i + 9 < s.length(); i++) {
            int v = 0;
            for (int j = i; j < i + 10; j++) {
                v <<= 2;                                        // 如果上一个结果是01, 现在就是0100
                v |= map[s.charAt(j) - 'A'];                    //
            }

            boolean bool = !words.add(v);
            System.out.println(bool);

            if (!bool) {
                ans.add(s.substring(i, i + 10));
            }
        }
        return ans;
    }
}
