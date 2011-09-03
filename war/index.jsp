<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<c:import url="/layout/indexLayout.jsp">
  <c:param name="title" value="ライブラブ〜Live Love〜"/>
  <c:param name="content">
  	<div id="intro">
	  	<h1>あなたのライブ参戦予定を共有しよう！</h1>
  		<h2>音楽の好みが似ている人のライブ予定を覗いてみませんか？</h2>
  	</div>
  	<div id="login">
 	 	<p>Live Loveは、面倒な登録作業をしなくても、<br />mixi、Google、Twitterのアカウントがあれば、<br />すぐにご利用頂けます。</p>
 	 	<ul>
 	 		<li><a href="/openIdLogin?openid_identifier=https://mixi.jp/&continue=/livelove/">mixiでログイン</a></li>
			<li><a href="/openIdLogin?openid_identifier=https://www.google.com/accounts/o8/id&continue=/livelove/">Googleでログイン</a></li>
			<li><a href="/twitterLogin?continue=/livelove/">Twitterでログイン</a></li>
 	 	</ul>
	</div>


  </c:param>
</c:import>