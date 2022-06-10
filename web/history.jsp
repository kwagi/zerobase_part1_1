<%@ page import="dbTool.Dao" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    Dao dao = new Dao();
    dao.select();
%>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <style>
        table {
            width: 100%;
        }

        th, td {
            border: solid 1px #000;
        }
    </style>
</head>
<form action="deleteAction.jsp" method="post">
    <h1>위치 히스토리 목록</h1>
    <a href="/">홈</a>&nbsp;|
    <a href="history.jsp">위치 히스토리 목록</a>&nbsp;|
    <input type="submit" value="히스토리 목록 비우기">
</form>

<table>
    <thead>
    <tr bgcolor="#1AC771">
        <th>ID</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>조회일자</th>
    </tr>
    </thead>
    <tbody>
    <%
        while (dao.rs.next()) {
    %>
    <tr>
        <th><%=dao.rs.getString("ID")%>
        </th>
        <th><%=dao.rs.getString("LAT")%>
        </th>
        <th><%=dao.rs.getString("LNT")%>
        </th>
        <th><%=dao.rs.getString("CALL_DTTM")%>
        </th>
            <%
            }
            dao.rs.close();
            dao.preparedStatement.close();
            dao.connection.close();
        %>
    </tbody>
</table>
</html>