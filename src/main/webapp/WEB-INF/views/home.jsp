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
		<div class="cheatsheet">
		   <div class="title">Java</div>
		   <div class="content">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</div>
		</div>
		<div class="cheatsheet">
	       <div class="title">Java</div>
	       <div class="content">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</div>
	    </div>
	    <div class="cheatsheet">
	       <div class="title">Java</div>
	       <div class="content">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</div>
	    </div>
    </div>
<!-- <P>  The time on the server is ${serverTime}. </P> -->
</body>
</html>
