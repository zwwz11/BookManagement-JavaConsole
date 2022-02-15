public class Member {
    private String name;
    private String sex;
    private int age;

    private Member(String name, String sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public static Member getMember(String name, String sex, int age){
        return new Member(name, sex, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
