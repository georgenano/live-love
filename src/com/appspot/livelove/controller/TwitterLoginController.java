package com.appspot.livelove.controller;

import org.apache.commons.lang3.StringUtils;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

public class TwitterLoginController extends Controller {

    private static final String CONSUMER_KEY = "wCWvMWfsgZ5o9WjZm0xIYg";
    private static final String CONSUMER_SECRET = "dg9BQhKUsFR35aVtnIHS9PVHeOJMgfPdJSYDDL23eQ";

    @Override
    public Navigation run() throws Exception {
        String _continue = asString("continue");
        if (StringUtils.isBlank(_continue)) {
            _continue = "/";
        }

        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);

        RequestToken requestToken =
            twitter.getOAuthRequestToken(getCallbackUrl(_continue));
        sessionScope("requestToken", requestToken);

        return redirect(requestToken.getAuthorizationURL());
    }

    private String getCallbackUrl(String _continue) {
        StringBuffer url = request.getRequestURL();
        url.delete(url.lastIndexOf(basePath), url.length());
        url.append("/twitterVerify?continue=").append(_continue);
        return url.toString();
    }
}
