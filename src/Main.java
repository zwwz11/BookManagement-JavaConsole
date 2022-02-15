import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ArrayList<Member> memberList = new ArrayList<Member>(); // 회원 리스트
    private static ArrayList<Book> bookList = new ArrayList<Book>(); // 북 리스트

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        System.out.println("도서관리 프로그램 실행.");
        while(true){
            System.out.println("================= 도서관리 프로그램 입니다.=====================");
            System.out.println("01. 회원등록 \t02. 도서등록 \t03. 회원조회 \t04. 도서조회");
            System.out.println("05. 회원삭제 \t06. 도서삭제 \t07. 도서대여 \t08. 도서반납");
            System.out.println("09. 대여리스트\t10. 반납리스트");
            System.out.println("============================================================");

            System.out.print("실행할 기능을 선택하세요. (프로그램 종료 : 0) => ");
            Scanner sc = new Scanner(System.in);
            int trigger = Util.getScannerNextInt();;
            if(trigger > 10 || trigger < 0){
                System.out.println("잘못된 숫자를 입력하셨습니다. 다시 입력하세요");
                continue;
            }

            switch (trigger){
                case 0:
                    System.out.println("도서관리 프로그램을 종료합니다.");
                    return;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
            }

        }
    }

    public static void addMember() {
        Scanner sc = new Scanner(System.in);
        String name;
        String sex;
        int age;

        System.out.println("회원을 등록합니다.");
        System.out.print("이름 : ");
        name = sc.next();
        System.out.print("성별 : ");
        sex = sc.next();
        System.out.print("나이 : ");
        age = Util.getScannerNextInt();



    }
}
