public class PhoneNumberValidator {

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^\\(\\d{2}\\)-\\(0\\d{9}\\)$");
    }

    public static void main(String[] args) {
        // Test hợp lệ
        System.out.println(isValidPhoneNumber("(84)-(0978489648)")); // true

        // Test không hợp lệ
        System.out.println(isValidPhoneNumber("(a8)-(22222222)"));     // false (chữ a + không đủ số)
        System.out.println(isValidPhoneNumber("(84)-(22b22222)"));     // false (chữ b trong số)
        System.out.println(isValidPhoneNumber("(84)-(9978489648)"));   // false (không bắt đầu bằng 0 sau dấu -)
        System.out.println(isValidPhoneNumber("(84)-(097848964)"));    // false (thiếu số)
    }
}
