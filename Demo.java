import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class Solution {

    public boolean isValid(String s) {
        Stack<Character> newStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                newStack.push(ch);
            } else {
                    
                if (newStack.isEmpty()) return false;
                 else if ((ch == ')' && newStack.peek() == '(')
                        || (ch == ']' && newStack.peek() == '[')
                        || (ch == '}' && newStack.peek() == '{')) {
                    newStack.pop();
                } else {
                    return false;
                }
            }
        }
        return newStack.isEmpty();
    }

    public int[] characterFrequncy(String str) {
        int[] newArr = new int[26];
        char[] arr = str.toCharArray();

        for (char c : arr) {
            int charA = 'a';
            int charAscii = c;
            newArr[charAscii - charA] += 1;
        }
        return newArr;
    }

    public List<Integer> frequencyCount(int[] arr) {
        List<Integer> newList = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            newList.add(0);
        }
        for (int i = 0; i < arr.length; i++) {
            int value = newList.get(arr[i] - 1);
            newList.set(arr[i] - 1, value + 1);
        }
        return newList;
    }

    public void hashing(int arr[], int[] searchValues, int max) {
        int[] hashArr = new int[max];
        for (int i = 0; i < arr.length; i++) {
            hashArr[arr[i]] += 1;
        }
        for (int i = 0; i < searchValues.length; i++) {
            System.out.println(hashArr[searchValues[i]]);
        }
    }

    public int findFebonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int first = findFebonacci(n - 1);
        int second = findFebonacci(n - 2);

        return first + second;
    }

    public String reverseWords(String s) {

        String[] arr = s.trim().split("\\s+");
        int left = 0;
        while (arr.length / 2 > left) {
            int pointer2 = arr.length - 1 - left;
            String temp = arr[left];
            arr[left] = arr[pointer2];
            arr[pointer2] = temp;
            left += 1;
        }

        String sentence = String.join(" ", arr);
        return sentence;
    }

    public boolean isPalindrome(String s) {
        String keyWordsRemoved = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().replaceAll(" ", "");
        char[] array = keyWordsRemoved.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while (right >= left) {
            if (array[left] != array[right]) {
                return false;
            }
            right = right - 1;
            left = left + 1;
        }
        return true;
    }

    public boolean checkPalidrome(char[] charArr, int left, int right) {
        if (left >= right) {
            return true;
        } else if (charArr[left] != charArr[right]) {
            return false;
        }
        return checkPalidrome(charArr, left + 1, right - 1);
    }

    public int[] arrayReversetwoPointer(int[] arr, int left, int right) {
        if (left >= right) {
            return arr;
        }
        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
        return arrayReversetwoPointer(arr, left + 1, right - 1);
    }

    public int[] reverseArrayRecurssion(int[] arr, int pointer, int increment) {
        if (pointer < arr.length / 2) {
            return arr;
        }
        int frontPointer = arr.length - 1 - pointer;
        int temp = arr[pointer];
        arr[pointer] = arr[frontPointer];
        arr[frontPointer] = temp;
        return reverseArrayRecurssion(arr, pointer - 1, increment + 2);
    }

    public int functionalFactorialRecurssion(int n) {
        if (n == 0) {
            return 1;
        }
        return n * functionalFactorialRecurssion(n - 1);
    }

    public int functionalSumRecurssion(int n) {
        if (n == 0) {
            return 0;
        }
        return n + functionalSumRecurssion(n - 1);
    }

    public void paramaterizedRecurssionSum(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }
        paramaterizedRecurssionSum(i - 1, sum + i);
    }

    // backtracking
    public void printNums4(int i, int n) {
        if (i > n) {
            return;
        }
        printNums4(i + 1, n);
        System.out.println(i);
    }

    // backtracking
    public void printNums3(int i, int n) {
        if (i < 1) {
            return;
        }
        printNums3(i - 1, n);
        System.out.println(i);
    }

    public void printNums2(int i, int j) {
        if (i < 1) {
            return;
        }
        System.out.println(i);
        printNums2(i - 1, j);
    }

    public void printNums(int i, int n) {
        if (i > n) {
            return;
        }
        System.out.println(i);
        printNums(i + 1, n);
    }

    public void printLinearly(int i, int n) {
        if (i > n) {
            return;
        }
        for (int j = 0; j < i; j++) {
            System.out.print(" Aman ");
        }
        System.out.println();
        printLinearly(i + 1, n);
    }

    public void printNameNTimes(int n) {
        if (n < 1) {
            return;
        }
        System.out.println("Aman");
        printNameNTimes(n - 1);
    }

    public void printFactors(int a) {
        for (int i = 1; i * i <= a; i++) {
            if (a % i == 0) {
                System.out.println(i);
                System.out.println(a / i);
            }
        }
    }

    public static int[] lcmAndGcd(int a, int b) {
        int originalA = a;
        int originalB = b;
        int gcd = 0;
        int lcm = 1;
        int divisible = 2;

        while (a != 1 || b != 1) {
            if (a % divisible == 0 || b % divisible == 0) {
                lcm *= divisible;
            }
            if (a % divisible == 0) {
                a /= divisible;
            }
            if (b % divisible == 0) {
                b /= divisible;
            }
            if (a % divisible != 0 && b % divisible != 0) {
                divisible++;
            }
        }

        while (originalA != 0 && originalB != 0) {
            if (originalA > originalB) {
                originalA = originalA % originalB;
            } else if (originalB > originalA) {
                originalB = originalB % originalA;
            }
        }
        if (originalA == 0) {
            gcd = originalB;
        } else {
            gcd = originalA;
        }
        int[] arr = new int[2];
        arr[0] = lcm;
        arr[1] = gcd;
        return arr;
    }

    public boolean checkArmstrong(int x) {
        int sum = 0;
        int d = String.valueOf(x).length();
        int num = x;
        while (x > 0) {
            int ld = x % 10;
            sum += Math.pow(ld, d);
            x = x / 10;
        }
        return num == sum;
    }

    public boolean isPalindrome(int x) {
        int reverse = 0;
        int num = x;
        while (x > 0) {
            int ld = x % 10;
            reverse = (reverse * 10) + ld;
            x = x / 10;
        }
        if (reverse == num) {
            return true;
        } else {
            return false;
        }
    }

    public int reverse(int num) {

        int sum = 0;
        boolean negative = num < 0;

        if (negative) {
            num = -num;
        }

        while (num > 0) {
            int lastDigit = num % 10;

            if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0;
            }

            sum = (sum * 10) + lastDigit;
            num = num / 10;
        }

        return negative ? -sum : sum;
    }

    public int reverse2(int num) {

        int sum = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            sum = (sum * 10) + lastDigit;
            num = num / 10;
        }
        ;
        return sum;
    }

    public boolean canJump(int[] nums) {
        int jumped = 0;
        boolean canJump = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < jumped + i; i++) {

            }
        }
        return canJump;
    }

    public Map<String, Object> bubbleSort(int[] arr) {
        int n = arr.length;
        int sum = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int num : arr) {
            sum += num;
        }

        Map<String, Object> result = new HashMap<>();
        result.put("sortedArray", arr);
        result.put("sum", sum);
        return result;
    }

    public int hIndex(int[] citations) {
        int h = 0;
        Map<String, Object> result = bubbleSort(citations);

        citations = (int[]) result.get("sortedArray");
        int totalCitations = (int) result.get("sum");

        for (int i = 0; i < citations.length; i++) {
            int hIndex = i + 1;
            if (hIndex * hIndex > totalCitations) {
                return hIndex - 1;
            }
            totalCitations = totalCitations - citations[i];
        }
        return h;
    }

}

// public class Demo {
// public static void main(String[] args) {

// Solution dsaPractice = new Solution();
// int[] newArr = dsaPractice.characterFrequncy("aa");
// String str = Arrays.toString(newArr);
// System.out.println(str);
// }
// }

class frequencyCount2 {
    public int[] frequncyCount(int[] nums, int k, int maxLength) {

        int[] newArr = new int[maxLength + 1];

        for (int i = 0; i < nums.length; i++) {

            System.out.println(Arrays.toString(newArr));
            newArr[nums[i]] = newArr[nums[i]] + 1;
        }
        return newArr;
    }
}

public class Demo {
    public static void main(String[] args) {

        Solution dsaPractice = new Solution();
        String s = "[{}{}{}(})[]]";
        boolean answer = dsaPractice.isValid(s);
        System.out.println(answer);
    }
}
