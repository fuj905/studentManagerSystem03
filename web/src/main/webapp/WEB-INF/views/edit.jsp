<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fujia
  Date: 2016/3/21
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*"%>
<html>
<head>
    <title>信息修改</title>
</head>
<body>
<%>
  String id=request.getParameter("id");
</%>
<form id="form1" name="form1" method="post" action="update.jsp?id= (" id")">
  <td>学号&nbsp&nbsp： <input name="student_num" type="text" id="student_num" <c:out value="${row.id}"></c:out> size="25" /></td><p>
  <td>姓名&nbsp&nbsp： <input name="name" type="text" id="name" <c:out value="${row.id}"></c:out> size="25" /></td><p>
  <td>性别： <input name="sex" type="text" id="sex" <c:out value="${row.id}"></c:out>size="25" /></td><p>
  <td>年级&nbsp&nbsp： <input name="grade" type="text" id="grade" <c:out value="${row.id}"></c:out> size="25" /></td><p>
  <td>班级&nbsp&nbsp： <input name="class_num" type="text" id="class_num" <c:out value="${row.id}"></c:out> size="25" /></td><p>
  <td>学院： <input name="college" type="text" id="college" <c:out value="${row.id}"></c:out> size="25" /></td><p>
  <td>生日&nbsp&nbsp： <input name="birthday" type="text" id="birthday" <c:out value="${row.id}"></c:out> size="25" /></td><p>
  <td>是否好学生&nbsp&nbsp(1=YES&0=NO)： <input name="is_good_student" type="text" id="is_good_student" <c:out value="${row.id}"></c:out> size="25" /></td><p>
  <p>
  <p>
    <label>
      <input type="submit" name="Submit" value="更新" />
    </label>
  </p>
</form>
</body>
</html>
