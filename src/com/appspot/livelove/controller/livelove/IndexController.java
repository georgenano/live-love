package com.appspot.livelove.controller.livelove;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.livelove.model.Live;
import com.appspot.livelove.service.LiveReportService;

public class IndexController extends Controller {

    private LiveReportService service = new LiveReportService();

    @Override
    public Navigation run() throws Exception {
        List<Live> liveReportList = service.getLiveList();
        requestScope("liveReportList", liveReportList);
        return forward("index.jsp");
    }
}
