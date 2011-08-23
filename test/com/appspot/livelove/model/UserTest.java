package com.appspot.livelove.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class UserTest extends AppEngineTestCase {

    private UserAccount model = new UserAccount();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
