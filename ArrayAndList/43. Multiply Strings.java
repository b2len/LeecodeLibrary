class Solution {

    //
    public String multiply(String num1, String num2) {
        // check for valid input
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Input numbers are not valid");
        }

        int m = num1.length();
        int n = num2.length();

        // Corner cases
        if (m == 0 || n == 0 || "0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        if ("1".equals(num1))
            return num2;
        if ("1".equals(num2))
            return num1;

        // observe the result can be maximum of length N + M
        // think 99 * 99 = 9801, this is the maximum two digits by two digits, it
        // results a length of 4
        int[] result = new int[m + n];

        // Start from the least significant digit, which is the last one
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // text code standard such as Unicode or ASCII has all digits in a sequence
                // therfore by minus 0's code you can got the actal integer value of the digit
                // in text
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); // Use single quotes for literal chars,
                                                                               // double quotes for literal Strings

                // Adding previous carryover value (if there's any) into the product
                product += result[i + j + 1];

                // Adding the new product into the result array
                result[i + j + 1] = product % 10; // The remaining of the product is the digit in that final result
                result[i + j] += product / 10; // Check if there's carray over

            }
        }

        // Generating the result String
        StringBuilder sb = new StringBuilder();

        for (int r : result) {
            // Ignoring leading zeros
            if (sb.length() == 0 && r == 0) {
                continue;
            }
            sb.append(r);
        }
        return sb.toString();
    }
}