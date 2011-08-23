package com.appspot.livelove.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.appspot.livelove.meta.LiveMeta;
import com.appspot.livelove.model.Live;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class LiveReportService {

    private LiveMeta lr = new LiveMeta();
    private static final String DATE_PATTERN = "yyyy.MM.dd HH:mm";
    private static SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);

    public Live registLive(Map<String, Object> input) {
        Live live = new Live();
        BeanUtil.copy(input, live);

        // 開場、開演、終演時刻を設定
        String year = (String) input.get("start_year");
        String month = (String) input.get("start_year");
        String day = (String) input.get("start_day");
        String openHour = (String) input.get("open_hour");
        String openTime = (String) input.get("open_time");
        String startHour = (String) input.get("start_hour");
        String startTime = (String) input.get("start_time");
        String endHour = (String) input.get("end_hour");
        String endTime = (String) input.get("end_time");
        String openDate =
            year + "." + month + "." + day + " " + openHour + ":" + openTime;
        Date liveOpenDate = string2date(openDate);
        live.setLiveOpenDate(liveOpenDate);
        String startDate =
            year + "." + month + "." + day + " " + startHour + ":" + startTime;
        Date liveStartDate = string2date(startDate);
        live.setLiveStartDate(liveStartDate);
        String endDate =
            year + "." + month + "." + day + " " + endHour + ":" + endTime;
        Date liveEndDate = string2date(endDate);
        live.setLiveEndDate(liveEndDate);

        // 登録日、登録ユーザ、最終更新日、最終更新ユーザ、削除フラグを設定
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        String userId = user.getUserId();
        live.setRegistDate(new Date());
        live.setRegistUser(userId);
        live.setLastUpdateDate(new Date());
        live.setLastUpdateUser(userId);
        live.setDeleted(false);

        Transaction tx = Datastore.beginTransaction();
        Datastore.put(live);
        tx.commit();
        return live;
    }

    public List<Live> getLiveList() {
        return Datastore.query(lr).sort(lr.lastUpdateDate.desc).asList();
    }

    private static Date string2date(String value) {
        try {
            return sdf.parse(value);
        } catch (ParseException e) {
            return null;
        }
    }

}
