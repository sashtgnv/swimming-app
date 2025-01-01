package com.example.swimming_championships_app.util;

// вспомогательный класс времени
public class Time {
    private int all;
    private int milisec;
    private int sec;
    private int min;

    public Time(int all) {
        try {
            this.all = all;
            milisec = all % 1000;
            sec = (all / 1000) % 60;
            all = all / 1000;
            min = all / 60;
            if (min > 59) throw new Exception();
        } catch (Exception e) {
            System.err.println("err");
        }
    }

    public Time(String time) {
        String[] s = time.split(":");
        min = Integer.parseInt(s[0]);
        if (min > 59) throw new RuntimeException();
        String[] s1 = s[1].split("\\.");
        sec = Integer.parseInt(s1[0]);
        if (sec > 59) throw new RuntimeException();
        milisec = Integer.parseInt(s1[1]);
        if (milisec > 999) throw new RuntimeException();
        this.all = min * 60 * 1000 + sec * 1000 + milisec;
    }

    // возвращает количиство миллисекунд объекта класса
    public int getAll() {
        return all;
    }

    @Override
    public String toString() {
        String m = (String.valueOf(min).length() == 1) ? "0" + min : String.valueOf(min);
        String s = (String.valueOf(sec).length() == 1) ? "0" + sec : String.valueOf(sec);
        String ms = (String.valueOf(milisec).length() == 1) ? "0" + milisec : String.valueOf(milisec);
        return m + ':' + s + '.' + ms;
    }
}
