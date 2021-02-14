<%--
  Created by IntelliJ IDEA.
  User: parallels
  Date: 21. 2. 13.
  Time: 오전 6:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"
isELIgnored="false" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" />
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입 창</title>
</head>
<body>
<form method="post" action="${ contextPath }/member/addMember.do">
    <h1 style="text-align: center">회원가입창</h1>
    <table align="center">
        <tr>
            <td width="200">
                <p align="right">아이디</p>
            </td>
            <td width="400"><input type="text" name="id"></td>
        </tr>
        <tr>
            <td width="200">
                <p align="right">비밀번호</p>
            </td>
            <td width="400"><input type="password" name="pwd"></td>
        </tr>
        <tr>
            <td width="200">
                <p align="right">이름</p>
            </td>
            <td width="400"><input type="text" name="name"></td>
        </tr>
        <tr>
            <td width="200">
                <p align="right">이메일</p>
            </td>
            <td width="400"><input type="text" name="email"></td>
        </tr>
        <tr>
            <td width="200">
                <p>&nbsp;</p>
            </td>
            <td width="400">
                <input type="submit" value="가입하기">
                <input type="reset" value="다시 입력">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
