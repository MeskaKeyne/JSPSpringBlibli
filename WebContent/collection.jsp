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
			<br>
		</c:forEach>
	</c:if>
</body>
</html>