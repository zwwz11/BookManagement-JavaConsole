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
                case 0: // 종료
                    System.out.println("도서관리 프로그램을 종료합니다.");
                    return;
                case 1: // 회원등록
                    addMember();
                    break;
                case 2: // 도서등록
                    addBook();
                    break;
                case 3: // 회원조회
                    displayMemberList();
                    break;
                case 4: // 도서조회
                    displayBookList();
                    break;
                case 5: // 회원삭제
                    break;
                case 6: // 도서삭제
                    break;
                case 7: // 도서대여
                    break;
                case 8: // 도서반납
                    break;
                case 9: // 대여리스트
                    break;
                case 10: // 반납리스트
                    break;
            }

        }
    }

    /*
     * memberList에 Member 추가
     */
    private static void addMember() {
        Scanner sc = new Scanner(System.in);
        String name;
        String sex;
        int age;

        System.out.println("\r\n회원을 등록합니다.");
        System.out.print("이름 : ");
        name = sc.next();
        System.out.print("성별 : ");
        sex = sc.next();
        System.out.print("나이 : ");
        age = Util.getScannerNextInt();

        memberList.add(Member.getMember(name, sex, age));
        System.out.println("등록되었습니다. \r\n");
    }
    /*
     * bookList에 Book 추가
     */
    private static void addBook(){
        Scanner sc = new Scanner(System.in);
        String name;
        int price;
        String description;

        System.out.println("\r\n도서를 등록합니다.");
        System.out.print("제목 : ");
        name = sc.next();
        System.out.print("가격 : ");
        price = Util.getScannerNextInt();
        System.out.print("설명 : ");
        description = sc.next();

        bookList.add(Book.getBook(name, price, description));
        System.out.println("등록되었습니다. \r\n");
    }
    /*
     * memberList의 목록을 보여줌
     */
    private static void displayMemberList(){
        System.out.println("\r\n회원 목록");
        for(int i = 0; i < memberList.size(); i++){
            Member member = memberList.get(i);
            String message = String.format("%d. 이름: %-10s \t 나이: %-5d \t 성별: %-10s", i+1, member.getName(), member.getAge(), member.getSex());
            System.out.println(message);
        }
        System.out.println();
    }
    /*
     * bookList의 목록을 보여줌
     */
    private static void displayBookList(){
        System.out.println("\r\n도서 목록");
        for(int i = 0; i < bookList.size(); i++){
            Book book = bookList.get(i);
            String message = String.format("%d. 제목: %-10s \t 가격: %-10d \t 설명: %-30s", i+1, book.getName(), book.getPrice(), book.getDescription());
            System.out.println(message);
        }
        System.out.println();
    }
}
