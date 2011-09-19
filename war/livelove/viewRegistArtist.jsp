<%@page import="java.util.Calendar"%>
<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/layout/layout.jsp">
	<c:param name="title" value="アーティスト情報登録" />
	<c:param name="content">
		<script language="JavaScript">		function FormCheck(Form) {
			Error = new Array();
			i = 0;
			textCheck(Form["name"], "アーティスト名");
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

		<form method="post" action="registArtist"
			onSubmit="return FormCheck(this)">
			<div id="detail">
				<table summary="アーティスト情報記入フォーム">
					<tr>
						<th><label for="liveName">アーティスト名</label><span>※</span>
						</th>
						<td><input type="text" name="name" id="name" value=""
							size="60" class="required" title="入力してください" />
						</td>
						<td>アーティスト名を入力してください</td>
					</tr>
					<tr>
						<th><label for="anotherNameList">別名、略称</label>
						</th>
						<td><input type="text" name="anotherNameList" id="anotherNameList"
							value="" size="60" class="required" title="入力してください" />
						</td>
						<td>別名、略称は「,」(コンマ)区切りで複数登録できます</td>
					</tr>
					<tr>
						<th><label for="note">説明</label>
						</th>
						<td><textarea name="description" id="description" rows="7" cols="46"></textarea>
						</td>
						<td></td>
					</tr>
				</table>
				<input type="submit" value="アーティスト情報登録" />
			</div>
		</form>
		<div id="back_link">
			<a href="/livelove/">ライブカレンダーに戻る</a>
		</div>
	</c:param>
</c:import>
