package com.example.chargersystem.application.command;

public class CommandUtil {

    static <T> void throwIfNull(T target, String errorMessage) {
       if (target == null)
           throw new IllegalArgumentException(errorMessage);
    }

    static void throwIfNullOrBlank(String target, String errorMessage) {
        if (target == null || target.isBlank())
            throw new IllegalArgumentException(errorMessage);
    }
}
