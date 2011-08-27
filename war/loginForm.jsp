<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<c:import url="/layout/layout.jsp">
  <c:param name="title" value="[ライブラブ〜Live Love〜] ログイン"/>
  <c:param name="content">
	<p><a href="/openIdLogin?openid_identifier=https://mixi.jp/&continue=${continue}">Mixiでログイン</a></p>
	<p><a href="/openIdLogin?openid_identifier=https://www.google.com/accounts/o8/id&continue=${continue}">Googleでログイン</a></p>
	<p><a href="/twitterLogin?continue=${continue}">Twitterでログイン</a></p>
  </c:param>
</c:import>