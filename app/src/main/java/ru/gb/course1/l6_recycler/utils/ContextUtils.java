package ru.gb.course1.l6_recycler.utils;

import android.content.Context;

import ru.gb.course1.l6_recycler.App;

public class ContextUtils {
    public static App getApp(Context context) {
        return (App) context.getApplicationContext();
    }
}
