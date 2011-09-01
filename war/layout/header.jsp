<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<div id="header" class="clearfix">
	<a href="${f:url('/livelove/')}"><img src="/img/logo.png" alt="" />
	</a>
	<ul>
		<li><a href="${f:url('/livelove/')}">ホーム</a>
		</li>
		<li><a href="${f:url('/livelove/viewRegistLive')}">ライブ新規登録</a>
		</li>
		<li><a href="${f:url('/logout')}">ログアウト</a>
		</li>
	</ul>
</div>