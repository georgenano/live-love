package com.appspot.livelove.controller.livelove;

import java.util.Calendar;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class ViewRegistLiveController extends Controller {

    @Override
    public Navigation run() throws Exception {
        Calendar cal = Calendar.getInstance();
        int thisYear = cal.get(Calendar.YEAR);
        int thisMonth = cal.get(Calendar.MONTH) + 1;
        int thisDay = cal.get(Calendar.DATE);
        int dayMaximum = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        requestScope("thisYear", thisYear);
        requestScope("thisMonth", thisMonth);
        requestScope("thisDay", thisDay);
        requestScope("dayMaximum", dayMaximum);

        return forward("viewRegistLive.jsp");
    }
}
