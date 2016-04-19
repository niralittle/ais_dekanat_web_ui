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

<div id="content" class="container">
  <div id="info">
    <c:if test="${editDepartment}!=null">
      <form class="form-vertical" role="form" name='departmentform'
            action="editDepartment/${editDepartment.id}" method='POST' id="formCreateDepartment">
    </c:if>
      <c:if test="${editDepartment}!=null">
      <form class="form-vertical" role="form" name='departmentform'
            action="createDepartment" method='POST' id="formCreateDepartment">
        </c:if>
        <div class="form-group">
          <input id="name" class="form-control" type="text" placeholder="Назва  <c:if test="${editDepartment}!=null">${editDepartment.name}</c:if>">
          <textarea id="mainInfo" rows="3" class="form-control" placeholder="Опис  <c:if test="${editDepartment}!=null">${editDepartment.mainInfo}</c:if>" required/>
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
            <button class="btn btn-sm btn-info" onclick="editDepartment(${department.id})"><i
                    class="glyphicon glyphicon-pencil"></i> Редагувати </button>
        </td>
        <td>
            <button class="btn btn-sm btn-danger" onclick="deleteDepartment(${department.id})"><i
                    class="glyphicon glyphicon-remove"></i> Видалити </button>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<div class="modal-body" align="center">
  <form id="conf" name="conf" action="" method="POST">
    <button type="submit" class="btn btn-sm btn-info">Так</button>
  </form>
</div>
<jsp:include page="footer.jsp"/>
<script>
  function editDepartment(departmentId){
    document.getElementById("conf").action = "<c:url value='/editDepartment/" + departmentId+ "'/>";
    document.getElementById("conf").method='POST';
  }
  function deleteDepartment(departmentId){
    document.getElementById("conf").action = "<c:url value='/deleteDepartment/" + departmentId+ "'/>";
    document.getElementById("conf").method='POST';
  }
</script>
</html>
