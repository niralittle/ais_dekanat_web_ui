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

        <form:form class="form-horizontal" id="newDepartment" action="/createDepartment"  method="post">
      <div class="form-group">

        <div class="col-md-6">
          <input type="text" class="form-control form-style" id="name" name="name" value="${newDepartment.name}" placeholder="<spring:message code="department.name"/>">
        </div>
      </div>
      <div class="form-group">
        <div class="col-md-6">
          <input type="text" class="form-control form-style" id="mainInfo" name="mainInfo" value="${newDepartment.mainInfo}" placeholder="<spring:message code="department.description"/>">
        </div>
      </div>

      <div class="form-group">
        <div class="col-md-6">
          <button id="btn-create-order" type="submit" class="btn btn-primary btn-block"><spring:message code="department.create"/></button>
        </div>
      </div>

    </form:form>
  </div>

  <jsp:include page="footer.jsp"/>
</div>
</body>
</html>