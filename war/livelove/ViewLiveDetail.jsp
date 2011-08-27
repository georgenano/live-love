<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/layout/layout.jsp">
	<c:param name="title" value="[ライブラブ〜Live Love〜] ライブ情報詳細" />
	<c:param name="content">
		<table>
			<tr>
				<th>ライブ名</th>
				<td>${f:h(live.liveName)}</td>
			</tr>
			<tr>
				<th>出演アーティスト</th>
				<td>${f:h(live.artists)}</td>
			</tr>
			<tr>
				<th>地域</th>
				<td>${f:h(live.pref)}</td>
			</tr>
			<tr>
				<th>会場</th>
				<td>${f:h(live.livePlace)}</td>
			</tr>
			<tr>
				<th>開場時間</th>
				<td>${f:h(live.liveOpenDate)}</td>
			</tr>
			<tr>
				<th>開演時間</th>
				<td>${f:h(live.liveStartDate)}</td>
			</tr>
			<tr>
				<th>終演時間</th>
				<td>${f:h(live.liveEndDate)}</td>
			</tr>
			<tr>
				<th>前売り料金</th>
				<td>${f:h(live.advanceCharge)}</td>
			</tr>
			<tr>
				<th>当日料金</th>
				<td>${f:h(live.todayCharge)}</td>
			</tr>
			<tr>
				<th>説明</th>
				<td>${f:h(live.note)}</td>
			</tr>
			<tr>
				<th>登録者</th>
				<td>${f:h(live.registUserAccountRef.model.nickname)}</td>
			</tr>
		</table>
		<c:if test="${f:h(isEditableUser)}">
			<a href="${f:url('deleteLive?key=')}${f:h(live.key)}">ライブ情報削除</a>
		</c:if>
	</c:param>
</c:import>
