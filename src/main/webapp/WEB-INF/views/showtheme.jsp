<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>${profilename}: ${themename}</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css"/>
</head>
<body>
<div id="themeHeader">
    <p><a href="?profile_id=${profileid}">${profilename}</a> > ${theme.title}</p>
    <a class="editThemeButton" href="../edittheme/${theme.id}">Edit CheatSheet theme </a>
</div>
<div id="cheatsheetContainer">
    <div class="topic">
	<div class="themeDescription">${theme.description}</div>
	                <c:forEach var="topic" items="${theme.topics}">
	                        <div class="topicTitle">
	                            ${topic.title}
	                        </div>
	                        <div class="topicDescription">${topic.description}</div>
	                </c:forEach>
	</div>
	</div>
</div>
</body>
</html>