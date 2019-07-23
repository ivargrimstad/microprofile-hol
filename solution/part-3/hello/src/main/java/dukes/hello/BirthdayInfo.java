package dukes.hello;

public class BirthdayInfo {

    private String name;
    private long daysToBirthday;
    private long daysSinceBirthday;
    private long age;

    public BirthdayInfo() {
    }

    public BirthdayInfo(String name, long daysToBirthday, long daysSinceBirthday, long age) {
        this.name = name;
        this.daysToBirthday = daysToBirthday;
        this.daysSinceBirthday = daysSinceBirthday;
        this.age = age;

    }

    public long getDaysToBirthday() {
        return daysToBirthday;
    }

    public long getDaysSinceBirthday() {
        return daysSinceBirthday;
    }

    public long getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "BirthdayInfo{" +
                "name='" + name + '\'' +
                ", daysToBirthday=" + daysToBirthday +
                ", daysSinceBirthday=" + daysSinceBirthday +
                ", age=" + age +
                '}';
    }
}
