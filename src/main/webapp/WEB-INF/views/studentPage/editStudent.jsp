<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="../../../resources/img/favicon.ico" rel="shortcut icon" type="image/vnd.microsoft.icon"/>
    <link rel="stylesheet" href="../../../resources/css/bootstrap.css">
    <link rel="stylesheet" href="../../../resources/css/main.css" type="text/css" media="screen"/>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="../../../resources/js/jquery-1.11.3.js"></script>
    <script src="../../../resources/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function() {
            if($("*[name='title_error']").css('color') == 'rgb(255, 0, 0)') {
                $('#title').css('border-color', 'rgb(255, 0, 0)');
            }
            if($("*[name='workplace_access_num_errors']").css('color') == 'rgb(255, 0, 0)') {
                $('#sel1').css('border-color', 'rgb(255, 0, 0)');
                $('#sel2').css('border-color', 'rgb(255, 0, 0)');
            }
            showTooltip($('#title'), '<spring:message code="help.title"/>');
        });
        function showTooltip (el, text) {
            if ($("*[name!='auditorium_errors'][class='input-error-notif']").css('border-color') != 'rgb(255, 0, 0)') {
                el.tooltip({title: "" + text + "", placement: "right", trigger: "focus", animation: "true", delay: {show: 100}});
            }
        }
        function getUniversityGroup() {
            $.ajax({
                url: '/student/groups',
                type: 'GET',
                data: {
                    id: $("#sel1").val()
                },
                success: function (data) {
                    $('#sel2').html('');// to clear the previous option
                    $('#res').html(data);
                    $.each(data, function (i, university) {
                        $('#sel2').append($('<option>').text(university.name));
                    });
                }
            });
        }
    </script>

</head>
<body>

<div id="wrap">

    <nav id="header">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="/user/userhome"><img id="logo" alt="brand" src="../../../resources/img/logo.png"></a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a class="menu-element" href="/user/userhome"> </a></li>
                    <li><a id="editProfile" class="menu-element" href="/user/editProfile"></a></li>
                    <li><a class="menu-element" href="/logout"></a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="col-md-offset-4 col-md-8 vertalign bottom-block">
        <form:form class="form-horizontal" id="editStudent" action="/student/edit/save" method="post"
                   commandName="editStudent">
            <div class="form-group">
                <div class="col-md-6">
                    <input type="text" class="form-control form-style" id="title" value="${fullname}" name="fullName"
                           placeholder="<spring:message
                            code="student.name"/>" path="fullName">
                </div>
                <div class="col-md-offset-6"><form:errors path="fullName" id="title.errors" name="title_error"
                                                          cssClass="input-error-notif" element="div"/></div>

            </div>
              <p>${groupName}</p>
            <div class="form-group">
                <div class="col-md-3">
                    <label class="label-style" for="sel1"><spring:message
                            code="student.course"/>:</label>
                    <select name="courseNumber" class="form-control select-style" id="sel1" path="courseNumber"
                            onchange="getUniversityGroup()">
                        <option value="${course}" selected>${course}</option>
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
                        <option value="${groupName}" selected>${groupName}</option>

                    </select>
                </div>

            </div>
            <input type="hidden" name="id" value="${id}"/>

            <div class="form-group">
                <div class="col-md-6">
                    <button id="btn-create-order" type="submit" class="btn btn-primary btn-block">Create</button>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6">

                </div>
            </div>
        </form:form>
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