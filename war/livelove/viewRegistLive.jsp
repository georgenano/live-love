<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/layout/layout.jsp">
	<c:param name="title" value="[ライブラブ〜Live Love〜] ライブ情報登録" />
	<c:param name="content">
		<form method="post" action="registLive">
			<table summary="ライブ情報記入フォーム">
				<tr>
					<th><label for="liveName">ライブ名</label>
					</th>
					<td><input type="text" name="liveName" id="liveName" value=""
						size="20" class="required" title="入力してください" />
					</td>
				</tr>
				<tr>
					<th><label for="artistList">出演アーティスト</label>
					</th>
					<td><input type="text" name="artistList" id="artistList"
						value="" size="20" class="required" title="入力してください" />
					</td>
				</tr>
				<tr>
					<th>地域</th>
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
					</select></td>
				</tr>
				<tr>
					<th><label for="livePlace">ライブ会場</label>
					</th>
					<td><input type="text" name="livePlace" id="livePlace"
						value="" size="10" class="required" title="入力してください" />
					</td>
				</tr>
				<tr>
					<th><label for="start_year">開催日</label>
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
							<option label="1" value="1">1</option>
							<option label="2" value="2">2</option>
							<option label="3" value="3">3</option>
							<option label="4" value="4">4</option>
							<option label="5" value="5">5</option>
							<option label="6" value="6">6</option>
							<option label="7" value="7">7</option>
							<option label="8" value="8" selected>8</option>
							<option label="9" value="9">9</option>
							<option label="10" value="10">10</option>
							<option label="11" value="11">11</option>
							<option label="12" value="12">12</option>
					</select>月 <select name="start_day" style="">
							<option value="" selected="selected">--</option>
							<option label="1" value="1">1</option>
							<option label="2" value="2">2</option>
							<option label="3" value="3">3</option>
							<option label="4" value="4">4</option>
							<option label="5" value="5">5</option>
							<option label="6" value="6" selected>6</option>
							<option label="7" value="7">7</option>
							<option label="8" value="8">8</option>
							<option label="9" value="9">9</option>
							<option label="10" value="10">10</option>
							<option label="11" value="11">11</option>
							<option label="12" value="12">12</option>
							<option label="13" value="13">13</option>
							<option label="14" value="14">14</option>
							<option label="15" value="15">15</option>
							<option label="16" value="16">16</option>
							<option label="17" value="17">17</option>
							<option label="18" value="18">18</option>
							<option label="19" value="19">19</option>
							<option label="20" value="20">20</option>
							<option label="21" value="21">21</option>
							<option label="22" value="22">22</option>
							<option label="23" value="23">23</option>
							<option label="24" value="24">24</option>
							<option label="25" value="25">25</option>
							<option label="26" value="26">26</option>
							<option label="27" value="27">27</option>
							<option label="28" value="28">28</option>
							<option label="29" value="29">29</option>
							<option label="30" value="30">30</option>
							<option label="31" value="31">31</option>
					</select>日</td>
					<td></td>
				</tr>
				<tr>
					<th>開場時間</th>
					<td><select name="open_hour" style="">
							<option value="" selected="selected">--</option>
							<option label="0" value="0">0</option>
							<option label="1" value="1">1</option>
							<option label="2" value="2">2</option>
							<option label="3" value="3">3</option>
							<option label="4" value="4">4</option>
							<option label="5" value="5">5</option>
							<option label="6" value="6">6</option>
							<option label="7" value="7">7</option>
							<option label="8" value="8">8</option>
							<option label="9" value="9">9</option>
							<option label="10" value="10">10</option>
							<option label="11" value="11">11</option>
							<option label="12" value="12">12</option>
							<option label="13" value="13">13</option>
							<option label="14" value="14">14</option>
							<option label="15" value="15">15</option>
							<option label="16" value="16">16</option>
							<option label="17" value="17">17</option>
							<option label="18" value="18">18</option>
							<option label="19" value="19">19</option>
							<option label="20" value="20">20</option>
							<option label="21" value="21">21</option>
							<option label="22" value="22">22</option>
							<option label="23" value="23">23</option>
					</select>時 <select name="open_time" style="">
							<option value="" selected="selected">--</option>
							<option label="00" value="0">00</option>
							<option label="15" value="15">15</option>
							<option label="30" value="30">30</option>
							<option label="45" value="45">45</option>
					</select>分
				</tr>
				<tr>
					<th>開演時間</th>
					<td><select name="start_hour" style="">
							<option value="" selected="selected">--</option>
							<option label="0" value="0">0</option>
							<option label="1" value="1">1</option>
							<option label="2" value="2">2</option>
							<option label="3" value="3">3</option>
							<option label="4" value="4">4</option>
							<option label="5" value="5">5</option>
							<option label="6" value="6">6</option>
							<option label="7" value="7">7</option>
							<option label="8" value="8">8</option>
							<option label="9" value="9">9</option>
							<option label="10" value="10">10</option>
							<option label="11" value="11">11</option>
							<option label="12" value="12">12</option>
							<option label="13" value="13">13</option>
							<option label="14" value="14">14</option>
							<option label="15" value="15">15</option>
							<option label="16" value="16">16</option>
							<option label="17" value="17">17</option>
							<option label="18" value="18">18</option>
							<option label="19" value="19">19</option>
							<option label="20" value="20">20</option>
							<option label="21" value="21">21</option>
							<option label="22" value="22">22</option>
							<option label="23" value="23">23</option>
					</select>時 <select name="start_time" style="">
							<option value="" selected="selected">--</option>
							<option label="00" value="0">00</option>
							<option label="15" value="15">15</option>
							<option label="30" value="30">30</option>
							<option label="45" value="45">45</option>
					</select>分 ～ <select name="end_hour" style="">
							<option value="" selected="selected">--</option>
							<option label="0" value="0">0</option>
							<option label="1" value="1">1</option>
							<option label="2" value="2">2</option>
							<option label="3" value="3">3</option>
							<option label="4" value="4">4</option>
							<option label="5" value="5">5</option>
							<option label="6" value="6">6</option>
							<option label="7" value="7">7</option>
							<option label="8" value="8">8</option>
							<option label="9" value="9">9</option>
							<option label="10" value="10">10</option>
							<option label="11" value="11">11</option>
							<option label="12" value="12">12</option>
							<option label="13" value="13">13</option>
							<option label="14" value="14">14</option>
							<option label="15" value="15">15</option>
							<option label="16" value="16">16</option>
							<option label="17" value="17">17</option>
							<option label="18" value="18">18</option>
							<option label="19" value="19">19</option>
							<option label="20" value="20">20</option>
							<option label="21" value="21">21</option>
							<option label="22" value="22">22</option>
							<option label="23" value="23">23</option>
					</select>時 <select name="end_time" style="">
							<option value="" selected="selected">--</option>
							<option label="00" value="0">00</option>
							<option label="15" value="15">15</option>
							<option label="30" value="30">30</option>
							<option label="45" value="45">45</option>
					</select>
					</td>
				</tr>
				<tr>
					<th><label for="charge">料金</label>
					</th>
					<td>前売 ￥<input type="text" name="advanceCharge" id="charge"
						value="" size="20" class="required" title="入力してください" /> 当日 ￥<input
						type="text" name="todayCharge" id="charge" value="" size="20"
						class="required" title="入力してください" />
					</td>
				</tr>
				<tr>
					<th><label for="note">説明</label>
					</th>
					<td><textarea name="note" id="note" rows="7" cols="46"></textarea>
					</td>
				</tr>
			</table>
			<input type="submit" value="ライブ情報登録" />
		</form>
	</c:param>
</c:import>
