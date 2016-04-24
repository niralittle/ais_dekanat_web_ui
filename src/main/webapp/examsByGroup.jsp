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
    <title>Exams by group</title>
    <script src="resources/js/jquery-1.11.3.js"></script>
</head>
<body>

<div id="selectByGroup">
    <form:form action="examsByGroup" method="POST"  commandName="groupForm">
        <h1 id="test"></h1>
        <h1 id="error" style="color: red"></h1>
        <table border="0">
            <h2>Переглянути розклад іспитів для групи:</h2>
            <tr>
                <td>Факультет:</td>
                <td>
                <select id="deptId" onchange="getUniversityGroups()">
                <c:forEach items="${departments}" var="dept">
                    <option value=" <c:out value="${dept.id}"/>">
                        <c:out value="${dept.name}"/>
                    </option>
                </c:forEach>
                </select>
                </td>
            </tr>
            <tr>
                <td>Рік навчання:</td>
                <td>
                    <select id="yearId" onchange="getUniversityGroups()">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td>Група:</td>
                    <td>
                <select id="groupId"></select>
            </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Переглянути" />
                </td>
            </tr>
        </table>
    </form:form>
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
                document.getElementById("test").innerHTML = depts;
                var options = '';
                for (var i in depts) {
                    options += '\<option value=\"' + depts[i].departmentId + '\"\>' + depts[i].name + '\<\/option\>';
                }
                document.getElementById("deptId").innerHTML = options;
            },
            error: function(jqXHR, textStatus, errorThrown) {
                document.getElementById("error").innerHTML = (jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
        getUniversityGroups();
    };

    var getUniversityGroups = function() {
        document.getElementById("test").innerHTML = '';
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
            },
            error: function(jqXHR, textStatus, errorThrown) {
                document.getElementById("error").innerHTML = (jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }
</script>

</body>
</html>
