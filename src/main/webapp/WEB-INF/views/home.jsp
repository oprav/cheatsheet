<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
<head>
	<title>Cheatsheet</title>
	<link rel="stylesheet" type="text/css" href="resources/css/style.css"/>
</head>
<body>
<p>Welcome ${username}</p>
<c:choose>
    <c:when test="${is_anonymous == 'true'}">
        <p>You are not logged in. Please <a href="login">log in</a>.
    </c:when>
    <c:otherwise>
	    <table>
	    <tr>
	        <td>
	            <form action="choosetheme" method="post">
	                <select>
	                  <option>Java Web Profile</option>
	                  <option>Java ME</option>
	                </select>
	            </form>
	        </td>
	        <td>
	            <form action="addtheme" method="post">
	               <input type="submit" value="Add cheatsheet to profile">
	            </form>
	        </td>
	    </tr>
	    </table>
    </c:otherwise>
</c:choose>
    <div id="cheatsheetContainer">
        <c:forEach var="theme" items="${themes}">
            <div class="cheatSheet">
	            <div class="themeTitle">
	                <a href="showtheme/${theme.id}">${theme.title}</a>
	            </div>
	            <div class="themeDescription">${theme.description}</div>
	            <c:forEach var="topic" items="${theme.topics}">
	                    <div class="topicTitle">
	                        <a href="showtheme/${theme.id}">${topic.title}</a>
	                    </div>
	                    <div class="topicDescription">${topic.description}</div>
	            </c:forEach>
            </div>    
        </c:forEach>
    </div>
<!-- <P>  The time on the server is ${serverTime}. </P> -->
</body>
</html>
