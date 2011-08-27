package com.appspot.livelove.controller.livelove;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.livelove.model.Live;
import com.appspot.livelove.service.LiveService;

public class IndexController extends Controller {

    private LiveService service = new LiveService();

    @Override
    public Navigation run() throws Exception {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        if (request.getAttribute("year") != null
            && request.getAttribute("month") != null) {
            year = asInteger("year");
            month = asInteger("month");
        }
        Map<String, List<Live>> dailyLiveMap =
            service.getDailyLiveMap(year, month - 1);
        requestScope("dailyLiveMap", dailyLiveMap);
        setCalInfo(year, month);
        return forward("index.jsp");
    }

    private void setCalInfo(int thisYear, int thisMonth) {
        Calendar cal = Calendar.getInstance();
        // ¡Œ•ª‚Ìî•ñ‚ğİ’è
        cal.set(Calendar.YEAR, thisYear);
        cal.set(Calendar.MONTH, thisMonth - 1);
        int dayMaximum = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int firstDay = cal.get(Calendar.DAY_OF_WEEK);
        requestScope("thisYear", thisYear);
        requestScope("thisMonth", thisMonth);
        requestScope("dayMaximum", dayMaximum);
        requestScope("firstDay", firstDay);

        // æŒ•ª‚Ìî•ñ‚ğİ’è
        cal.add(Calendar.MONTH, -1);
        int prevYear = cal.get(Calendar.YEAR);
        int prevMonth = cal.get(Calendar.MONTH) + 1;
        requestScope("prevYear", prevYear);
        requestScope("prevMonth", prevMonth);
        // —ˆŒ•ª‚Ìî•ñ‚ğİ’è
        cal.add(Calendar.MONTH, 2);
        int nextYear = cal.get(Calendar.YEAR);
        int nextMonth = cal.get(Calendar.MONTH) + 1;
        requestScope("nextYear", nextYear);
        requestScope("nextMonth", nextMonth);
    }
}
