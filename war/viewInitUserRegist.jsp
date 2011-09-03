<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<c:import url="/layout/layout.jsp">
	<c:param name="title" value="ユーザ情報初期登録" />
	<c:param name="content">

		<script language="JavaScript">
		function FormCheck(Form) {
			Error = new Array();
			i = 0;
			textCheck(Form["nickname"], "ニックネーム");
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

		<form method="post" action="/initUserRegist?continue=${continue}"
			onSubmit="return FormCheck(this)">
			<div id="detail">
				<table summary="ユーザ情報登録フォーム">
					<tr>
						<th><label for="nickname">ニックネーム</label><span>※</span></th>
						<td><input type="text" name="nickname" id="nickname" value=""
							size="60" /></td>
					</tr>
					<tr>
						<th><label for="mail">メールアドレス</label></th>
						<td><input type="text" name="mail" id="mail" value=""
							size="60" /></td>
					</tr>
				</table>
			</div>
			<input type="submit" value="ユーザ情報登録" />
		</form>

	</c:param>
</c:import>