<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8; width=device-width; initial-scale=1">
<title>List of candies</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-center-align">
	<h1>CANDIES</h1>
</div>
 <div class="w3-container w3-padding">
	<table class="w3-table-all w3-centered w3-hoverable w3-card w3-padding" border="1">
		<tr class="w3-teal">
			<th>ID</th>
			<th>Type</th>
			<th>Energy</th>
			<th>Water</th>
			<th>Sugar</th>
			<th>Fructose</th>
			<th>Chocolate Type</th>
			<th>Vanillin</th>
			<th>Proteins</th>
			<th>Fats</th>
			<th>Carbohydrates</th>
			<th>Production</th>
			<th>Filling</th>
		</tr>
		<c:forEach items="${sessionScope.candiesList}" var="candy" >
		<tr>
			<td>${candy.id}</td>
			<td>${candy.type}</td>
			<td>${candy.energy}</td>
			<td>${candy.water}</td>
			<td>${candy.sugar}</td>
			<td>${candy.fructose}</td>
			<td>${candy.chocolateType}</td>
			<td>${candy.vanillin}</td>
			<td>${candy.proteins}</td>
			<td>${candy.fats}</td>
			<td>${candy.carbohydrates}</td>
			<td>${candy.production}</td>
			<td>${candy.filling}</td>
		</tr>
		</c:forEach>
	</table>
</div>

<div class="w3-container w3-light-grey w3-opacity w3-right-align w3-padding"></div>
<div class="w3-container w3-blue-grey w3-opacity w3-right-align w3-padding">
     <button class="w3-btn w3-round-large w3-hover-teal" onclick="location.href='/'">Back to main</button>
</div>

</body>
</html>