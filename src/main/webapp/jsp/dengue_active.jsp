<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of dengue_active</h2></caption>
			<tr>
				<th>aadhar_no</th>
				<th>blood_platelet_count</th>
				<th>blood_pressure_level</th>
				<th>body_temperature</th>
				<th>other_health_problems</th>
				<th>other_symptoms</th>
				<th>urgent_requirement_of_blood</th>
			</tr>
	    <c:forEach var="dengue_active" items="${dengue_actives}">
				<tr>
					<td><c:out value="${dengue_active.aadhar_no}"  /></td>
					<td><c:out value="${dengue_active.blood_platelet_count}"  /></td>
					<td><c:out value="${dengue_active.blood_pressure_level}"  /></td>
					<td><c:out value="${dengue_active.body_temperature}"  /></td>
					<td><c:out value="${dengue_active.other_health_problems}"  /></td>
					<td><c:out value="${dengue_active.other_symptoms}"  /></td>
					<td><c:out value="${dengue_active.urgent_requirement_of_blood}"  /></td>
             </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>
