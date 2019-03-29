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
<title><s:message code="menu.users"/></title>
</head>
<body>
<%@include file="/WEB-INF/incl/menu.app" %>
<h2><s:message code="menu.users"/></h2>

    <table width ="100%" border="0" cellpadding="8" cellspacing="4" class="tableMenuBg" bgcolor="#D7D9D9">
            <tr>
                <td width="40" align = "center"><s:message code="admin.user.id"/> </td>
                <td width="200" align = "center"><s:message code="register.name"/> </td>
                <td width="200" align = "center"><s:message code="register.lastName"/> </td>
                <td width="220" align = "center"><s:message code="register.email"/> </td>
                <td width="90" align = "center"><s:message code="profil.czyAktywny"/> </td>
                <td width="200" align = "center"><s:message code="profil.rola"/> </td>
            </tr>

            <c:forEach var="u" items="${userList }">
            		<c:set var="licznik" value="${licznik+1}"/>
            		<tr onmouseover="changeTrBg(this)" onmouseout="defaultTrBg(this)">
            			<td align="right"><c:out value="${licznik }"/></td>
            			<td align="right"><c:out value="${u.id }" /></td>
            			<td align="left"><c:out value="${u.name }" /></td>
            			<td align="left"><c:out value="${u.lastName }" /></td>
            			<td align="center"><c:out value="${u.email }" /></td>
            			<td align="center">
            				<c:choose>
            					<c:when test="${u.active == 1 }">
            						<font color="green"><s:message code="word.tak"/></font>
            					</c:when>
            					<c:otherwise>
            						<font color="red"><s:message code="word.nie"/></font>
            					</c:otherwise>
            				</c:choose>
            			</td>
            			<td align="center">
            			<c:choose>
            				<c:when test="${u.nrRoli == 1 }">
            					<font color="green"><s:message code="word.admin"/></font>
            				</c:when>
            				<c:otherwise>
            					<s:message code="word.user"/>
            				</c:otherwise>
            			</c:choose>
            			</td>

            		</tr>
            	</c:forEach>

        </table>

</body>
</html>