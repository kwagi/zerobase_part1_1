<%@ page import="apiTool.WriteApi" %>
<%@ page import="apiTool.ApiParsing" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    WriteApi writeApi = new WriteApi();
    ApiParsing apiParsing = new ApiParsing();
%>


<body style="text-align: center">

<h1><%=apiParsing.list_total_count%>개의 와이파이 정보를 가져왔습니다<br></h1>
<h3><%=apiParsing.MESSAGE%>
</h3>
<h3>CODE:<%=apiParsing.CODE%>
</h3>
<h4><a href="/">홈으로 돌아가기</a></h4>
