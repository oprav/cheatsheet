<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Edit theme ${theme.title}</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/style.css"/>
</head>
<body>
<div id="cheatsheetContainer">
            <div class="cheatSheetz">
                <div class="themeTitle">
                    <a href="../showtheme/${theme.id}">${theme.title}</a>
                </div>
                <form action="../committheme" method="post">
                   <!-- Saving object id -->
                   <input type="hidden" name="id" value="${theme.id}"/>
                   <div class="editThemeButtonBox">
                   <table>
                   <tr>
                   <td> 
                        <input type="submit" name="closeButton" value="Close" />
                   <td> 
                        <input type="submit" name="saveButton" value="Save" />
                   <td> 
                        <input type="submit" name="addTopic" value="Add Topic" />
                   </tr>
                   </table>
                   </div>
                   <table>
                   <tr>
	                   <td><p>Theme Title: </p> <td><input type="text" name="title" class="themeTitle" value="${theme.title}" width="50"/>
	               </tr>
	               <tr>
	                   <td><p>Theme Description: </p> <td><textarea cols="50" rows="5" name="descr" class="themeDescription">${theme.description}</textarea>
	               </tr>
	               </table>
	               <!-- Forming topics layout -->
	               <table>
	               
	               <c:forEach var="item" items="${theme.topics}" varStatus="itStatus">
	               <tr><td>Topic Title: <td>
	               <input name="topics[${itStatus.index}].title" value="${item.title}" />
	               </tr>
	               <tr><td>Topic text:<td>
	               <textarea name="topics[${itStatus.index}].description" value="${item.descr}">${item.descr}</textarea>
	               </tr>
	               <input type="hidden" name="topics[${itStatus.index}].id" value="${item.id}" />
	               <input type="hidden" name="topics[${itStatus.index}].theme_id" value="${item.theme_id}" />
	               <input type="hidden" name="topics[${itStatus.index}].sort_id" value="${item.sort_id}" />
	               <input type="hidden" name="topics[${itStatus.index}].is_delete" value="${item.is_delete}" />	               
	               </c:forEach>
	               </table>
	               
                </form>
            </div>    
    </div>
</body>
</html>