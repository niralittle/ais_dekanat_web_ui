<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <title><spring:message code="cathedra.create"/></title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <link href="../../../resources/img/favicon.ico" rel="shortcut icon" type="image/vnd.microsoft.icon"/>
  <link rel="stylesheet" href="../../../resources/css/bootstrap.css">
  <link rel="stylesheet" href="../../../resources/css/main.css" type="text/css" media="screen"/>

  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  <script src="../../../resources/js/jquery-1.11.3.js"></script>
  <script src="../../../resources/js/bootstrap.min.js"></script>

</head>
<body>

<div id="wrap">

  <jsp:include page="header.jsp"/>

  <div class="col-md-offset-4 col-md-8 vertalign bottom-block">

    <form:form class="form-horizontal" id="newCathedra" action="/editCathedra/${editCathedra.cathedraId}"  method="post">
      <div class="form-group">
        <div class="col-md-6">
          <input type="text" class="form-control form-style" id="name" name="name" value="${editCathedra.name}" placeholder="<spring:message code="cathedra.name"/>">
        </div>
      </div>
      <div class="col-md-6">
        <label class="label-style" for="sel2"><spring:message code="cathedra.department"/>:</label>
        </br>
        <select name="departmentId" class="form-control select-style" id="sel2"
                path="departmentId">
          <c:forEach items="${departments}" var="department" varStatus="count">
            <option
                    <c:if test="${editCathedra.department.departmentId == department.departmentId}"> selected </c:if>
                    value="${department.departmentId}">
                ${department.name}
            </option>
          </c:forEach>
        </select>
      </div>
</br>
      <div class="form-group">
        <div class="col-md-6">
          <button id="btn-create-order" type="submit" class="btn btn-primary btn-block" style="margin-right: 15px;"><spring:message code="cathedra.edit"/></button>
        </div>
      </div>

    </form:form>
  </div>

  <jsp:include page="footer.jsp"/>
</div>
</body>
</html>