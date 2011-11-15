<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Cheatsheet</title>
	<link rel="stylesheet" type="text/css" href="resources/css/style.css"/>
</head>
<body>
	<table><tr>
		<td>
			<form action="chooseProfile" method="post">
				<select>
				  <option>Java Web Profile</option>
				  <option>Java ME</option>
				</select>
			</form>
		</td>
		<td>
			<form action="addCheatsheet" method="post">
		       <input type="submit" value="Add cheatsheet to profile">
		    </form>
	    </td>
    </tr></table>
    <div id="cheatsheetContainer">
        <c:forEach var="theme" items="${themes}">
            <div class="cheatsheet">
            <div class="title">${theme.title}</div>
            <c:forEach var="topic" items="${theme.topics}">
                    <div class="content">${topic.title}</div>
            </c:forEach>
            </div>    
        </c:forEach>
    </div>
<!-- <P>  The time on the server is ${serverTime}. </P> -->
</body>
</html>
