<%@ page import="com.kma.ais_dekanat.model.FinalTest" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: nira
  Date: 24.04.16
  Time: 21:58
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exams</title>
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

<%
    Object value = request.getSession().getAttribute("exams");

    if (value == null) {
        request.getRequestDispatcher("examsByProfessor.jsp").forward(request, response);
    }

    Map<Integer, List<FinalTest>[]> schedule = (Map<Integer, List<FinalTest>[]>) value;
%>
            <table border="1" width="95%" class="table table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Понеділок</th>
                        <th>Вівторок</th>
                        <th>Середа</th>
                        <th>Четвер</th>
                        <th>П’ятниця</th>
                        <th>Субота</th>
                        <th>Неділя</th>
                    </tr>
                </thead>
                <%
                    for (List<FinalTest>[] week: schedule.values()) {
                %>
                <tr>
                <%
                        for (List<FinalTest> day: week) {
                %>
                    <td>
                        <%
                            if (!day.isEmpty()) {
                        %>
                        <h2 align="center">
                        <%= day.get(0).prepTime().getDayOfMonth() + " " + getMonth(day.get(0).prepTime().getMonthOfYear()) %>
                        </h2>
                        <%
                                for (FinalTest exam: day) {
                        %>
                        <hr/>
                        <p>
                            &emsp; <%= exam.prepTime().getHourOfDay() + ":" + fixZero(exam.prepTime().getMinuteOfHour()) %> <br/>
                            &emsp; <b><%= exam.getSubject().getName() %> </b> <br/>
                            &emsp; ауд. <%= exam.getRoom().getName() %> <br/>
                            &emsp; <%= exam.getGroup().getName() %>  <br/>
                        </p>
                        <%
                                }
                            }
                        %>
                    </td>
                        <%
                        }
                    }
                %>
            </table>
        </div>
        <jsp:include page="footer.jsp"/>
    </div>
</body>
</html>

<%!
    private String fixZero(int minuteOfHour) {
        return minuteOfHour == 0 ? "00" : minuteOfHour + "";
    }

    private String getMonth(int month) {
        switch (month) {
            case 1: return "Січня";
            case 2: return "Лютого";
            case 3: return "Березня";
            case 4: return "Квітня";
            case 5: return "Травня";
            case 6: return "Червня";
            case 7: return "Липня";
            case 8: return "Серпня";
            case 9: return "Вересня";
            case 10: return "Жовтня";
            case 11: return "Листопада";
            default: return "Груденя";
        }
    }
%>

