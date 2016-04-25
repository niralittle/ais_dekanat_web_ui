<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <title><spring:message code="professor.create"/></title>
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

    <form:form class="form-horizontal" id="newProfessor" action="/createProfessor"  method="post">
      <div class="form-group">
        <div class="col-md-4">
          <input type="text" class="form-control form-style" id="fullName" name="fullName" value="${newProfessor.fullName}"
                 placeholder="<spring:message code="professor.name"/>">
        </div>
      </div>
      <div class="form-group">
        <div class="col-md-4">
          <input type="text" class="form-control form-style" id="academicDegree" name="academicDegree" value="${newProfessor.academicDegree}"
                 placeholder="<spring:message code="professor.degree"/>">
        </div>
      </div>
      <div class="col-md-4">
        <label class="label-style" for="sel2"><spring:message code="professor.cathedra"/>:</label>
        <select name="cathedraId" class="form-control select-style" id="sel2"
                path="cathedraId">
          <option value="" disabled selected></option>
          <c:forEach items="${cathedras}" var="cathedra" varStatus="count">
            <option value="${cathedra.cathedraId}">
                ${cathedra.name}
            </option>
          </c:forEach>
        </select>
      </div>

      <div class="form-group">
        <div class="col-md-4">
          <button id="btn-create-order" type="submit" class="btn btn-primary btn-block"><spring:message code="professor.create"/></button>
        </div>
      </div>

    </form:form>
  </div>
  <jsp:include page="footer.jsp"/>
</div>
</body>
</html>