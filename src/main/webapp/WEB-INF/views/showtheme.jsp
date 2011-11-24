<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head><title>${profilename}: ${themename}</title></head>
<body>
<div id="themeHeader">
    <p><a href="?profile_id=${profileid}">${profilename}</a> > ${themename}</p>
    <form action="edittheme">
        <input type="hidden" name="theme_id" value="${themeid}" />
        <input type="submit" value="Edit Cheatsheet" />
    </form>
</div>

<div id="themeContent">
    <div id="themeDetails">${themedetails}</div>
    <div id="topicsContainer">
		<c:forEach var="topic" items="${theme.topics}">
		<div class="topic">
		  <h1>Topic ${topic.id}</h1>
            <div id="topicBody">${topic.title}</div>
		</div>
		</c:forEach>
    </div>
    
</div>

</body>
</html>