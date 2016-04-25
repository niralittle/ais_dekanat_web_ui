<%--
  User: nira
  Date: 25.04.16
  Time: 2:11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Екзамени для викладача</title>
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
        <h1>Переглянути розклад іспитів за викладачем</h1>
        <br/>
        <form>
             <fieldset>
                <label for="deptId">Факультет:</label> <br/>
                <select id="deptId" class="span3" onchange="getCathedrasOfDepartment()">
                    <c:forEach items="${departments}" var="dept">
                        <option value=" <c:out value="${dept.id}"/>">
                            <c:out value="${dept.name}"/>
                        </option>
                    </c:forEach>
                </select> <br/>
                <label for="cathedraId">Кафедра:</label> <br/>
                <select id="cathedraId" class="span2" onchange="getProfessorsByCathedra()"></select> <br/>
                <label for="professorId">Викладач:</label> <br/>
                <select id="professorId" class="span3"></select> <br/>
                <input type="submit" id="go" value="Переглянути" class="btn" onclick="redirectToExamsDisplayPage()"/> <br/>
             </fieldset>
        </form>
    </div>
    <h1 id="err" style="color: red"></h1>
</div>
<script type="text/javascript">

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
        getCathedrasOfDepartment();
        getProfessorsByCathedra();
    };

    var getProfessorsByCathedra = function() {
        var selectedCathedraID = document.getElementById("cathedraId").value;
        $.ajax({
            url: '${pageContext.request.contextPath}/professors/cathedra/' + selectedCathedraID,
            type: 'GET',
            dataType: 'json',
            async: true,
            success: function(professors) {
                var options = '';
                for (var i in professors) {
                    options += '\<option value=\"' + professors[i].professorId + '\"\>' + professors[i].fullName + '\<\/option\>';
                }
                document.getElementById("professorId").innerHTML = options;
            }
        });
    };

    var getCathedrasOfDepartment = function() {
        var selectedDeptId = document.getElementById("deptId").value;
        $.ajax({
            url: '${pageContext.request.contextPath}/cathedras/department/' + selectedDeptId,
            type: 'GET',
            dataType: 'json',
            async: true,
            success: function (cathedras) {
                var options = '';
                for (var i in cathedras) {
                    options += '\<option value=\"' + cathedras[i].cathedraId + '\"\>' + cathedras[i].name + '\<\/option\>';
                }
                document.getElementById("cathedraId").innerHTML = options;
            }
        });
        getProfessorsByCathedra();
    };

    var redirectToExamsDisplayPage = function() {
        var selectedProfessorId = document.getElementById("professorId").value;
        var newPath = "${pageContext.request.contextPath}/exams/professor/" + selectedProfessorId;
        document.getElementById("err").innerHTML = newPath;
//        window.location = newPath;
        document.getElementById("go").formAction = newPath;

    };
</script>

<jsp:include page="footer.jsp"/>

</body>
</html>
