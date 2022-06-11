package com.techelevator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date {
    private String formattedDate;


    public Date(String formattedDate) {
        this.formattedDate = formattedDate;
    }

    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
        formattedDate = LocalDateTime.now().format(formatter);
        return formattedDate;
    }
}



