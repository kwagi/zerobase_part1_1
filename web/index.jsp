<%@ page contentType="text/html;charset=UTF-8" %>
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

<form action="historyInsert.jsp" method="post">
    LAT:<input type="text" name="LAT">
    LNT:<input type="text" name="LNT">
    <input type="submit" value="근처 WIFI 정보 보기">
</form>

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
    <td colspan="100" style="text-align: center">
        위치 정보를 입력한 후에 조회해 주세요.
    </td>
    </tbody>
</table>
</body>
</html>