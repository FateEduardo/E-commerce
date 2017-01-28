<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<tiles:importAttribute name="stylesheets"/>
<tiles:importAttribute name="javascript"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="initial-scale=1, maximum-scale=1">
	<title><tiles:insertAttribute name="title" /></title>
 <!-- stylesheets -->
   		   <link rel="icon" type="image/png"  href="<c:url value="/resources/images/icon.png"/>" />
			<c:forEach var="js" items="${javascript}">
        		<script type="text/javascript" src="<c:url value="${js}"/>"></script>
    		</c:forEach>
			<c:forEach var="css" items="${stylesheets}">
        		<link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
    		</c:forEach>
		    
    <!-- end stylesheets -->
</head>
<body data-ng-app="MyApp">
	<div>
		<tiles:insertAttribute name="menu" />
	</div>
	<div>
			<tiles:insertAttribute name="carousel" />
	</div>
	<div>
		<div class="space">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
	<br></br>
	<div>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>