import java.util.Scanner;

public class Util {
    public static int getScannerNextInt(){
        // 숫자외 값이 들어오면 int MinValue 값 할당
        Scanner sc = new Scanner(System.in);
        int value;
        try{
            value = sc.nextInt();
        }
        catch (Exception ex){
            value = Integer.MIN_VALUE;
        }

        return value;
    }
}
