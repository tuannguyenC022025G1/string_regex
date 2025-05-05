public class ClassNameValidator {

    public static boolean isValidClassName(String className) {
        return className.matches("^[CAP]\\d{4}[GHIK]$");
    }

    public static void main(String[] args) {
        // Test hợp lệ
        System.out.println(isValidClassName("C0223G")); // true
        System.out.println(isValidClassName("A0323K")); // true

        // Test không hợp lệ
        System.out.println(isValidClassName("M0318G")); // false (không bắt đầu bằng C/A/P)
        System.out.println(isValidClassName("P0323A")); // false (kết thúc sai)
        System.out.println(isValidClassName("C02@3G")); // false (chứa ký tự đặc biệt)
        System.out.println(isValidClassName("C023G"));  // false (không đủ 4 chữ số)
    }
}
