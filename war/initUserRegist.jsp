<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<c:import url="/layout/layout.jsp">
  <c:param name="title" value="[ライブラブ〜Live Love〜] ユーザ情報初期登録"/>
  <c:param name="content">
	${f:h(e.userAccount)}
	${f:h(e.continue)}
	<a href="${f:url('/registInitUserAccount')}">ユーザ情報初期登録</a>
  </c:param>
</c:import>