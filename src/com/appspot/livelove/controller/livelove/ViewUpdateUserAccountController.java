package com.appspot.livelove.controller.livelove;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class ViewUpdateUserAccountController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("viewUpdateUserAccount.jsp");
    }
}
