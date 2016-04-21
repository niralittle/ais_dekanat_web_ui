<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 19.04.2016
  Time: 1:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="header" class="navbar navbar-fixed-top" role="navigation" style="background-color: #8bb0f6;">
  <div class="container">
    <ul class="nav nav-pills list-inline">
      <li><a href="index">Головна</a></li>
      <li class="dropdown nav-pill"><a id="toplink" class="dropdown-toggle" data-toggle="dropdown" href="#">
        Адміністративна частина
        <b class="caret"></b>
      </a>
        <ul class="dropdown-menu">
          <li><a href="#">Кафедри</a></li>
          <li><a href="departments">Факультети</a></li>
          <li><a href="#">Аудиторії</a></li>
        </ul>
      </li class="dropdown">
      <li class="dropdown"><a id="toplink" class="dropdown-toggle" data-toggle="dropdown" href="#">
        Люди
        <b class="caret"></b>
      </a>
        <ul class="dropdown-menu">
          <li><a href="#">Викладачі</a></li>
          <li><a href="#">Студенти</a></li>
        </ul>
      </li>
      <li class="dropdown"><a id="toplink" class="dropdown-toggle" data-toggle="dropdown" href="#">
        Навчання
        <b class="caret"></b>
      </a>
        <ul class="dropdown-menu">
          <li><a href="#">Курси</a></li>
        </ul>

      </li>

      <form class="navbar-form navbar-right" role="form">
        <div class="form-group">
          <input type="text" placeholder="Email" class="form-control">
        </div>
        <div class="form-group">
          <input type="password" placeholder="Password" class="form-control">
        </div>
        <button type="submit" class="btn btn-default">Вхід</button>
      </form>
    </ul>
  </div>
</div>