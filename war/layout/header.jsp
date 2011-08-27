<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<div id="header" class="clearfix">
	<h1>${param.title}</h1>
	<ul>
		<li><a href="${f:url('/livelove/')}">Home</a></li>
		<li><a href="${f:url('/logout')}">ログアウト</a></li>
	</ul>
</div>