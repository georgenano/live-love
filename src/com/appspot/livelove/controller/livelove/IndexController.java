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
        Map<String, List<Live>> dailyLiveMap =
            service.getDailyLiveMap(2011, Calendar.AUGUST);
        requestScope("dailyLiveMap", dailyLiveMap);
        setCalInfo();
        return forward("index.jsp");
    }

    private void setCalInfo() {
        Calendar cal = Calendar.getInstance();
        int dayMaximum = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int firstDay = cal.get(Calendar.DAY_OF_WEEK);
        requestScope("dayMaximum", dayMaximum);
        requestScope("firstDay", firstDay);
    }
}
