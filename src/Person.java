public class Person {
    private String name;
    private String job;
    private String sex;
    private int age;
    private int money;

    private Person(String name, String job, String sex, int age, int money){
        this.name = name;
        this.job = job;
        this.sex = sex;
        this.age = age;
        this.money = money;
    }

    public static Person getPerson(String name, String job, String sex, int age, int money){
        return new Person(name, job, sex, age, money);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    private void setJob(String job) {
        this.job = job;
    }

    public String getSex() {
        return sex;
    }

    private void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public int getMoney() {
        return money;
    }

    private void setMoney(int money) {
        this.money = money;
    }
}
