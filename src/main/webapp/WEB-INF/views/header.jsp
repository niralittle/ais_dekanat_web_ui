<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 19.04.2016
  Time: 1:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div id="header" style="align-content: center;">
  <div class="navbar-header">
    <a href="/user/userhome"><img id="logo" alt="brand" src="../../../resources/img/logo.png"
                                  style="width: 305px; height:65px; margin-top:11px;"></a>
  </div>
    <ul class="nav nav-pills list-inline">
      <li><a href="index"><spring:message code="menu.index"/></a></li>
      <li class="dropdown nav-pill"><a id="toplink" class="dropdown-toggle" data-toggle="dropdown" href="#">
        <spring:message code="menu.admin"/>
        <b class="caret"></b>
      </a>
        <ul class="dropdown-menu">
          <li><a href="#"><spring:message code="menu.cathedra"/></a></li>
          <li><a href="departments"><spring:message code="menu.fuck"/></a></li>
          <li><a href="#"><spring:message code="menu.rooms"/></a></li>
        </ul>
      </li class="dropdown">
      <li class="dropdown"><a id="toplink" class="dropdown-toggle" data-toggle="dropdown" href="#">
        <spring:message code="menu.people"/>
        <b class="caret"></b>
      </a>
        <ul class="dropdown-menu">
          <li><a href="student/home"><spring:message code="menu.student"/></a></li>
          <li><a href="#"><spring:message code="menu.professor"/></a></li>
        </ul>
      </li>
      <li class="dropdown"><a id="toplink" class="dropdown-toggle" data-toggle="dropdown" href="#">
        <spring:message code="menu.study"/>
        <b class="caret"></b>
      </a>
        <ul class="dropdown-menu">
          <li><a href="#"><spring:message code="menu.courses"/></a></li>
        </ul>

      </li>

      <form class="navbar-form navbar-right" role="form">
        <div class="form-group">
          <input type="text" placeholder="<spring:message code="login.email"/>" class="form-control">
        </div>
        <div class="form-group">
          <input type="password" placeholder="<spring:message code="login.password"/>" class="form-control">
        </div>
        <button type="submit" class="btn btn-default"><spring:message code="login.login"/></button>
      </form>
    </ul>
</div>