<%@page import="java.util.Calendar"%>
<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/layout/layout.jsp">
	<c:param name="title" value="アーティスト情報詳細" />
	<c:param name="content">
		<div id="page_title">アーティスト情報詳細</div>
		<div id="detail">
			<table summary="アーティスト情報">
				<tr>
					<th><label for="name">アーティスト名</label>
					</th>
					<td>${f:h(artist.name)}</td>
				</tr>
				<tr>
					<th><label for="anotherNames">別名、略称</label>
					</th>
					<td><c:forEach var="anotherName"
							items="${artist.anotherNames}">
							 ${f:h(anotherName)}
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th><label for="note">説明</label>
					</th>
					<td>${f:h(artist.description)}</td>
					<td></td>
				</tr>
				<tr>
					<th>更新</th>
					<td><a href="${f:url('viewUpdateArtist?key=')}${f:h(artist.key)}">このアーティスト情報を更新する</a>
					</td>
				</tr>
			</table>
		</div>
		<div id="back_link">
			<a href="/livelove/">ライブカレンダーに戻る</a>
		</div>
	</c:param>
</c:import>
