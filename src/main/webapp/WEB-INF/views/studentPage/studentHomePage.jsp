<%--
  Created by IntelliJ IDEA.
  User: viktor
  Date: 19.04.16
  Time: 00:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Student</title>
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

        $.ajax({
            url: '${pageContext.request.contextPath}/student/allStudents',
            type: 'GET',
            success: function (response) {
                var trHTML = '';
                $.each(response, function (i, student) {
                    trHTML += "<tr>" +
                            "<td>" + student.studentId + "</td>" +
                            "<td class='title-col-user'>" + student.fullName + "</td>" +
                            "<td>" + student.group.course + "</td>" +
                            "<td>" + student.group.groupId + "</td>" +
                            "<td>" + student.group.name + "</td>" +
                            "<td class='btn-col'>" + '<form action="/student${pageContext.request.contextPath}/edit/' + student.studentId + '"><button class="icon-btn btn btn-primary btn-block" type="submit"><span class="glyphicon glyphicon-pencil icon" aria-hidden="true"></span></button></form>' + "</td>" +
                            "<td class='btn-col'>" + '<form action="/student${pageContext.request.contextPath}/delete/' + student.studentId + '"><button class="icon-btn btn btn-primary btn-block" type="submit"><span class="glyphicon glyphicon-remove icon" aria-hidden="true"></span></button></form>' + "</td>" +
                            "</tr>";

                });
                $('#records_table tbody').empty();
                $('#records_table').append(trHTML);
            }
        });
    </script>
</head>

<body>

<div id="wrap">
    <nav id="header">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="/user/userhome"><img id="logo" alt="brand" src="../../../resources/img/logo.png"
                                              style="width: 305px; height:65px; margin-top:11px;"></a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a class="menu-element" href="/user/userhome"></a></li>
                    <li><a id="editProfile" class="menu-element" href="/user/editProfile"></a></li>
                    <li><a class="menu-element" href="/logout"></a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="col-md-offset-7 top-block">
        <form id="add-order-form" class="form-horizontal" method="get" action="/user/createOrder">
            <div class="col-md-offset-7 col-md-4">
                <button id="Adm_Button" type="submit" class="btn btn-primary btn-block"></button>
            </div>
        </form>
    </div>
    <div class="table-align bottom-block">
        <table id="records_table" class="tbl table table-striped user-table order-table">
            <thead>
            <tr>
                <th class="title-col"><spring:message code="student.id"/><img class="icon-sort"
                                             src="../../../resources/img/sort15.png"
                                             width="8px" height="14px">
                </th>
                <th class="title-col"><spring:message code="student.student"/><img class="icon-sort"
                                                src="../../../resources/img/sort15.png"
                                                width="8px"
                                                height="14px"></th>
                <th class="title-col"><spring:message code="student.course"/><img class="icon-sort"
                                               src="../../../resources/img/sort15.png"
                                               width="8px" height="14px">
                </th>
                <th class="title-col"><spring:message code="student.group"/><img class="icon-sort"
                                            src="../../../resources/img/sort15.png"
                                            width="8px" height="14px"></th>
                <th class="title-col"><spring:message code="student.department"/><img class="icon-sort"
                                          src="../../../resources/img/sort15.png"
                                          width="8px" height="14px"></th>
                <th class="btn-col"></th>
                <th class="btn-col"></th>
            </tr>
            </thead>
        </table>
    </div>
    <div id="footer">
        <div class="thick"></div>
        <div class="thin"></div>
        <div><p class="footertext"><spring:message code="login.footer"/></p></div>
        <div id="localization">
            <a href="?lang=en" class="language"><spring:message code="language.en"/></a>
            <a href="?lang=ua" class="language"><spring:message code="language.ua"/></a>
        </div>
    </div>
</div>
</body>
</html>