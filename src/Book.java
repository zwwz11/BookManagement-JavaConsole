public class Book {
    private int price; // 가격
    private String name; // 제목
    private String description; // 설명

    private Book(String name, int price, String description){
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public static Book getBook(String name,int price, String description){
        return new Book(name, price, description);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
