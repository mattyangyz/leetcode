package MathRelated.ExcelSheet;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        int res = 0;
        for(char ch: columnTitle.toCharArray()){
            res *= 26;
            res += ch - 'A' + 1;
        }
        return res;
    }
}
