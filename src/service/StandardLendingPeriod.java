package service;

import java.util.Calendar;
import java.util.Date;

public class StandardLendingPeriod implements LendingPeriodStrategy {
    private final int days;
    
    public StandardLendingPeriod(int days) {
        this.days = days;
    }
    
    @Override
    public Date calculateDueDate(Date borrowDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(borrowDate);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }
}