package com.example.providerapp.util;

public final class Extensions {
    private Extensions() {}

    public static boolean isNullOrBlank(String string) {
        return ((string == null) || string.isBlank());
    }

    public static boolean isNotNullOrBlank(String string) {
        return !isNullOrBlank(string);
    }
}
