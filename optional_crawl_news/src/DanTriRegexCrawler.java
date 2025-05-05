import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DanTriRegexCrawler {

    public static String getHTML(String urlStr) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Đọc dòng từ response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line).append("\n");
            }
            rd.close();
        } catch (Exception e) {
            System.out.println("Lỗi khi tải trang: " + e.getMessage());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String url = "https://dantri.com.vn/the-gioi.htm";
        String html = getHTML(url);

        // Regex để tìm tiêu đề bài viết trong thẻ <h3 class="article-title">...</h3>
        Pattern pattern = Pattern.compile(
                "<h3 class=\"article-title\">\\s*<a[^>]*href=\"([^\"]+)\"[^>]*>(.*?)</a>\\s*</h3>"
        );
        Matcher matcher = pattern.matcher(html);

        System.out.println("Danh sách tiêu đề bài viết:");

        while (matcher.find()) {
            String link = "https://dantri.com.vn" + matcher.group(1); // nối với domain nếu cần
            String title = matcher.group(2).replaceAll("<[^>]*>", ""); // loại bỏ thẻ HTML nếu có
            System.out.println("- " + title + " (" + link + ")");
        }
    }
}
