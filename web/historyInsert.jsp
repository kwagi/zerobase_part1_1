<%@ page import="dbTool.Dto" %>
<%@ page import="dbTool.Dao" %>
<%@ page import="apiTool.ApiParsing" %>
<%@ page import="calculate.Distance" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    Dto dto = new Dto();
    Dao dao = new Dao();

    request.setCharacterEncoding("utf-8");
    dto.setLat(request.getParameter("LAT"));
    dto.setLnt(request.getParameter("LNT"));
    dao.insert(dto);
    ApiParsing apiParsing = new ApiParsing();
    Distance distance = new Distance(request.getParameter("LNT"), request.getParameter("LAT"));//지금까지 반대로 알았음
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
<body>
<h1>와이파이 정보 구하기</h1>

<a href="/">홈</a>&nbsp;|
<a href="history.jsp">위치 히스토리 목록</a>&nbsp;|
<a href="loadApi.jsp">와이파이 정보 가져오기</a>

<table>
    <thead>
    <tr bgcolor="#1AC771">
        <th>거리(km)</th>
        <th>관리번호</th>
        <th>자치구</th>
        <th>와이파이명</th>
        <th>도로명주소</th>
        <th>상세주소</th>
        <th>설치위치(층)</th>
        <th>설치유형</th>
        <th>설치기관</th>
        <th>서비스구분</th>
        <th>망종류</th>
        <th>설치년도</th>
        <th>실내외구분</th>
        <th>접속환경</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>작업일자</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (int i = 0; i < distance.resultKey.length; i++) {
    %>
    <tr>
        <th><%=String.format("%.5f", distance.distanceMap.get(distance.resultKey[i]))%>
        </th>
        <th><%=distance.resultKey[i]%>
        </th>
        <th><%=apiParsing.X_SWIFI_WRDOFC_Map.get(distance.resultKey[i])%>
        </th>
        <th><%=apiParsing.X_SWIFI_MAIN_NM_Map.get(distance.resultKey[i])%>
        </th>
        <th><%=apiParsing.X_SWIFI_ADRES1_Map.get(distance.resultKey[i])%>
        </th>
        <th><%=apiParsing.X_SWIFI_ADRES2_Map.get(distance.resultKey[i])%>
        </th>
        <th><%=apiParsing.X_SWIFI_INSTL_FLOOR_Map.get(distance.resultKey[i])%>
        </th>
        <th><%=apiParsing.X_SWIFI_INSTL_TY_Map.get(distance.resultKey[i])%>
        </th>
        <th><%=apiParsing.X_SWIFI_INSTL_MBY_Map.get(distance.resultKey[i])%>
        </th>
        <th><%=apiParsing.X_SWIFI_SVC_SE_Map.get(distance.resultKey[i])%>
        </th>
        <th><%=apiParsing.X_SWIFI_CMCWR_Map.get(distance.resultKey[i])%>
        </th>
        <th><%=apiParsing.X_SWIFI_CNSTC_YEAR_Map.get(distance.resultKey[i])%>
        </th>
        <th><%=apiParsing.X_SWIFI_INOUT_DOOR_Map.get(distance.resultKey[i])%>
        </th>
        <th><%=apiParsing.X_SWIFI_REMARS3_Map.get(distance.resultKey[i])%>
        </th>
        <th><%=apiParsing.Lat_Map.get(distance.resultKey[i])%>
        </th>
        <th><%=apiParsing.Lnt_Map.get(distance.resultKey[i])%>
        </th>
        <th><%=apiParsing.WORK_DTTM_Map.get(distance.resultKey[i])%>
        </th>
            <%
            }
    %>
    </tbody>
</table>
</body>
</html>