<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setTimeZone value="JST" />

<c:import url="/layout/layout.jsp">
	<c:param name="title" value="ライブ情報詳細" />
	<c:param name="content">
		<script language="JavaScript">		function DeleteConfirm() {
			return (confirm("本当に削除しますか？"));
		}
		</script>
		<div id="left">
			<div id="page_title">ライブ情報詳細</div>
			<div id="detail">
				<table>
					<tr>
						<th>ライブ名</th>
						<td>${f:h(live.liveName)}</td>
					</tr>
					<tr>
						<th>出演アーティスト</th>
						<td><c:forEach var="artist" items="${joinArtistList}">
							 <a href="${f:url('viewArtistDetail?key=')}${f:h(artist.key)}">${f:h(artist.name)}</a>
						</c:forEach></td>
					</tr>
					<tr>
						<th>地域</th>
						<td>${f:h(live.pref)}</td>
					</tr>
					<tr>
						<th>会場</th>
						<c:choose>
							<c:when test="${f:h(live.livePlace) == ''}">
								<td>NO DATA</td>
							</c:when>
							<c:otherwise>
								<td>${f:h(live.livePlace)}</td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<th>開場時間</th>
						<c:choose>
							<c:when test="${f:h(live.liveOpenDate) == ''}">
								<td>NO DATA</td>
							</c:when>
							<c:otherwise>
								<td><fmt:formatDate value="${live.liveOpenDate}"
										pattern="yyyy年 MM月 dd日 hh:mm" /></td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<th>開演時間</th>
						<c:choose>
							<c:when test="${f:h(live.liveStartDate) == ''}">
								<td>NO DATA</td>
							</c:when>
							<c:otherwise>
								<td><fmt:formatDate value="${live.liveStartDate}"
										pattern="yyyy年 MM月 dd日 hh:mm" /></td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<th>終演時間</th>
						<c:choose>
							<c:when test="${f:h(live.liveEndDate) == ''}">
								<td>NO DATA</td>
							</c:when>
							<c:otherwise>
								<td><fmt:formatDate value="${live.liveEndDate}"
										pattern="yyyy年 MM月 dd日 hh:mm" /></td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<th>前売料金</th>
						<c:choose>
							<c:when test="${f:h(live.advanceCharge) == ''}">
								<td>NO DATA</td>
							</c:when>
							<c:otherwise>
								<td>&yen; ${f:h(live.advanceCharge)}</td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<th>当日料金</th>
						<c:choose>
							<c:when test="${f:h(live.todayCharge) == ''}">
								<td>NO DATA</td>
							</c:when>
							<c:otherwise>
								<td>&yen; ${f:h(live.todayCharge)}</td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<th>説明</th>
						<c:choose>
							<c:when test="${f:h(live.note) == ''}">
								<td>NO DATA</td>
							</c:when>
							<c:otherwise>
								<td>${f:h(live.note)}</td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<th>登録者</th>
						<td>${f:h(live.registUserAccountRef.model.nickname)}</td>
					</tr>
					<c:if test="${f:h(isEditableUser)}">
						<tr>
							<th>更新</th>
							<td><a
								href="${f:url('viewUpdateLive?key=')}${f:h(live.key)}">このライブ情報を更新する</a>
							</td>
						</tr>
						<tr>
							<th>削除</th>
							<td><a href="${f:url('deleteLive?key=')}${f:h(live.key)}"
								onClick="return DeleteConfirm()">このライブ情報を削除する</a></td>
						</tr>
					</c:if>
				</table>

				<div id="commentList">
					<h2>コメント一覧</h2>
					<c:choose>
						<c:when test="${fn:length(commentList)!=0}">
							<c:forEach var="comment" items="${commentList}">
								<div id="comment">
									${f:h(comment.comment)}
									<hr />
									<div id="comment_detail">
										Posted at
										<fmt:formatDate value="${comment.registDate}"
											pattern="yyyy年 MM月 dd日 hh:mm" />
										by ${f:h(comment.registUserAccountRef.model.nickname)}
									</div>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
						コメントはまだありません。
					</c:otherwise>
					</c:choose>
				</div>
				<div id="addComment">
					<h2>コメント新規追加</h2>
					<form method="post"
						action="${f:url('addLiveComment?liveKey=')}${f:h(live.key)}">
						<textarea name="comment" id="comment" rows="7" cols="46"></textarea>
						<br /> <input type="submit" value="コメントする" />
					</form>
				</div>
			</div>
			<div id="back_link">
				<a href="/livelove/">ライブカレンダーに戻る</a>
			</div>
		</div>
		<div id="joinLive">
			<h2>このライブへの参戦者</h2>
			<c:choose>
				<c:when test="${canJoinLive}">
					<a href="${f:url('joinLive?liveKey=')}${f:h(live.key)}">このライブに参戦する（予定）</a>
					<br />
				</c:when>
				<c:otherwise>
					<a href="${f:url('disJoinLive?liveKey=')}${f:h(live.key)}">このライブの参戦を取り消す</a>
					<br />
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${fn:length(joinUserList)!=0}">
					参戦表明者：${fn:length(joinUserList)}人
					<ul>
						<c:forEach var="joinUser" items="${joinUserList}">
							<li>${f:h(joinUser.userAccountRef.model.nickname)}さん 参戦表明日：<fmt:formatDate
									value="${joinUser.registDate}" pattern="yyyy年MM月dd日hh:mm" />
							</li>
						</c:forEach>
					</ul>
				</c:when>
				<c:otherwise>
					参戦者はまだいません。
				</c:otherwise>
			</c:choose>
		</div>

	</c:param>
</c:import>
