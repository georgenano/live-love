<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ライブラブ 〜Live Love〜 Index</title>
</head>
<body>
	<p>
		<a href="/logout">ログアウト</a>
	</p>
	<a href="${f:url('viewRegistLive')}">ライブ情報登録</a>

	<table>
		<tr>
			<th>Mon</th>
			<th>Tue</th>
			<th>Wed</th>
			<th>Thu</th>
			<th>Fri</th>
			<th>Sat</th>
			<th>Sun</th>
		</tr>
		<c:set var="fstDay" value="${firstDay-2}" />
		<c:set var="dayMax" value="${dayMaximum}" />
		<c:forEach begin="0" end="6" var="j">
			<tr>
				<c:forEach begin="1" end="7" var="i">
					<td class="day"><c:set var="day" value="${7*j+i}" /> <c:if
							test="${fstDay < day && day <= dayMax+fstDay}">
							<c:out value="${day-fstDay}" />
						</c:if>
					</td>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach begin="1" end="7" var="i">
					<td class="event"><c:set var="day" value="${7*j+i}" /> <c:if
							test="${fstDay < day && day <= dayMax+fstDay}">
							<c:set var="targetDay" value="${day-fstDay}" />
							<fmt:formatNumber value="${targetDay}" pattern="#" var="key" />
							<c:forEach var="live" items="${dailyLiveMap[key]}">
								<a href="viewLiveDetail?key=${f:h(live.key)}">${f:h(live.liveName)}</a><br />
							</c:forEach>
						</c:if>
					</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
