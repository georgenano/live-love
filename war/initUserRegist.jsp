<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ユーザ情報初期登録 - ライブラブ 〜Live Love〜</title>
</head>
<body>
	<p>ユーザ情報初期登録 - ライブラブ 〜Live Love〜</p>
	${f:h(e.userAccount)}
	${f:h(e.continue)}
	<a href="${f:url('/registInitUserAccount')}">ユーザ情報初期登録</a>
</body>
</html>
