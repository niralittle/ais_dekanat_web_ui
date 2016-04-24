<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <title><spring:message code="department.create"/></title>
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

      <%--<c:if test="${editDepartment}!=null">--%>
        <%--<form:form class="form-horizontal" id="newDepartment" action="/editDepartment/${editDepartment.departmentId}"  method="post">--%>
      <%--</c:if>--%>
      <%--<c:if test="${editDepartment}==null">--%>
        <form:form class="form-horizontal" id="newDepartment" action="/createDepartment"  method="post">
      <%--</c:if>--%>
      <div class="form-group">
        <div class="col-md-6">
          <input type="text" class="form-control form-style" id="name" value="${editDepartment.name}"
                 placeholder="<spring:message
                            code="department.name"/>">
        </div>
      </div>
      <div class="form-group">
        <div class="col-md-6">
          <input type="text" class="form-control form-style" id="mainInfo" value="${editDepartment.mainInfo}"
                 placeholder="<spring:message
                            code="department.description"/>">
        </div>
      </div>
      <div class="form-group">
        <div class="col-md-3">
          <label class="label-style" for="sel1"><spring:message
                  code="student.course"/>:</label>
          <select name="courseNumber" class="form-control select-style" id="sel1" path="courseNumber"
                  onchange="getUniversityGroup()">
            <option value="" disabled selected></option>
            <c:forEach items="${universityGroups}" var="item" varStatus="count">
              <option value="${item.course}">${item.course}</option>
            </c:forEach>
          </select>
        </div>
        <div class="col-md-3">
          <label class="label-style" for="sel2"><spring:message
                  code="student.department"/>:</label>
          <select name="department" class="form-control select-style" id="sel2"
                  path="department">
            <option value="" disabled selected></option>
          </select>
        </div>

      </div>

      <div class="form-group">
        <div class="col-md-6">
          <button id="btn-create-order" type="submit" class="btn btn-primary btn-block"><spring:message code="department.edit"/></button>
        </div>
      </div>
      <div class="form-group">
        <div class="col-md-6">

        </div>
      </div>
    </form:form>
  </div>

  <jsp:include page="footer.jsp"/>
</div>
</body>
</html>