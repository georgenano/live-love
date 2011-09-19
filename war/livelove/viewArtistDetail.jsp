<%@page import="java.util.Calendar"%>
<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/layout/layout.jsp">
	<c:param name="title" value="アーティスト情報詳細" />
	<c:param name="content">
		<div id="detail">
			<table summary="アーティスト情報">
				<tr>
					<th><label for="name">アーティスト名</label></th>
					<td>${f:h(artist.name)}</td>
				</tr>
				<tr>
					<th><label for="anotherNameList">別名、略称</label></th>
					<td><c:forEach var="another" items="${artist.anotherNameList}">
							 ${f:h(another)}
						</c:forEach></td>
				</tr>
				<tr>
					<th><label for="note">説明</label></th>
					<td>${f:h(artist.descritpion)}</td>
					<td></td>
				</tr>
			</table>
		</div>
		<div id="back_link">
			<a href="/livelove/">ライブカレンダーに戻る</a>
		</div>
	</c:param>
</c:import>
