public class Main {
    public static void main(String[] args) {
        String str = "Hello World!!!";

        System.out.println(size("Hello"));

        System.out.println(charAt(str, 7));

        System.out.println(contains(str, 'W'));

        System.out.println(countOfVowels(str));

        printReverseString(str);

        printCountVowelsAndDigits(str);

        ceasarCode("Testingxyz", 3);

        System.out.println(isPalindrome("basksaB"));

        System.out.println(isBinary("100011"));

        System.out.println(isHexString("123AbC"));

        bin2Dec("1101");

        printCountOfDuplicateNumbers(str);

        printFirstNonRepeatChar(str);

        printCountOccurence(str, '7');

    }


    /**
     * task1
     * returning length of given String
     *
     * @param str
     * @return
     */
    private static int size(String str) {
        return str.length();
    }

    /**
     * task2
     * returning char in given index from given String
     *
     * @param str
     * @param index
     */
    private static char charAt(String str, int index) {
        char[] array = str.toCharArray();
        if (index >= array.length || index <0) return ' ';
        return array[index];
    }

    /**
     * task3
     * returning true if given string contains given character
     *
     * @param str
     * @param ch
     * @return
     */
    private static boolean contains(String str, char ch) {
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ch) {
                return true;
            }
        }
        return false;
    }

    /**
     * task4
     * returning number of vowel characters in given string
     *
     * @param str
     * @return
     */
    private static int countOfVowels(String str) {
        int size = str.length();
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (isVowel(str.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    /**
     * task5
     * printing reverse variant of given string
     *
     * @param str
     */
    private static void printReverseString(String str) {
        int size = str.length();
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
    }

    /**
     * task6
     * printing percent of vowel and digits from given sting
     *
     * @param str
     */
    private static void printCountVowelsAndDigits(String str) {

        int countVowel = countOfVowels(str);

        int size = str.length();
        int countDigits = 0;
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                countDigits++;
            }
        }
        double vowelPercent = countVowel * 100.0 / size;
        double digitPercent = countDigits * 100.0 / size;

        System.out.printf("Number of vowels: " + countVowel + " (" + " %.2f %%)", vowelPercent);
        System.out.printf("\nNumber of digits: " + countDigits + " (" + " %.2f %%)", digitPercent);
    }

    /**
     * task7
     * encrypting and printing given string using ceasar's codding with given number
     *
     * @param str
     * @param index
     */
    private static void ceasarCode(String str, int index) {
        str = str.toUpperCase();
        int size = str.length();
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) + index > 90){
                System.out.print((char)((str.charAt(i) + index)-26));
            }else System.out.print((char) (str.charAt(i) + index));
        }
    }

    /**
     * task8
     *
     * @param str
     * @return
     */
    private static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        int size = size(str);
        for (int i = 0; i < size / 2; i++) {
            if (str.charAt(i) != str.charAt(size - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * task9
     * checking is given String number valid binary number
     *
     * @param str
     * @return
     */
    private static boolean isBinary(String str) {
        int size = size(str);
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) != '0' && str.charAt(i) != '1') {
                return false;
            }
        }
        return true;
    }

    /**
     * task10
     * checking is given string valid hex number
     *
     * @param str
     * @return
     */
    private static boolean isHexString(String str) {
        int size = size(str);
        for (int i = 0; i < size; i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9') && !(str.charAt(i) >= 'A' && str.charAt(i) <= 'F') && !(str.charAt(i) >= 'a' && str.charAt(i) <= 'f')) {
                return false;
            }
        }
        return true;
    }

    /**
     * task11
     * printing decimal value of given binary number
     *
     * @param str
     */
    private static void bin2Dec(String str) {
        if (!isBinary(str)) {
            System.out.println("Number is invalid binary number");
            return;
        }
        int size = size(str);
        int decNum = 0;
        for (int i = size - 1; i >= 0; i--) {
            decNum += Character.getNumericValue(str.charAt(i)) * (int) Math.pow(2, size - 1 - i);
        }
        System.out.println(decNum);
    }

    /**
     * task12
     * printing number of duplicate chars in given String
     *
     * @param str
     */
    private static void printCountOfDuplicateNumbers(String str) {
        int size = size(str);
        String newStr = "";
        for (int i = 0; i < size -1; i++) {
            for (int j = i + 1; j < size ; j++) {
                if (str.charAt(i) == str.charAt(j) && !contains(newStr, str.charAt(i))) {
                    newStr += str.charAt(i);
                    break;
                }
            }
        }
        System.out.println(size(newStr));
    }

    /**
     * task13
     * printing the first non-repeated character from a given string.
     *
     * @param str
     */
    private static void printFirstNonRepeatChar(String str) {
        int size = size(str);
        for (int i = 0; i < size; i++) {
            if (!contains(str.substring(i + 1), str.charAt(i)) && !contains(str.substring(0, i), str.charAt(i))) {
                System.out.println(str.charAt(i));
                break;
            }
        }
    }

    /**
     * task14
     * print how many times given char occurrences in given String
     *
     * @param str
     * @param ch
     */
    private static void printCountOccurence(String str, char ch) {
        int count = 0;
        int size = size(str);
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * checking is given char vowel or not
     * @param ch
     * @return
     */
    private static boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' );
    }
}
