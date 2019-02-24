package hackerrank;

public class Abbreviation {

    static String abbreviation(String a, String b) {
        boolean[][] isValid = new boolean[a.length()+1][b.length()+1];
        // 多初始化一行一列，这样方便进行匹配计算
        isValid[0][0] = true;
        // 对b为空，a不为空的情况，a中无大写字母时为true，否则为false
        boolean containsUppercase = false;
        for (int k = 1; k <= a.length(); k++) {
            int i = k - 1;
            // 对a中有大写字母情况进行判断
            if (a.charAt(i) <= 90 && a.charAt(i) >= 65 || containsUppercase) {
                containsUppercase = true;
                isValid[k][0] = false;
            }
            else isValid[k][0] = true;
        }
        // 从字符串开头进行匹配，[0][0]是开始节点
        for (int k = 1; k <= a.length(); k++) {
            for (int l = 1; l <= b.length(); l++) {
                int i = k - 1; int j = l - 1;
                // when the characters are equal, set = previous character bool.
                if (a.charAt(i) == b.charAt(j)) {
                    isValid[k][l] = isValid[k-1][l-1];
                    continue;
                }
                // elif uppercase a == b, set = prev character bool. or just eat a.
                else if ((int) a.charAt(i) - 32 == (int) b.charAt(j)) {
                    isValid[k][l] = isValid[k-1][l-1] || isValid[k-1][l];
                    continue;
                }
                // elif a is uppercase and no more b, or uppercase a is not b, then false
                else if (a.charAt(i) <= 90 && a.charAt(i) >= 65) {
                    isValid[k][l] = false;
                    continue;
                }
                //else just eat a
                else {
                    isValid[k][l] = isValid[k-1][l];
                    continue;
                }
            }
        }
        return isValid[a.length()][b.length()]? "YES" : "NO";
    }

}
