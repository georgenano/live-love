<%@page import="java.util.Calendar"%>
<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/layout/layout.jsp">
	<c:param name="title" value="[ライブラブ〜Live Love〜] ライブ情報登録" />
	<c:param name="content">
		<script language="JavaScript">
		<!--
		function FormCheck(Form) {
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
				Text.style.backgroundColor = '#ffcc66';
				i++;
			} else {
				Text.style.backgroundColor = '#ffffff';
			}
		}

		function listCheck(List, jname){
			if ((List) && (List[0].selected == true)) {
				Error[i] = jname + "は必須項目です。";
				List.style.backgroundColor = '#ffcc66';
				i++;
			} else {
				List.style.backgroundColor = '#ffffff';
			}
		}
		// -->
		</script>

		<form method="post" action="registLive"
			onSubmit="return FormCheck(this)">
			<div id="detail">
				<table summary="ライブ情報記入フォーム">
					<tr>
						<th><label for="liveName">ライブ名</label><span>※</span></th>
						<td><input type="text" name="liveName" id="liveName" value=""
							size="60" class="required" title="入力してください" /></td>
					</tr>
					<tr>
						<th><label for="artistList">出演アーティスト</label><span>※</span></th>
						<td><input type="text" name="artistList" id="artistList"
							value="" size="60" class="required" title="入力してください" /></td>
					</tr>
					<tr>
						<th>地域<span>※</span>
						</th>
						<td><select name="pref" style="">
								<option value="" selected="selected">地域を選択</option>
								<option label="北海道" value="1">北海道</option>
								<option label="青森県" value="2">青森県</option>
								<option label="岩手県" value="3">岩手県</option>
								<option label="宮城県" value="4">宮城県</option>
								<option label="秋田県" value="5">秋田県</option>
								<option label="山形県" value="6">山形県</option>
								<option label="福島県" value="7">福島県</option>
								<option label="茨城県" value="8">茨城県</option>
								<option label="栃木県" value="9">栃木県</option>
								<option label="群馬県" value="10">群馬県</option>
								<option label="埼玉県" value="11">埼玉県</option>
								<option label="千葉県" value="12">千葉県</option>
								<option label="東京都" value="13">東京都</option>
								<option label="神奈川県" value="14">神奈川県</option>
								<option label="新潟県" value="15">新潟県</option>
								<option label="富山県" value="16">富山県</option>
								<option label="石川県" value="17">石川県</option>
								<option label="福井県" value="18">福井県</option>
								<option label="山梨県" value="19">山梨県</option>
								<option label="長野県" value="20">長野県</option>
								<option label="岐阜県" value="21">岐阜県</option>
								<option label="静岡県" value="22">静岡県</option>
								<option label="愛知県" value="23">愛知県</option>
								<option label="三重県" value="24">三重県</option>
								<option label="滋賀県" value="25">滋賀県</option>
								<option label="京都府" value="26">京都府</option>
								<option label="大阪府" value="27">大阪府</option>
								<option label="兵庫県" value="28">兵庫県</option>
								<option label="奈良県" value="29">奈良県</option>
								<option label="和歌山県" value="30">和歌山県</option>
								<option label="鳥取県" value="31">鳥取県</option>
								<option label="島根県" value="32">島根県</option>
								<option label="岡山県" value="33">岡山県</option>
								<option label="広島県" value="34">広島県</option>
								<option label="山口県" value="35">山口県</option>
								<option label="徳島県" value="36">徳島県</option>
								<option label="香川県" value="37">香川県</option>
								<option label="愛媛県" value="38">愛媛県</option>
								<option label="高知県" value="39">高知県</option>
								<option label="福岡県" value="40">福岡県</option>
								<option label="佐賀県" value="41">佐賀県</option>
								<option label="長崎県" value="42">長崎県</option>
								<option label="熊本県" value="43">熊本県</option>
								<option label="大分県" value="44">大分県</option>
								<option label="宮崎県" value="45">宮崎県</option>
								<option label="鹿児島県" value="46">鹿児島県</option>
								<option label="沖縄県" value="47">沖縄県</option>
						</select>
						</td>
					</tr>
					<tr>
						<th><label for="livePlace">ライブ会場</label></th>
						<td><input type="text" name="livePlace" id="livePlace"
							value="" size="60" class="required" title="入力してください" /></td>
					</tr>
					<tr>
						<th><label for="start_year">開催日</label><span>※</span></th>
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
						</select>分
					</tr>
					<tr>
						<th>開演時間<span>※</span>
						</th>
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
						</select></td>
					</tr>
					<tr>
						<th><label for="charge">料金</label></th>
						<td>前売 ￥<input type="text" name="advanceCharge" id="charge"
							value="" size="20" class="required" title="入力してください" /><br />
							当日 ￥<input type="text" name="todayCharge" id="charge" value=""
							size="20" class="required" title="入力してください" /></td>
					</tr>
					<tr>
						<th><label for="note">説明</label></th>
						<td><textarea name="note" id="note" rows="7" cols="46"></textarea>
						</td>
					</tr>
				</table>
			</div>
			<input type="submit" value="ライブ情報登録" />
		</form>
	</c:param>
</c:import>
