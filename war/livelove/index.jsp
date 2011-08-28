<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/layout/layout.jsp">
	<c:param name="title" value="[ライブラブ〜Live Love〜] Home" />
	<c:param name="content">
		<div id="calendar">
			<div id="calendar_title">
				<a href="/livelove/?year=${prevYear}&month=${prevMonth}">&lt;</a>
				${thisYear}年${thisMonth}月 <a
					href="/livelove/?year=${nextYear}&month=${nextMonth}">&gt;</a>
			</div>
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
				<c:choose>
					<c:when test="${firstDay<2}">
						<c:set var="fstDay" value="${firstDay+5}" />
					</c:when>
					<c:otherwise>
						<c:set var="fstDay" value="${firstDay-2}" />
					</c:otherwise>
				</c:choose>
				<c:set var="dayMax" value="${dayMaximum}" />
				<c:choose>
					<c:when test="${dayMax-28+fstDay==0}">
						<c:set var="weekMax" value="3" />
					</c:when>
					<c:when test="${dayMax-28+fstDay<=7}">
						<c:set var="weekMax" value="4" />
					</c:when>
					<c:otherwise>
						<c:set var="weekMax" value="5" />
					</c:otherwise>
				</c:choose>
				<c:forEach begin="0" end="${weekMax}" var="j">
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
									test="${fstDay < day && day < dayMax+fstDay}">
									<c:set var="targetDay" value="${day-fstDay}" />
									<fmt:formatNumber value="${targetDay}" pattern="#" var="key" />
									<ul class="clearfix">
										<c:forEach var="live" items="${dailyLiveMap[key]}">
											<li><a href="viewLiveDetail?key=${f:h(live.key)}">${f:h(live.liveName)}</a>
											</li>
										</c:forEach>
									</ul>
								</c:if>
							</td>
						</c:forEach>
					</tr>
				</c:forEach>
			</table>
		</div>
		<a href="${f:url('viewRegistLive')}">ライブ情報登録</a>
	</c:param>
</c:import>