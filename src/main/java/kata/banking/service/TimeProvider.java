package kata.banking.service;

import java.time.LocalDate;

public class TimeProvider {

    public LocalDate getCurrentTime() {
        return LocalDate.now();
    }

}
