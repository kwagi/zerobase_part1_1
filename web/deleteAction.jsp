<%@ page import="dbTool.Dao" %>
<%
    Dao dao = new Dao();
    dao.delete();
    response.sendRedirect("index.jsp");
%>