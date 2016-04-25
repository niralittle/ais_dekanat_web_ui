package com.kma.ais_dekanat.utils;

import com.kma.ais_dekanat.model.FinalTest;
import org.joda.time.DateTime;

import java.util.*;

/**
 * Created by nira on 24.04.16.
 */
public class ExamScheduleUtil {

    public static Map<Integer, List<FinalTest>[]> prepare(List<FinalTest> examsList) {
        Collections.sort(examsList, new Comparator<FinalTest>() {
            @Override
            public int compare(FinalTest o1, FinalTest o2) {
                return o1.getTime().compareTo(o2.getTime());
            }
        });

        final int weekLength = 7;

        Map<Integer, List<FinalTest>[]> weeks = new HashMap<Integer, List<FinalTest>[]>();
        for (FinalTest exam: examsList) {
            DateTime dateTime = new DateTime(exam.getTime().getTime());
            int weekNumber = dateTime.getWeekOfWeekyear();
            int weekdayNumber = dateTime.getDayOfWeek() - 1; //to work with array
            List<FinalTest>[] week = weeks.get(weekNumber);
            if (week == null) {
                week = new ArrayList[weekLength];
                weeks.put(weekNumber, week);
                for (int i = 0; i < weekLength; i++) {
                    week[i] = new ArrayList<FinalTest>();
                }
            }
            List<FinalTest> weekday = week[weekdayNumber];
            weekday.add(exam);
        }
        for (List<FinalTest>[] week: weeks.values()) {
            for (int i = 0; i < weekLength; i++) {
                Collections.sort(week[i], new Comparator<FinalTest>() {
                    @Override
                    public int compare(FinalTest o1, FinalTest o2) {
                        return o1.getTime().compareTo(o2.getTime());
                    }
                });
            }
        }
        return weeks;
    }
}
