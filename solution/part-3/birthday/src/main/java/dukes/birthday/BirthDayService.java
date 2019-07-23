package dukes.birthday;

import javax.enterprise.context.RequestScoped;
import java.time.LocalDate;

import static java.time.LocalDate.now;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.YEARS;

@RequestScoped
public class BirthDayService {

    private final LocalDate now = now();

    public long calculateDaysToBirthday(LocalDate bd) {

        final LocalDate bdThisYear = bd.withYear(now.getYear());

        if (bdThisYear.isAfter(now)) {
            return now.until(bdThisYear, DAYS);
        } else {
            return now.until(bdThisYear.plusYears(1), DAYS);
        }
    }

    public long calculateDaysSinceBirthday(LocalDate bd) {

        final LocalDate bdThisYear = bd.withYear(now.getYear());

        if (bdThisYear.isBefore(now)) {
            return bdThisYear.until(now, DAYS);
        } else {
            return bdThisYear.minusYears(1).until(now, DAYS);
        }
    }

    public long age(LocalDate bd) {
        return bd.until(now, YEARS);
    }
}
