<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>#./liste_livre.sh</title>
</head>
<body>

<p>./liste_livre.sh</p>
<c:set var="collections" value="${requestScope['LISTE_COLLECTION']}"/>

	<c:if test="${fn:length(collections) > 1}">
		<c:forEach var="a" items="${collections}">
			#<c:out value="${a.nom}"/>
			<a href="${pageContext.request.contextPath}/spring/delco?ID=${a.id}&DELETE=true">x</a>&nbsp; 
			<br>
		</c:forEach>
	</c:if>
<form action="${pageContext.request.contextPath}/spring/addCo" method="post">
	#Collection: <input type="text" name="COL_NAME" value="0"/>
	<input type="submit" value="envoyer"/>
</form>
</body>
</html>