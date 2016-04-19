<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fujia
  Date: 2016/4/6
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息展示</title>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="0">
    ${message}
    <form method="post" action="${website}/student/liststudent">
        <tr>
            <td>序号</td>
            <td>id&nbsp&nbsp</td>
            <td>学号&nbsp&nbsp</td>
            <td>姓名&nbsp&nbsp</td>
            <td>性别&nbsp&nbsp</td>
            <td>年级&nbsp&nbsp</td>
            <td>班级&nbsp&nbsp</td>
            <td>学院&nbsp&nbsp</td>
            <td>生日&nbsp&nbsp</td>
            <td>是否好学生&nbsp&nbsp(1=YES&0=NO)</td>
            <td>删除&nbsp&nbsp</td>
            <td>编辑&nbsp&nbsp</td>
        </tr>
        <tr>
            <c:forEach items="${studentList}" var="student" varStatus="status">
                <td>${status.index+1}</td>
                <td>${student.id}</td>
                <td>${student.studentNum}</td>
                <td>${student.name}</td>
                <td>${student.sex}</td>
                <td>${student.grade}</td>
                <td>${status.classNum}</td>
                <td>${student.college}</td>
                <td>${student.birthday}</td>
                <td>${status.goodStudent}</td>
                <td><a href="${website}student/update/${student.id}">删除</a></td>
                <td><a href="${website}student/update/${student.id}">删除</a></td>
            </c:forEach>
        </tr>
    </form>
    </table>
</body>
</html>
