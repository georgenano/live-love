<%@page import="java.util.Calendar"%>
<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/layout/layout.jsp">
	<c:param name="title" value="ライブ情報登録" />
	<c:param name="content">
		<script language="JavaScript">		function FormCheck(Form) {
			Error = new Array();
			i = 0;
			textCheck(Form["liveName"], "ライブ名");
			textCheck(Form["artistList"], "出演アーティスト");
			listCheck(Form["pref"], "地域");
			listCheck(Form["start_year"], "開催年");
			listCheck(Form["start_month"], "開催月");
			listCheck(Form["start_day"], "開催日");
			listCheck(Form["start_hour"], "開演時間（時）");
			listCheck(Form["start_time"], "開演時間（分）");
			// 未入力があればアラート
			if (Error.length > 0) {
				ErrorText = Error.join("\n");
				alert ("不備があるので送信できません。\n\n"+ErrorText);
				return false;
			}
		}

		function textCheck(Text, jname){
			if ((Text) && (Text.value == "")) {
				Error[i] = jname + "は必須項目です。";
				Text.style.backgroundColor = '#CC80B3';
				i++;
			} else {
				Text.style.backgroundColor = '#ffffff';
			}
		}

		function listCheck(List, jname){
			if ((List) && (List[0].selected == true)) {
				Error[i] = jname + "は必須項目です。";
				List.style.backgroundColor = '#CC80B3';
				i++;
			} else {
				List.style.backgroundColor = '#ffffff';
			}
		}
		</script>

		<form method="post" action="registLive"
			onSubmit="return FormCheck(this)">
			<div id="detail">
				<table summary="ライブ情報記入フォーム">
					<tr>
						<th><label for="liveName">ライブ名</label><span>※</span>
						</th>
						<td><input type="text" name="liveName" id="liveName" value=""
							size="60" class="required" title="入力してください" />
						</td>
						<td>イベント名を入力してください</td>
					</tr>
					<tr>
						<th><label for="artistList">出演アーティスト</label><span>※</span>
						</th>
						<td><input type="text" name="artistList" id="artistList"
							value="" size="60" class="required" title="入力してください" />
						</td>
						<td>出演アーティストは「,」(コンマ)区切りで複数登録できます</td>
					</tr>
					<tr>
						<th>地域<span>※</span></th>
						<td><select name="pref" style="">
								<option value="" selected="selected">地域を選択</option>
								<option value="北海道">北海道</option>
								<option value="青森県">青森県</option>
								<option value="岩手県">岩手県</option>
								<option value="宮城県">宮城県</option>
								<option value="秋田県">秋田県</option>
								<option value="山形県">山形県</option>
								<option value="福島県">福島県</option>
								<option value="茨城県">茨城県</option>
								<option value="栃木県">栃木県</option>
								<option value="群馬県">群馬県</option>
								<option value="埼玉県">埼玉県</option>
								<option value="千葉県">千葉県</option>
								<option value="東京都">東京都</option>
								<option value="神奈川県">神奈川県</option>
								<option value="新潟県">新潟県</option>
								<option value="富山県">富山県</option>
								<option value="石川県">石川県</option>
								<option value="福井県">福井県</option>
								<option value="山梨県">山梨県</option>
								<option value="長野県">長野県</option>
								<option value="岐阜県">岐阜県</option>
								<option value="静岡県">静岡県</option>
								<option value="愛知県">愛知県</option>
								<option value="三重県">三重県</option>
								<option value="滋賀県">滋賀県</option>
								<option value="京都府">京都府</option>
								<option value="大阪府">大阪府</option>
								<option value="兵庫県">兵庫県</option>
								<option value="奈良県">奈良県</option>
								<option value="和歌山県">和歌山県</option>
								<option value="鳥取県">鳥取県</option>
								<option value="島根県">島根県</option>
								<option value="岡山県">岡山県</option>
								<option value="広島県">広島県</option>
								<option value="山口県">山口県</option>
								<option value="徳島県">徳島県</option>
								<option value="香川県">香川県</option>
								<option value="愛媛県">愛媛県</option>
								<option value="高知県">高知県</option>
								<option value="福岡県">福岡県</option>
								<option value="佐賀県">佐賀県</option>
								<option value="長崎県">長崎県</option>
								<option value="熊本県">熊本県</option>
								<option value="大分県">大分県</option>
								<option value="宮崎県">宮崎県</option>
								<option value="鹿児島県">鹿児島県</option>
								<option value="沖縄県">沖縄県</option>
						</select></td>
						<td></td>
					</tr>
					<tr>
						<th><label for="livePlace">ライブ会場</label>
						</th>
						<td><input type="text" name="livePlace" id="livePlace"
							value="" size="60" class="required" title="入力してください" />
						</td>
						<td></td>
					</tr>
					<tr>
						<th><label for="start_year">開催日</label><span>※</span>
						</th>
						<td><select name="start_year" style="">
								<option value="" selected="selected">--</option>
								<option label="2010" value="2010">2010</option>
								<option label="2011" value="2011" selected>2011</option>
								<option label="2012" value="2012">2012</option>
								<option label="2013" value="2013">2013</option>
								<option label="2014" value="2014">2014</option>
						</select>年 <select name="start_month" style="">
								<option value="" selected="selected">--</option>
								<c:forEach begin="1" end="12" var="month">
									<c:choose>
										<c:when test="${month==thisMonth}">
											<option label="${month}" value="${month}" selected>${month}</option>
										</c:when>
										<c:otherwise>
											<option label="${month}" value="${month}">${month}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select>月 <select name="start_day" style="">
								<option value="" selected="selected">--</option>
								<c:forEach begin="1" end="${dayMaximum}" var="day">
									<c:choose>
										<c:when test="${day==thisDay}">
											<option label="${day}" value="${day}" selected>${day}</option>
										</c:when>
										<c:otherwise>
											<option label="${day}" value="${day}">${day}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select>日</td>
						<td></td>
					</tr>
					<tr>
						<th>開場時間</th>
						<td><select name="open_hour" style="">
								<option value="" selected="selected">--</option>
								<c:forEach begin="0" end="23" var="hour">
									<option label="${hour}" value="${hour}">${hour}</option>
								</c:forEach>
						</select>時 <select name="open_time" style="">
								<option value="" selected="selected">--</option>
								<option label="00" value="0">00</option>
								<option label="15" value="15">15</option>
								<option label="30" value="30">30</option>
								<option label="45" value="45">45</option>
						</select>分</td>
						<td></td>
					</tr>
					<tr>
						<th>開演時間<span>※</span></th>
						<td><select name="start_hour" style="">
								<option value="" selected="selected">--</option>
								<c:forEach begin="0" end="23" var="hour">
									<option label="${hour}" value="${hour}">${hour}</option>
								</c:forEach>
						</select>時 <select name="start_time" style="">
								<option value="" selected="selected">--</option>
								<option label="00" value="0">00</option>
								<option label="15" value="15">15</option>
								<option label="30" value="30">30</option>
								<option label="45" value="45">45</option>
						</select>分 ～ <select name="end_hour" style="">
								<option value="" selected="selected">--</option>
								<c:forEach begin="0" end="23" var="hour">
									<option label="${hour}" value="${hour}">${hour}</option>
								</c:forEach>
						</select>時 <select name="end_time" style="">
								<option value="" selected="selected">--</option>
								<option label="00" value="0">00</option>
								<option label="15" value="15">15</option>
								<option label="30" value="30">30</option>
								<option label="45" value="45">45</option>
						</select>
						</td>
						<td></td>
					</tr>
					<tr>
						<th><label for="charge">料金</label>
						</th>
						<td>前売 ￥<input type="text" name="advanceCharge" id="charge"
							value="" size="20" class="required" title="入力してください" /><br />
							当日 ￥<input type="text" name="todayCharge" id="charge" value=""
							size="20" class="required" title="入力してください" />
						</td>
						<td></td>
					</tr>
					<tr>
						<th><label for="note">説明</label>
						</th>
						<td><textarea name="note" id="note" rows="7" cols="46"></textarea>
						</td>
						<td></td>
					</tr>
				</table>
				<input type="submit" value="ライブ情報登録" />
			</div>
		</form>
		<div id="back_link">
			<a href="/livelove/">ライブカレンダーに戻る</a>
		</div>
	</c:param>
</c:import>
