<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
  <title>UserData</title>

  <style type="text/css">
    .tg {
      border-collapse: collapse;
      border-spacing: 0;
      border-color: #ccc;
    }

    .tg td {
      font-family: Arial, sans-serif;
      font-size: 14px;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #fff;
    }

    .tg th {
      font-family: Arial, sans-serif;
      font-size: 14px;
      font-weight: normal;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #f0f0f0;
    }

  </style>

</head>
<body>

<br/>
<a href="<c:url value="/users"/>">Back to Users List</a>
&nbsp;
<a href="../../index.jsp">Back to main menu</a>
<br/>

<h1>User Details</h1>

<table class="tg">
  <tr>
    <th width="40">ID</th>
    <th width="160">Name</th>
    <th width="30">Age</th>
    <th width="40">IsAdmin</th>
    <th width="80">CreateDate</th>
    <th width="30">Edit</th>
    <th width="40">Delete</th>
  </tr>
  <tr>
    <td>${user.id}</td>
    <td>${user.name}</td>
    <td>${user.age}</td>
    <td>${user.isAdmin}</td>
    <td>${user.createDate}</td>
    <td><a href="<c:url value='/editOneUser/${user.id}'/>">Edit</a></td>
    <td><a href="<c:url value='/remove/${user.id}'/>">Delete</a></td>
  </tr>
</table>
</body>
</html>