package com.matheus.gerenciadorDeAlunos.backend.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component

public class DateUtil {
    public LocalTime getTimeNow(LocalTime localTime){
        return localTime.now();
    }

    public LocalDate getDateNow(LocalDate localDate){
        return localDate.now();
    }
}