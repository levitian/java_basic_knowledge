/**
 * @description:
 * @author: tianli170405
 * @time: 2020/9/15 10:02
 */
public class TestMain {
    public static void main(String[] args) {
        String ocr_check_time = "2020-08-21 19:00:05.01";
        if ( ocr_check_time.indexOf(".") != -1) {
            ocr_check_time = ocr_check_time.substring(0, ocr_check_time.indexOf("."));
            System.out.println(ocr_check_time);
        }
    }
}
