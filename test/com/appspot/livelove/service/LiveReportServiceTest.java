package com.appspot.livelove.service;

import java.util.HashMap;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;

import com.appspot.livelove.model.Live;
import com.appspot.livelove.model.UserAccount;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class LiveReportServiceTest extends AppEngineTestCase {

    private LiveService service = new LiveService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }

    @Test
    public void registLiveReport() throws Exception {
        Map<String, Object> input = new HashMap<String, Object>();
        input.put("content", "hello");
        UserAccount ua = new UserAccount();
        ua.setUserId("hoge");
        Live report = service.registLive(input, ua);
        assertThat(report, is(notNullValue()));
        Live stored = Datastore.get(Live.class, report.getKey());
        assertThat(stored.getNote(), is("hello"));
    }
}
