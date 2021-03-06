package by.epam.sedkov.day1.service;

import by.epam.sedkov.day1.entity.MonthEnum;
import by.epam.sedkov.day1.entity.PastTime;
import by.epam.sedkov.day1.exception.CheckedException;
import by.epam.sedkov.day1.validator.CalendarValidator;

public class CalendarService {

    public int receiveDaysInMonth(int month) {
        return (MonthEnum.values()[month - 1].getDays());
    }

    public int receiveConcreteDays(int year, int month) throws CheckedException {
        if (CalendarValidator.isMonth(month)) {
            int days = receiveDaysInMonth(month);
            if (CalendarValidator.isLeapYear(year) && MonthEnum.values()[month - 1] == MonthEnum.FEBRUARY) {
                days++;
            }
            return days;
        } else {
            throw new CheckedException("Wrong month: needed from 1 to 12");
        }
    }

    private int receiveHours(int seconds) {
        return seconds / CalendarValidator.SECONDS_IN_HOUR;
    }

    private int receiveMinutes(int seconds) {
        return (seconds % CalendarValidator.SECONDS_IN_HOUR / CalendarValidator.SECONDS_IN_MINUTE);
    }

    private int receiveSeconds(int seconds) {
        return (seconds % CalendarValidator.SECONDS_IN_HOUR % CalendarValidator.SECONDS_IN_MINUTE);
    }

    public PastTime receiveTime(int seconds) throws CheckedException {
        if (CalendarValidator.isSecondsInCurrentDay(seconds)) {
            PastTime pastTime = new PastTime();
            pastTime.setPastHours(receiveHours(seconds));
            pastTime.setPastMinutes(receiveMinutes(seconds));
            pastTime.setPastSeconds(receiveSeconds(seconds));
            return pastTime;
        } else {
            throw new CheckedException("Wrong data: must be during one day, seconds from 0 before " + CalendarValidator.SECONDS_IN_DAY);
        }
    }

}
