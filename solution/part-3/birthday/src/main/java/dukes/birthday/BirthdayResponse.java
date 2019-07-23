package dukes.birthday;

public class BirthdayResponse {

    private String name;
    private long daysToBirthday;
    private long daysSinceBirthday;
    private long age;

    public BirthdayResponse(String name, long daysToBirthday, long daysSinceBirthday, long age) {
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
}
