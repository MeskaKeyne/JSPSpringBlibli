<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>#./liste_auteur.sh</title>
</head>
<body>

<p>./liste_auteurs.sh</p>
<c:set var="auteurs" value="${requestScope['LISTE_AUTEUR']}"/>

	<c:if test="${fn:length(auteurs) > 1}">
		<c:forEach var="a" items="${auteurs}">
			#<c:out value="${a.nom} ${a.prenom}"/>
			<a href="${pageContext.request.contextPath}/spring/delAuteur?ID=${a.id}&DELETE=true">x</a>&nbsp; 
			<br>
		</c:forEach>
	</c:if>
<br>
<form action="${pageContext.request.contextPath}/spring/addAuteur" method="post">
	#Nom: <input type="text" name="AUTEUR_NOM" value="0"/>
	#Prenom: <input type="text" name="AUTEUR_PRENOM" value="0"/>
	<input type="submit" value="envoyer"/>
</form>
</body>
</html>