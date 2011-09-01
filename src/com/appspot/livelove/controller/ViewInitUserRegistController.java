package com.appspot.livelove.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class ViewInitUserRegistController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("viewInitUserRegist.jsp");
    }
}
