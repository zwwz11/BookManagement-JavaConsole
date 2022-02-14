public class Book {

    private int id; // 고유 키
    private int price; // 가격
    private String name; // 제목
    private String description; // 설명

    private Book(int id, int price, String name, String description){
        this.id = id;
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public static Book getBook(int id, int price, String name, String description){
        return new Book(id, price, name, description);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    private void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
