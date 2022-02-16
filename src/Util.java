import java.util.Scanner;

public class Util {
    /* 숫자외 값이 들어오면 int MinValue 값 할당 */
    public static int getScannerNextInt(){
        int value;
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                value = sc.nextInt();
                break;
            } catch (Exception ex) {
                System.out.println("숫자를 입력하세요!");
                value = Integer.MIN_VALUE;
            }
        }
        return value;
    }
    /* 올바른 성별 입력을 위한  Scanner */
    public static String getScannerSex(){
        String sex;
        while (true) {
            Scanner sc = new Scanner(System.in);
            sex = sc.next();
            if(sex.compareToIgnoreCase("male") == 0 || sex.compareToIgnoreCase("female") == 0){
                return sex.toUpperCase();
            } else{
                System.out.println("올바른 성별을 입력해주세요");
            }
        }
    }
}
