<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<c:import url="/layout/indexLayout.jsp">
  <c:param name="title" value="ライブラブ〜Live Love〜"/>
  <c:param name="content">
  	<p>ライブカレンダー共有サイトです！</p>
    <a href="${f:url('livelove/')}">ログイン</a>
  </c:param>
</c:import>