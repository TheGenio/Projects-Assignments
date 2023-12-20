package LAB11;


class LongestPrefixSuffix {

    public static String findLongestPrefixSuffix(String input) {
        int n = input.length();

        for (int i = n / 2; i > 0; i--) {
            String prefix = input.substring(0, i);
            String suffix = input.substring(n - i);

            if (prefix.equals(suffix)) {
                return prefix;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        String input = "ABABABABAB";
        String result = findLongestPrefixSuffix(input);

        if (!result.isEmpty()) {
            System.out.println("Longest non-overlapping suffix that is also a prefix is: " + result + " its length is: "+ result.length());
        } else {
            System.out.println("No non-overlapping suffix that is also a prefix.");
        }
    }
}
