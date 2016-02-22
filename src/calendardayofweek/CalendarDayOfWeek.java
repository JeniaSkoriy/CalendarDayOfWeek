/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendardayofweek;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author ImmolateImprove
 */
public class CalendarDayOfWeek {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GregorianCalendar d = new GregorianCalendar();
        int today = d.get(Calendar.DAY_OF_MONTH);
        int month = d.get(Calendar.MONTH);
        d.set(Calendar.DAY_OF_MONTH, 1);
        int weekday = d.get(Calendar.DAY_OF_WEEK);
        int firstDayOfWeek = d.getFirstDayOfWeek();
        int index = 0;
        while (weekday != firstDayOfWeek) {
            index++;
            d.add(Calendar.DAY_OF_WEEK, -1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }
        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
        do {
            System.out.printf("%4s", weekdayNames[weekday]);
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        } while (weekday != firstDayOfWeek);
        System.out.println("");
        for (int i = 1; i <= index; i++) {
            System.out.println(" ");
        }
        d.set(Calendar.DAY_OF_MONTH, 1);
        do {
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d", day);
            if (day == today) {
                System.out.println("*");
            } else {
                System.out.println(" ");
            }
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
            if (weekday == firstDayOfWeek) {
                System.out.println("");
            }
        } while (d.get(Calendar.DAY_OF_WEEK) == month);
        if (weekday != firstDayOfWeek) {
            System.out.println();
        }
    }
    
}
