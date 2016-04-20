<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 19.04.2016
  Time: 2:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="attachments.jsp"/>
<jsp:include page="header.jsp"/>

<head>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="../resources/main.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<div id="content" class="container" style="padding: 5%; background-color: #CED8F6;">
  <div id="info" style="text-align: center; max-width: 400px; margin: auto;">
    <c:if test="${ditDepartment!=null}">
      <form class="form-vertical" role="form" name='departmentform'
            action="/editDepartment/${editDepartment.id}" method='POST' id="formCreateDepartment">
    </c:if>
      <c:if test="${ditDepartment==null}">
      <form class="form-vertical" role="form" name='departmentform'
            action="/createDepartment" method='POST' id="formCreateDepartment">
        </c:if>
        <div class="form-group">
          <input id="name" class="form-control" type="text" placeholder="Назва  <c:if test="${editDepartment!=null}">${editDepartment.name}</c:if>" />
          <textarea id="mainInfo" rows="3" class="form-control" placeholder="Опис  <c:if test="${editDepartment!=null}">${editDepartment.mainInfo}</c:if> " required ></textarea>
          <input type="submit" class="btn btn-primary" value="Створити">
        </div>
    </form>
  </div>
  <table id="departmentTable" class="table">
    <thead>
    <tr>
      <th>Назва</th>
      <th>Опис</th>
      <th>Редагувати</th>
      <th>Видалити</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${departments}" var="department">
      <tr>
        <td>${department.name}</td>
        <td>${department.mainInfo}</td>
        <td>
            <button class="btn btn-sm btn-info" onclick="editDepartment(${department.departmentId})"><i
                    class="glyphicon glyphicon-pencil"></i> Редагувати </button>
        </td>
        <td>
            <button class="btn btn-sm btn-danger" onclick="deleteDepartment(${department.departmentId})"><i
                    class="glyphicon glyphicon-remove"></i> Видалити </button>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<jsp:include page="footer.jsp"/>
</body>
<script>
  function editDepartment(departmentId){
    window.location.replace("<c:url value='/editDepartment/" + departmentId+ "'/>");
  }
  function deleteDepartment(departmentId){
    window.location.replace("<c:url value='/deleteDepartment/" + departmentId+ "'/>");
  }
</script>
</html>
