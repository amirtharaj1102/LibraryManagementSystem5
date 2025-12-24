package service;

import java.util.Date;

public interface LendingPeriodStrategy {
    Date calculateDueDate(Date borrowDate);
}