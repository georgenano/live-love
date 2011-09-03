<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<div id="menu" class="clearfix">
	<ul>
		<li><a href="${f:url('/livelove/')}">ライブカレンダー</a></li>
		<li><a href="${f:url('/livelove/viewRegistLive')}">ライブ新規登録</a></li>
		<li><a href="${f:url('/livelove/viewUpdateUserAccount')}">プロフィール変更</a>
		</li>
	</ul>
</div>