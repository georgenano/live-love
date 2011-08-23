package com.appspot.livelove.controller.livelove;

import org.slim3.datastore.Datastore;
import org.slim3.tester.ControllerTestCase;
import org.junit.Test;

import com.appspot.livelove.model.Live;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class RegistLiveReportControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.param("content", "hello");
        tester.start("/livelove/registLiveReport");
        RegistLiveReportController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(true));
        assertThat(tester.getDestinationPath(), is("/livelove/"));
        Live stored = Datastore.query(Live.class).asSingle();
        assertThat(stored, is(notNullValue()));
        assertThat(stored.getNote(), is("hello"));
    }
}
