<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<div id="header" class="clearfix">
	<a class="logo" href="${f:url('/livelove/')}"><img
		src="/img/logo.png" alt="" /> </a> <a class="logout"
		href="${f:url('/logout')}">ログアウト</a>
	<c:import url="/layout/menu.jsp" />
	<div id="page_title">${param.title}</div>
</div>