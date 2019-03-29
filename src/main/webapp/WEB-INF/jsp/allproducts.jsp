<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
<title><s:message code="produkt.sprzedane"/></title>
</head>
<body>
<%@include file="/WEB-INF/incl/menu.app" %>
<div align="center">
<h2><s:message code="produkt.sprzedane"/></h2>

<table width ="100%" border="0" cellpadding="8" cellspacing="4" class="tableMenuBg" bgcolor="#D7D9D9">

<tr>
                <td width="40" align = "center"><s:message code="product.id"/> </td>
                <td width="200" align = "center"><s:message code="product.name"/> </td>
                <td width="200" align = "center"><s:message code="product.price"/> </td>
                <td width="200" align = "center"><s:message code="product.amount"/> </td>
                <td width="220" align = "center"><s:message code="product.category"/> </td>
</tr>

<c:forEach var="u" items="${sprzedaneList}">
<tr onmouseover="changeTrBg(this)" onmouseout="defaultTrBg(this)">
<td align="right"><c:out value="${u.id }" /></td>
<td align="right"><c:out value="${u.pName }" /></td>
<td align="right"><c:out value="${u.price}" /></td>
<td align="right"><c:out value="${u.amount }" /></td>
</tr><td align="right"><c:out value="${u.categ }" /></td>
</c:forEach>
</table>


</div>
</body>
</html>