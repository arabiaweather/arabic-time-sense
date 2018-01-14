/* Copyright (c) 2018 ArabiaWeather Inc. All rights reserved

        Permission is hereby granted, free of charge, to any person obtaining a copy
        of this software and associated documentation files (the "Software"), to deal
        in the Software without restriction, including without limitation the rights
        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
        copies of the Software, and to permit persons to whom the Software is
        furnished to do so, subject to the following conditions:

        The above copyright notice and this permission notice shall be included in all
        copies or substantial portions of the Software.

        THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
        IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
        FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
        AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
        LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
        OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
        SOFTWARE.
*/

package com.arabiaweather.awtimesense;


import android.content.Context;

import java.util.Calendar;
import java.util.Locale;

public class AWTimeSense {

    public static final long SECOND = 1000L;
    public static final long MINUTE = 60 * SECOND;
    public static final long HOUR = 60 * MINUTE;
    public static final long DAY = 24 * HOUR;

    /**
     * This method will take one long parameter, the time to be converted.
     * If the date is past two days, a formatted date is returned, the format is YYYY/MM/DD.
     * Will return an empty string if the time parameter is wrong.
     *
     * @param context   Context of the calling app, needed for localization.
     * @param time      The time (long) to be converted to string
     * @param separator Separator to be used between fields in the formatted date
     */
    public static String getTimeAgo(Context context, long time, String separator) {

        Calendar calendar = Calendar.getInstance();

        long currentTime = calendar.getTimeInMillis();

        if (time <= 0 || currentTime <= 0) {
            return "";
        }

        if (time > currentTime) {
            return "";
        }

        final long difference = currentTime - time;

        if (difference < MINUTE) {

            return context.getString(R.string.momentsAgo);

        } else if (difference < (2 * MINUTE)) {

            return context.getString(R.string.oneMinuteAgo);

        } else if (difference < (3 * MINUTE)) {

            return context.getString(R.string.twoMinutesAgo);

        } else if (difference < (11 * MINUTE)) {

            return context.getString(R.string.since) + " "
                    + difference / MINUTE + " "
                    + context.getString(R.string.minutes);

        } else if (difference < HOUR) {

            return Locale.getDefault().getLanguage().equalsIgnoreCase("ar")
                    ? (context.getString(R.string.since) + " "
                    + difference / MINUTE + " "
                    + context.getString(R.string.minute))
                    : (context.getString(R.string.since)
                    + " " + difference / MINUTE + " "
                    + context.getString(R.string.minutes));

        } else if (difference < (2 * HOUR)) {

            return context.getString(R.string.hourAgo);

        } else if (difference < (3 * HOUR)) {

            return context.getString(R.string.twoHoursAgo);

        } else if (difference < (11 * HOUR)) {

            return context.getString(R.string.since) + " "
                    + difference / HOUR + " "
                    + context.getString(R.string.hours);

        } else if (difference < DAY) {

            return Locale.getDefault().getLanguage().equalsIgnoreCase("ar")
                    ? (context.getString(R.string.since) + " "
                    + difference / HOUR + " "
                    + context.getString(R.string.hour))
                    : context.getString(R.string.since) + " "
                    + difference / HOUR + " "
                    + context.getString(R.string.hours);

        } else if (difference < (2 * DAY)) {

            return context.getString(R.string.dayAgo);

        } else if (difference < (3 * DAY)) {

            return context.getString(R.string.twoDaysAgo);

        } else {

            calendar.setTimeInMillis(time);

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            return year
                    + separator
                    + (month + 1)
                    + separator
                    + day;
        }

    }
}
