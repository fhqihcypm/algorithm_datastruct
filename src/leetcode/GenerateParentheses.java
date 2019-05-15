package leetcode;

import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateOneByOne(result, "", n , n);
        return result;
    }

    public void generateOneByOne(List<String> result, String sublist, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(sublist);
            return;
        }
        if (left > 0) {
            generateOneByOne(result, sublist+"(", left - 1, right);
        }
        if (right > left) {
            generateOneByOne(result, sublist+")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses tmp = new GenerateParentheses();
        tmp.generateParenthesis(3);
    }
}
