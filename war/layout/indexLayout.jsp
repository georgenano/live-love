<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<link rel="stylesheet" href="/css/common.css" type="text/css"
	media="all" />
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja" lang="ja">
<head>
<title>${param.title}</title>
<meta http-equiv="Content-Script-Type" content="text/javascript" />
</head>
<body>
	<img class="bg" src="/img/background.jpg" alt="" />
	<div id="container">
		<c:import url="/layout/indexHeader.jsp" />
		<div id="main" class="clearfix">${param.content}</div>
		<c:import url="/layout/footer.jsp" />
	</div>
</body>
</html>