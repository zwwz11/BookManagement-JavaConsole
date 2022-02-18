import javax.swing.text.html.HTMLDocument;
import java.lang.reflect.Type;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    private static ArrayList<Member> memberList = new ArrayList<>(); // 회원 리스트
    private static ArrayList<Book> bookList = new ArrayList<>(); // 북 리스트
    private static HashMap<Book, Member> rentalList = new HashMap<>(); // 대여 리스트

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        System.out.println("도서관리 프로그램 실행.");
        while(true){
            System.out.println("================= 도서관리 프로그램 입니다.=====================");
            System.out.println("01. 회원등록 \t02. 도서등록 \t03. 회원조회 \t04. 도서조회");
            System.out.println("05. 회원삭제 \t06. 도서삭제 \t07. 도서대여 \t08. 도서반납");
            System.out.println("09. 회원수정 \t10. 도서수정 \t11. 대여리스트 \t12. 반납리스트");
            System.out.println("============================================================");
            System.out.println("asd");
            System.out.print("실행할 기능을 선택하세요. (프로그램 종료 : 0) => ");
            Scanner sc = new Scanner(System.in);
            int trigger = Util.getScannerNextInt();
            if(trigger > 12 || trigger < 0){
                System.out.println("잘못된 숫자를 입력하셨습니다. 다시 입력하세요");
                continue;
            }

            switch (trigger){
                // 종료
                case 0 -> {
                    System.out.println("도서관리 프로그램을 종료합니다.");
                    return;
                }
                // 회원등록
                case 1 -> addMember();
                // 도서등록
                case 2 -> addBook();
                // 회원조회
                case 3 -> displayMemberList();
                // 도서조회
                case 4 -> displayBookList();
                // 회원삭제
                case 5 -> deleteMember();
                // 도서삭제
                case 6 -> deleteBook();
                // 도서대여
                case 7 -> lendBook();
                // 도서반납
                case 8 -> returnBook();
                // 회원수정
                case 9 -> updateMember();
                // 도서수정
                case 10 -> updateBook();
                // 대여리스트
                case 11 -> displayRentalList();
                // 반납리스트
                //case 12 -> {}
            }

        }
    }

    /* memberList에 Member 추가 */
    private static void addMember() {
        Scanner sc = new Scanner(System.in);
        String name;
        String sex;
        int age;

        System.out.println("\r\n회원을 등록합니다.");
        System.out.print("이름 : ");
        name = sc.next();
        System.out.print("성별(Male or Female) : ");
        sex = Util.getScannerSex();
        System.out.print("나이 : ");
        age = Util.getScannerNextInt();

        memberList.add(Member.getMember(name, sex, age));
        System.out.println("등록되었습니다. \r\n");
    }
    /* bookList에 Book 추가 */
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
    /* memberList의 목록을 보여줌 */
    private static void displayMemberList(){
        System.out.println("\r\n회원 목록");
        for(int i = 0; i < memberList.size(); i++){
            Member member = memberList.get(i);
            String message = String.format("%d. 이름: %-10s \t 나이: %-5d \t 성별: %-10s", i+1, member.getName(), member.getAge(), member.getSex());
            System.out.println(message);
        }
        System.out.println();
    }
    /* bookList의 목록을 보여줌 */
    private static void displayBookList(){
        System.out.println("\r\n도서 목록");
        for(int i = 0; i < bookList.size(); i++){
            Book book = bookList.get(i);
            String message = String.format("%d. 제목: %-10s \t 가격: %-10d \t 설명: %-30s", i+1, book.getName(), book.getPrice(), book.getDescription());
            System.out.println(message);
        }
        System.out.println();
    }
    /* 도서 대여 리스트 */
    private static void displayRentalList(){
        System.out.println("\r\n도서 대여 목록");
        for(Book book : rentalList.keySet()){
            String message = String.format("대여자: %-10s \t 대여 도서: %-20s", rentalList.get(book).getName(), book.getName());
            System.out.println(message);
        }
        System.out.println();
    }
    /* 회원 삭제*/
    private static void deleteMember(){
        Scanner sc = new Scanner(System.in);
        String memberName;
        System.out.print("\r\n삭제할 회원 이름을 입력하세요 => ");
        memberName = sc.next();
        var targetMember = memberList.stream().filter(x -> x.getName().equals(memberName)).findFirst();
        if(targetMember.isPresent()){
            memberList.remove(targetMember.get());
            System.out.println(memberName + " 회원이 삭제되었습니다.");
        } else{
            System.out.println(memberName + " 회원은 존재하지 않습니다.");
        }
        System.out.println();
    }
    /* 도서 삭제*/
    private static void deleteBook(){
        Scanner sc = new Scanner(System.in);
        String bookName;
        System.out.print("\r\n삭제할 도서를 입력하세요 => ");
        bookName = sc.next();
        var targetBook = bookList.stream().filter(x -> x.getName().equals(bookName)).findFirst();
        if(targetBook.isPresent()){
            bookList.remove(targetBook.get());
            System.out.println(bookName + " 도서는 삭제되었습니다.");
        } else{
            System.out.println(bookName + " 도서는 존재하지 않습니다.");
        }
        System.out.println();
    }
    /* 도서 대여 */
    private static void lendBook(){
        Scanner sc = new Scanner(System.in);
        String bookName;
        String memberName;

        System.out.println("\r\n도서 대여 서비스입니다.");

        System.out.print("대여할 도서를 입력하세요 => ");
        bookName = sc.next();
        var targetBook = bookList.stream().filter(x -> x.getName().equals(bookName)).findFirst();
        if(!targetBook.isPresent()){
            System.out.println(bookName + " 도서는 존재하지 않습니다.");
            return;
        }
        if(rentalList.containsKey(targetBook.get())){
            System.out.println(bookName + " 도서는 " + rentalList.get(targetBook.get()).getName() + " 회원님이 대여중입니다.");
            return;
        }

        System.out.print("대여해줄 회원을 입력하세요 => ");
        memberName = sc.next();
        var targetMember = memberList.stream().filter(x -> x.getName().equals(memberName)).findFirst();
        if(!targetMember.isPresent()){
            System.out.println(memberName + " 회원은 존재하지 않습니다.");
            return;
        }

        rentalList.put(targetBook.get(), targetMember.get());
        System.out.println(targetMember.get().getName() + "에게 " + targetBook.get().getName() + " 도서를 대여했습니다.");
    }
    /* 도서 반납 */
    private static void returnBook(){
        Scanner sc = new Scanner(System.in);
        String bookName;

        System.out.println("\r\n 도서 반납 서비스입니다.");

        System.out.println("반납될 도서를 입력하세요 => ");
        bookName = sc.next();
        var targetBook = bookList.stream().filter(x -> x.getName().equals(bookName)).findFirst();
        if(!targetBook.isPresent()){
            System.out.println(bookName + " 도서는 존재하지 않습니다.");
            return;
        }

        if(rentalList.containsKey(targetBook.get())){
            System.out.println(rentalList.get(targetBook.get()).getName() + " 회원님이 대여한 " + bookName + " 도서를 반납합니다.");
            rentalList.remove(targetBook.get());
        } else{
            System.out.println(bookName + " 도서는 대여되지 않은 도서입니다.");

        }
    }
    /* 회원 수정 */
    private static void updateMember() {
        Scanner sc = new Scanner(System.in);
        String memberName;
        System.out.print("\r\n수정할 회원 이름을 입력하세요 => ");
        memberName = sc.next();
        var targetMember = memberList.stream().filter(x -> x.getName().equals(memberName)).findFirst();
        if (!targetMember.isPresent()) {
            System.out.println(memberName + " 회원은 존재하지 않습니다.");
            return;
        }

        System.out.println("수정할 항목 선택( ','로 중복선택가능 ex. 1,2,3 )");
        System.out.println("1.이름 2.나이 3.성별");
        String[] trigger;
        triggerLoop : while (true) {
            Scanner sc2 = new Scanner(System.in);
            String triggerGroup = sc2.next();
            trigger = triggerGroup.replace(" ", "").split(",");
            for (String s : trigger) {
                if (!Util.canParseInt(s)) {
                    System.out.println("입력이 정확하지 않습니다. 다시 입력해주세요");
                    continue triggerLoop;
                }
            }
            break;
        }

        String changeName;
        String changeSex;
        int changeAge;
        Iterator<String> iterator = Arrays.stream(trigger).iterator();
        while (iterator.hasNext()) {
            switch (Integer.parseInt(iterator.next())) {
                case 1 -> {
                    System.out.print("변경할 이름을 입력하세요 =>");
                    changeName = sc.next();
                    targetMember.get().setName(changeName);
                }
                case 2 -> {
                    System.out.print("변경할 나이를 입력하세요 =>");
                    changeAge = Util.getScannerNextInt();
                    targetMember.get().setAge(changeAge);
                }
                case 3 -> {
                    System.out.print("변경할 성별을 입력하세요 =>");
                    changeSex = Util.getScannerSex();
                    targetMember.get().setSex(changeSex);
                }
            }
        }

        System.out.println("변경이 완료되었습니다. \r\n");
    }
    /* 도서 수정 */
    private static void updateBook() {
        Scanner sc = new Scanner(System.in);
        String bookName;
        System.out.print("\r\n수정할 도서를 입력하세요 => ");
        bookName = sc.next();
        var targetBook = bookList.stream().filter(x -> x.getName().equals(bookName)).findFirst();
        if (!targetBook.isPresent()) {
            System.out.println(bookName + " 도서는 존재하지 않습니다.");
            return;
        }

        System.out.println("수정할 항목 선택( ','로 중복선택가능 ex. 1,2,3 )");
        System.out.println("1.제목 2.가격 3.설명");
        String[] trigger;
        triggerLoop : while (true) {
            Scanner sc2 = new Scanner(System.in);
            String triggerGroup = sc2.next();
            trigger = triggerGroup.replace(" ", "").split(",");
            for (String s : trigger) {
                if (!Util.canParseInt(s)) {
                    System.out.println("입력이 정확하지 않습니다. 다시 입력해주세요");
                    continue triggerLoop;
                }
            }
            break;
        }

        String changeName;
        int changePrice;
        String changeDescription;
        Iterator<String> iterator = Arrays.stream(trigger).iterator();
        while (iterator.hasNext()) {
            switch (Integer.parseInt(iterator.next())) {
                case 1 -> {
                    System.out.print("변경할 제목을 입력하세요 =>");
                    changeName = sc.next();
                    targetBook.get().setName(changeName);
                }
                case 2 -> {
                    System.out.print("변경할 나이를 입력하세요 =>");
                    changePrice = Util.getScannerNextInt();
                    targetBook.get().setPrice(changePrice);
                }
                case 3 -> {
                    System.out.print("변경할 설명을 입력하세요 =>");
                    changeDescription = sc.next();
                    targetBook.get().setDescription(changeDescription);
                }
            }
        }

        System.out.println("변경이 완료되었습니다. \r\n");
    }
}
