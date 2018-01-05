package kata.banking.service;

import java.time.ZonedDateTime;

public class TimeProvider {

    public ZonedDateTime getCurrentTime() {
        return ZonedDateTime.now();
    }

}
