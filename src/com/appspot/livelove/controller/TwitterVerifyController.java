package com.appspot.livelove.controller;

import org.apache.commons.lang3.StringUtils;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TwitterVerifyController extends Controller {

    private static final String CONSUMER_KEY = "wCWvMWfsgZ5o9WjZm0xIYg";
    private static final String CONSUMER_SECRET =
        "dg9BQhKUsFR35aVtnIHS9PVHeOJMgfPdJSYDDL23eQ";

    @Override
    public Navigation run() throws Exception {
        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);

        String _continue = asString("continue");
        if (StringUtils.isBlank(_continue)) {
            _continue = "/";
        }

        RequestToken requestToken = removeSessionScope("requestToken");
        String verifier = asString("oauth_verifier");

        AccessToken accessToken = null;
        try {
            accessToken = twitter.getOAuthAccessToken(requestToken, verifier);
            sessionScope("accessToken", accessToken);
        } catch (TwitterException e) {
            System.out.println(e);
            // Ç∑ÇÈÅ[
        }
        return redirect("/login?type=twitter&continue=" + _continue);
    }
}
