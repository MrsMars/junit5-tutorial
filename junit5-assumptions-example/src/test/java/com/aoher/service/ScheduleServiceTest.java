package com.aoher.service;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.Locale;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@RunWith(JUnitPlatform.class)
class ScheduleServiceTest {

    @Test
    void doScheduleSingleTimeZone() {
        TimeZone tZone = TimeZone.getDefault();
        assumeTrue(tZone.getDisplayName().equals("US/Mountain"));

        ScheduleService scheduleService = new ScheduleService();
        assertTrue(scheduleService.doSchedule());
    }

    @Test
    void doScheduleLocaleNonUS() {
        Locale currentLocale = Locale.getDefault();
        assumeTrue(currentLocale.equals(Locale.US));

        ScheduleService scheduleService = new ScheduleService();
        assertTrue(scheduleService.doSchedule());

    }

    @Test
    void backupCalendarWindows() {
        assumeTrue(System.getProperty("os.name").startsWith("Windows"));

        ScheduleService scheduleService = new ScheduleService();
        assertTrue(scheduleService.backupCalendar());
    }
}