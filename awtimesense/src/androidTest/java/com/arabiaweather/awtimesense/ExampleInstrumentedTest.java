package com.arabiaweather.awtimesense;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.arabiaweather.awtimesense.AWTimeSense;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;
import java.util.ConcurrentModificationException;
import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    final long sOneMinute = 60 * 1000;
    final long sTwoMinutes = sOneMinute * 2;
    final long sThreeMinutes = sOneMinute * 3;
    final long sFourMinutes = sOneMinute * 4;
    final long sFiveMinutes = sOneMinute * 5;

    final long sTenMinutes = sOneMinute * 10;
    final long sElevenMinutes = sOneMinute * 11;
    final long sTwelveMinutes = sOneMinute * 12;

    final long sFiftyNineMinutes = sOneMinute * 59;
    final long sSixtyMinutes = sOneMinute * 60;
    final long sSixtyOneMinutes = sOneMinute * 61;

    final long sOneHour = sOneMinute * 60;

    final long sTwoHours = sOneHour * 2;
    final long sThreeHours = sOneHour * 3;
    final long sFourHours = sOneHour * 4;

    final long sTenHours = sOneHour * 10;
    final long sElevenHours = sOneHour * 11;
    final long sTwelveHours = sOneHour * 12;

    final long sOneDay = sOneHour * 24;

    final long sOneDayThreeHours = sOneHour * 27;
    final long sOneDayThirteenHours = sOneHour * 37;

    final long sTwoDays = sOneDay * 2;

    final long sThreeDays = sOneDay * 3;

    final String ARABIC = "ar";
    final String ENGLISH = "en";
    
    private Context context;

    private void setLocale(String language, String country) {
        Locale locale = new Locale(language, country);
        // here we update locale for date formatters
        Locale.setDefault(locale);
        // here we update locale for app resources
        Resources res = context.getResources();
        Configuration config = res.getConfiguration();
        config.locale = locale;
        res.updateConfiguration(config, res.getDisplayMetrics());
    }

    @Before
    public void setup() {
        context = InstrumentationRegistry.getContext();
        setLocale(ARABIC, "JO");
    }

    @Test
    public void testNow() {
       // Locale.setDefault(new Locale("ar", "AR"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, System.currentTimeMillis(), "-"));
        assertEquals("منذ لحظات", AWTimeSense.getTimeAgo(context, System.currentTimeMillis(), "-"));

    }

    @Test
    public void testBefore() {
        assertEquals("منذ لحظات", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - 100, "-"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - 100, "-"));
    }

    @Test
    public void testBeforeOneMinute() {
        assertEquals("منذ دقيقة", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sOneMinute, "-"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - 60 * 1000, "-"));
    }

    @Test
    public void testBeforeThirtySeconds() {
        assertEquals("منذ لحظات", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - 3 * 10000, "-"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - 3 * 10000, "-"));
    }

    @Test
    public void testBeforeTwoMinutes() {
        assertEquals("منذ دقيقتين", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sTwoMinutes, "-"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sTwoMinutes, "-"));
    }

    @Test
    public void testBeforeThreeMinutes() {
        assertEquals("منذ 3 دقائق", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sThreeMinutes, "-"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sThreeMinutes, "-"));
    }

    @Test
    public void testBeforeFourMinutes() {
        assertEquals("منذ " + 4 + " دقائق", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sFourMinutes, "-"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sFourMinutes, "-"));
    }

    @Test
    public void testBeforeFiveMinutes() {
        assertEquals("منذ " + 5 + " دقائق", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sFiveMinutes, "-"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sFiveMinutes, "-"));
    }

    @Test
    public void testBeforeTenMinutes() {
        assertEquals("منذ " + 10 + " دقائق", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sTenMinutes, "-"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sTenMinutes, "-"));
    }

    @Test
    public void testBeforeElevenMinutes() {
        assertEquals("منذ 11 دقيقة", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sElevenMinutes, "-"));

        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sElevenMinutes, "-"));
    }

    @Test
    public void testBeforeTwelveMinutes() {
        assertEquals("منذ 12 دقيقة", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sTwelveMinutes, "-"));

        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sTwelveMinutes, "-"));
    }

    @Test
    public void testBeforeHourMinutes() {
        assertEquals("منذ ساعة", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sOneHour, "-"));

        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sOneHour, "-"));
    }

    @Test
    public void testBeforeTwoHoursMinutes() {
        assertEquals("منذ ساعتين", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sTwoHours, "-"));

        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sTwoHours, "-"));
    }

    @Test
    public void testBeforeThreeHoursMinutes() {
        assertEquals("منذ 3 ساعات", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sThreeHours, "-"));

        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sThreeHours, "-"));
    }

    @Test
    public void testBeforeFourHoursMinutes() {
        assertEquals("منذ 4 ساعات", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sFourHours, "-"));

        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sFourHours, "-"));
    }

    @Test
    public void testBeforeTenHoursMinutes() {
        assertEquals("منذ 10 ساعات", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sTenHours, "-"));

        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sTenHours, "-"));
    }

    @Test
    public void testBeforeElevenHoursMinutes() {
        assertEquals("منذ 11 ساعة", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sElevenHours, "-"));

        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sElevenHours, "-"));
    }

    @Test
    public void testBeforeTwelveHoursMinutes() {
        assertEquals("منذ 12 ساعة", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sTwelveHours, "-"));

        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sTwelveHours, "-"));
    }

    @Test
    public void testBeforeOneHour() {
        assertEquals("منذ ساعة", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sOneHour, "-"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sOneHour, "-"));
    }

    @Test
    public void testBeforeTwoHour() {
        assertEquals("منذ ساعتين", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sTwoHours, "-"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sTwoHours, "-"));
    }

    @Test
    public void testBeforeThreeHour() {
        assertEquals("منذ 3 ساعات", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sThreeHours, "-"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sThreeHours, "-"));
    }

    @Test
    public void testBeforeFourHour() {
        assertEquals("منذ 4 ساعات", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sFourHours, "-"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sFourHours, "-"));
    }

    @Test
    public void testBeforeTenHour() {
        assertEquals("منذ 10 ساعات", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sTenHours, "-"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sTenHours, "-"));
    }


    @Test
    public void testBeforeElevenHour() {
        assertEquals("منذ 11 ساعة", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sElevenHours, "-"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sElevenHours, "-"));
    }

    @Test
    public void testBeforeTwelveHour() {
        assertEquals("منذ 12 ساعة", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sTwelveHours, "-"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sTwelveHours, "-"));
    }

    @Test
    public void testBeforeoneDay() {
        assertEquals("منذ يوم", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sOneDay, "-"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sOneDay, "-"));
    }

    @Test
    public void testBeforeOneDayThreeHours() {
        assertEquals("منذ يوم", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sOneDay, "-"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sOneDayThreeHours, "-"));
    }

    @Test
    public void testBeforeOneDayThirteenHours() {
        assertEquals("منذ يوم", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sOneDayThirteenHours, "-"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sOneDayThirteenHours, "-"));
    }

    @Test
    public void testBeforeTwoDay() {
        assertEquals("منذ يومين", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sTwoDays, "-"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sTwoDays, "-"));
    }

    @Test
    public void testBeforeThreeDay() {
        assertEquals("2018-1-8", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sThreeDays, "-"));
        Log.d("TestResult: ", AWTimeSense.getTimeAgo(context, Calendar.getInstance().getTimeInMillis() - sThreeDays, "-"));
    }

}
