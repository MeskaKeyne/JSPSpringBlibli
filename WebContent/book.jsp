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
<c:set var="livres" value="${requestScope['LISTE_LIVRE']}"/>

<c:if test="${fn:length(livres) > 1}">
	<c:forEach var="a" items="${livres}">
		#<c:out value="${a.titre}"/>
		<c:if  test="${fn:length(a.booked) == 0}">
		<a href="${pageContext.request.contextPath}/spring/delBook?ID=${a.code}&DELETE=true">x</a>&nbsp; 
		</c:if>
		<br>
	</c:forEach>
</c:if>
<form action="${pageContext.request.contextPath}/spring/addbook" method="post">
		./add_book.sh :
		<br>
		#titre
		<input type= "text" name="TITRE"/>
		&nbsp;
		#nr_edt
		<input type= "text" name="ID_EDITION"/>
		&nbsp;
		#nb_pages
		<input type= "text" name="PAGES"/>
		&nbsp;
		#date_parution
		<input type= "date" name="DATE"/>
		&nbsp;
		#collection
		<select name="ID_COLLECTION">
			<c:forEach var="col" items="${requestScope['COLLECTION']}">
				<option value="${col.id}"> <c:out value="${col.nom}" /></option>
			</c:forEach>
		</select>
		&nbsp;
		<select multiple name="AUTEUR">
			<c:forEach var="auteur" items="${requestScope['AUTEURS']}">
			<option value="none">aucune</option>
				<option value="${auteur.id}"> <c:out value="${auteur.nom} ${auteur.prenom}" /></option>
			</c:forEach>
		</select> 
		&nbsp;
	<input type="submit" value="!"/>
</form>
</body>
</html>