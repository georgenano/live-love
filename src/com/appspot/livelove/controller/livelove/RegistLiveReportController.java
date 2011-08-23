package com.appspot.livelove.controller.livelove;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.appspot.livelove.service.LiveReportService;

public class RegistLiveReportController extends Controller {

    private LiveReportService service = new LiveReportService();

    @Override
    public Navigation run() throws Exception {
       service.registLive(new RequestMap(request));
        return redirect(basePath);
    }
}
