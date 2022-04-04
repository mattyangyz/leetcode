package MathRelated.ExcelSheet;

/**
 * 没算法，暴力解法
 * <p>
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) ('A' + n % 26));   // 对于每26次 轮回一次
            n /= 26;                            // 对于每26次 转换一次
        }
        return sb.reverse().toString();
    }
}
