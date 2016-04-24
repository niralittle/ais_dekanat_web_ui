<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 19.04.2016
  Time: 2:44
  To change this template use File | Settings | File Templates.
--%>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <title><spring:message code="department.title" /></title>
  <link href="../../../resources/img/favicon.ico" rel="shortcut icon" type="image/vnd.microsoft.icon"/>
  <link rel="stylesheet" href="../../../resources/css/bootstrap.css">
  <link rel="stylesheet" href="../../../resources/css/main.css" type="text/css" media="screen"/>
  <script src="../../../resources/js/jquery-1.11.3.js"></script>
  <script src="../../../resources/js/bootstrap.min.js"></script>
  <script src="../../../resources/js/tsort.js"></script>
  <script>

    $(document).ready(function () {
      $("#records_table").tablesort();
    });
  </script>
</head>
<body>
<div id="wrap">
  <jsp:include page="header.jsp"/>

  <div class="col-md-offset-7 top-block">
    <form id="add-order-form" class="form-horizontal" method="get" action="/createDepartment">
      <div class="col-md-offset-7 col-md-4">
        <button id="Adm_Button" type="submit" class="btn btn-primary btn-block"><spring:message code="department.create" /></button>
      </div>
    </form>
  </div>
  <div class="table-align bottom-block">
    <table id="records_table" class="tbl table table-striped user-table order-table">
      <thead>
      <tr>
        <th class="title-col"><spring:message code="department.name" /><img class="icon-sort"
                                                                      src="../../../resources/img/sort15.png"
                                                                      width="8px" height="14px">
        </th>
        <th class="title-col"><spring:message code="department.description" /><img class="icon-sort"
                                                                           src="../../../resources/img/sort15.png"
                                                                           width="8px"
                                                                           height="14px">
        </th>
        <th class="btn-col"></th>
        <th class="btn-col"></th>
      </tr>
      <c:forEach items="${departments}" var="department">
        <tr>
          <td> ${department.name}</td>
          <td> ${department.mainInfo}</td>
          <td class='btn-col'><form action="/editDepartment/${department.departmentId}"><button class="icon-btn btn btn-primary btn-block" type="submit"><span class="glyphicon glyphicon-pencil icon" aria-hidden="true"></span></button></form></td>
          <td class='btn-col'><form action="/deleteDepartment/${department.departmentId}"><button class="icon-btn btn btn-primary btn-block" type="submit"><span class="glyphicon glyphicon-remove icon" aria-hidden="true"></span></button></form></td>
        </tr>
      </c:forEach>
      </thead>
    </table>
  </div>
<jsp:include page="footer.jsp"/>
</div>
</body>
</html>