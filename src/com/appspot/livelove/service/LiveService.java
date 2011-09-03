package com.appspot.livelove.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.appspot.livelove.meta.LiveMeta;
import com.appspot.livelove.model.Live;
import com.appspot.livelove.model.UserAccount;
import com.google.appengine.api.datastore.Key;

public class LiveService {

    private LiveMeta lm = new LiveMeta();

    public Live registLive(Map<String, Object> input, UserAccount ua) {
        Live live = new Live();
        BeanUtil.copy(input, live);

        // アーティストリストを設定
        String artistsStr = (String) input.get("artistList");
        String[] artists = artistsStr.split(",");
        List<String> artistList = new ArrayList<String>();
        for (String artist : artists) {
            artistList.add(artist);
        }
        live.setArtists(artistList);

        // 開場、開演、終演時刻を設定
        String year = (String) input.get("start_year");
        String month = (String) input.get("start_month");
        String day = (String) input.get("start_day");
        String openHour = (String) input.get("open_hour");
        String openTime = (String) input.get("open_time");
        String startHour = (String) input.get("start_hour");
        String startTime = (String) input.get("start_time");
        String endHour = (String) input.get("end_hour");
        String endTime = (String) input.get("end_time");
        String openDate =
            year + "." + month + "." + day + " " + openHour + ":" + openTime;
        Date liveOpenDate = CommonUtilService.string2date(openDate);
        live.setLiveOpenDate(liveOpenDate);
        String startDate =
            year + "." + month + "." + day + " " + startHour + ":" + startTime;
        Date liveStartDate = CommonUtilService.string2date(startDate);
        live.setLiveStartDate(liveStartDate);
        String endDate =
            year + "." + month + "." + day + " " + endHour + ":" + endTime;
        Date liveEndDate = CommonUtilService.string2date(endDate);
        live.setLiveEndDate(liveEndDate);

        // 登録日、登録ユーザ、最終更新日、最終更新ユーザ、削除フラグを設定
        live.setRegistDate(new Date());
        live.getRegistUserAccountRef().setModel(ua);
        live.setLastUpdateDate(new Date());
        live.getLastUpdateUserAccountRef().setModel(ua);
        live.setDeleted(false);

        Datastore.put(ua, live);
        return live;
    }

    public Live updateLive(Key key, Map<String, Object> input, UserAccount ua) {
        // 更新後Live情報を編集
        Live live = Datastore.get(lm, key);
        BeanUtil.copy(input, live);

        // アーティストリストを設定
        String artistsStr = (String) input.get("artistList");
        String[] artists = artistsStr.split(",");
        List<String> artistList = new ArrayList<String>();
        for (String artist : artists) {
            artistList.add(artist);
        }
        live.setArtists(artistList);

        // 開場、開演、終演時刻を設定
        String year = (String) input.get("start_year");
        String month = (String) input.get("start_month");
        String day = (String) input.get("start_day");
        String openHour = (String) input.get("open_hour");
        String openTime = (String) input.get("open_time");
        String startHour = (String) input.get("start_hour");
        String startTime = (String) input.get("start_time");
        String endHour = (String) input.get("end_hour");
        String endTime = (String) input.get("end_time");
        String openDate =
            year + "." + month + "." + day + " " + openHour + ":" + openTime;
        Date liveOpenDate = CommonUtilService.string2date(openDate);
        live.setLiveOpenDate(liveOpenDate);
        String startDate =
            year + "." + month + "." + day + " " + startHour + ":" + startTime;
        Date liveStartDate = CommonUtilService.string2date(startDate);
        live.setLiveStartDate(liveStartDate);
        String endDate =
            year + "." + month + "." + day + " " + endHour + ":" + endTime;
        Date liveEndDate = CommonUtilService.string2date(endDate);
        live.setLiveEndDate(liveEndDate);

        // 最終更新日、最終更新ユーザ、削除フラグを設定
        live.setLastUpdateDate(new Date());
        live.getLastUpdateUserAccountRef().setModel(ua);
        live.setDeleted(false);

        Datastore.put(live);
        return live;
    }

    public List<Live> getLiveList() {
        return Datastore.query(lm).sort(lm.lastUpdateDate.desc).asList();
    }

    public Map<String, List<Live>> getDailyLiveMap(int year, int month) {
        Map<String, List<Live>> dailyLiveMap =
            new HashMap<String, List<Live>>();
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 0, 0, 0, 0);
        for (int i = 0; i < cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            Date startDate = cal.getTime();
            cal.add(Calendar.DATE, 1);
            Date endDate = cal.getTime();
            dailyLiveMap.put(
                Integer.toString(i),
                Datastore
                    .query(lm)
                    .filter(
                        lm.liveStartDate.greaterThanOrEqual(startDate),
                        lm.liveStartDate.lessThan(endDate),
                        lm.deleted.equal(false))
                    .asList());
        }
        return dailyLiveMap;
    }

    public Live getLiveDetail(Key key) {
        return Datastore.get(lm, key);
    }

    public boolean deleteLive(Key key, UserAccount ua) {
        if (isEditableUser(key, ua)) {
            Live target = Datastore.get(lm, key);
            target.setLastUpdateDate(new Date());
            target.getLastUpdateUserAccountRef().setModel(ua);
            target.setDeleted(true);
            Datastore.put(target);
            return true;
        } else {
            return false;
        }
    }

    public boolean isEditableUser(Key key, UserAccount ua) {
        Live target = Datastore.get(lm, key);
        if (target.getRegistUserAccountRef().getModel().equals(ua)) {
            return true;
        } else {
            return false;
        }
    }


    public boolean inputCheck(Map<String, Object> input) {
        String liveName = (String) input.get("liveName");
        String artistList = (String) input.get("artistList");
        String pref = (String) input.get("pref");
        String year = (String) input.get("start_year");
        String month = (String) input.get("start_month");
        String day = (String) input.get("start_day");
        String startHour = (String) input.get("start_hour");
        String startTime = (String) input.get("start_time");
        if (liveName != ""
            && artistList != ""
            && pref != ""
            && year != ""
            && month != ""
            && day != ""
            && startHour != ""
            && startTime != "") {
            return true;
        }
        return false;
    }

}
