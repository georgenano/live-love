package com.appspot.livelove.controller.livelove;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.appspot.livelove.model.UserAccount;
import com.appspot.livelove.service.LiveService;

public class RegistLiveController extends Controller {

    private LiveService service = new LiveService();

    @Override
    public Navigation run() throws Exception {
        if (inputCheck()) {
            HttpSession sess = request.getSession();
            UserAccount ua = (UserAccount) sess.getAttribute("userAccount");
            service.registLive(new RequestMap(request), ua);
            return redirect(basePath);
        }
        return forward("/error");
    }

    private boolean inputCheck() {
        String liveName = asString("liveName");
        String artistList = asString("artistList");
        String pref = asString("pref");
        String year = asString("start_year");
        String month = asString("start_month");
        String day = asString("start_day");
        String startHour = asString("start_hour");
        String startTime = asString("start_time");
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
