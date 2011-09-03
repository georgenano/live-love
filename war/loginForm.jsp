<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<c:import url="/layout/layout.jsp">
  <c:param name="title" value="ログイン"/>
  <c:param name="content">
  	<ul>
		<li><a href="/openIdLogin?openid_identifier=https://mixi.jp/&continue=${continue}">Mixiでログイン</a></li>
		<li><a href="/openIdLogin?openid_identifier=https://www.google.com/accounts/o8/id&continue=${continue}">Googleでログイン</a></li>
		<li><a href="/twitterLogin?continue=${continue}">Twitterでログイン</a></li>
  	</ul>
  </c:param>
</c:import>