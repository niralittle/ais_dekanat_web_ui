<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: nira
  Date: 24.04.16
  Time: 14:53
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Екзамени для групи</title>
    <link href="../../resources/img/favicon.ico" rel="shortcut icon" type="image/vnd.microsoft.icon"/>
    <link rel="stylesheet" href="../../resources/css/bootstrap.css">
    <link rel="stylesheet" href="../../resources/css/main.css" type="text/css" media="screen"/>

    <script src="../../resources/js/jquery-1.11.3.js"></script>
    <script src="../../resources/js/bootstrap.min.js"></script>
</head>
<body>
<div id="wrap">
    <jsp:include page="header.jsp"/>
    <div class="center-block top-block">
        <br/>
        <br/>
        <br/>
        <h2>Переглянути розклад іспитів для групи:</h2>
        <br/>
        <div id="selectByGroupForm">
            <form>
                <fieldset>
                    <label for="deptId">Факультет:</label> <br/>
                    <select id="deptId" class="span3" onchange="getUniversityGroups()">
                    <c:forEach items="${departments}" var="dept">
                        <option value=" <c:out value="${dept.id}"/>">
                            <c:out value="${dept.name}"/>
                        </option>
                    </c:forEach>
                    </select> <br/>
                    <label for="yearId">Рік навчання:</label> <br/>
                    <select id="yearId" class="span1" onchange="getUniversityGroups()">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select> <br/>
                    <label for="groupId" class="span2">Група:</label> <br/>
                    <select id="groupId" onchange="redirectToExamsDisplayPage()"></select> <br/>
                    <input id="go" type="submit" class="btn" value="Переглянути" formaction=""/> <br/>
                </fieldset>
            </form>
        </div>
    </div>
</div>
        <script type="text/javascript">
            var selectedDeptId = -1;
            var selectedYear = -1;

            window.onload = function() {
                $.ajax({
                    url: '${pageContext.request.contextPath}/departments/all',
                    type: 'GET',
                    dataType: 'json',
                    async: true,
                    success: function (depts) {
                        var options = '';
                        for (var i in depts) {
                            options += '\<option value=\"' + depts[i].departmentId + '\"\>' + depts[i].name + '\<\/option\>';
                        }
                        document.getElementById("deptId").innerHTML = options;
                    }
                });
                getUniversityGroups();
            };

            var getUniversityGroups = function() {
                selectedDeptId = document.getElementById("deptId").value;
                selectedYear = document.getElementById("yearId").value;
                $.ajax({
                    url: '${pageContext.request.contextPath}/groups/department/' + selectedDeptId + '/year/' + selectedYear,
                    type: 'GET',
                    dataType: 'json',
                    async: true,
                    success: function(groups) {
                        var options = '';
                        for (var i in groups) {
                           options += '\<option value=\"' + groups[i].groupId + '\"\>' + groups[i].name + '\<\/option\>';
                        }
                        document.getElementById("groupId").innerHTML = options;
                    }
                });
            };

            var redirectToExamsDisplayPage = function() {
                var selectedGroupId = document.getElementById("groupId").value;
                var newPath = '${pageContext.request.contextPath}/exams/group/' + selectedGroupId;
                document.getElementById("go").formAction = newPath;
            };
        </script>

        <jsp:include page="footer.jsp"/>
    </div>
</body>
</html>
