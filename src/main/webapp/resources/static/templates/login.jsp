<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*, java.util.*" %>
<%
  String attribute = "hidden";
  int parameter = 0;

if (request.getParameter("error") != null) {
  parameter = 1;
}
  if(parameter == 1) {
    attribute = "";
  };
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Log In</title>
  <meta name ="viewport" content="width=device-width, initial-scale=1, user-scalable=0" />
  <meta name="MobileOptimized" content="width">
  <link rel="icon" href="../icons/icon-my.png" type="image/png" sizes="64x64" />
  <link rel="stylesheet" type="text/css" href="../css/main.css"/>
  <link rel="stylesheet" type="text/css" media="screen and (max-device-width:720px)" href="../css/main-smart.css">
  <link rel="stylesheet" href="../css/login.css" type="text/css" />
  <link rel="stylesheet" type="text/css" media="screen and (max-device-width:720px)" href="../css/login-smart.css">
</head>
<body>
  <div class="outer">
    <div class="inner">
      <form action="${pageContext.request.contextPath}/user/login" method="post" class="action">
      <label class="object">
        <span class="description">Email</span>
        <input class="input" type="email" name="login" placeholder="email@email.com">
      </label>
      <label class="object">
        <span class="description">Password</span>
        <input class="input" type="password" name="password" placeholder="password" autocomplete="current-password">
      </label>
      <label class="object">
        <span class="before-wrong"></span>
        <span class="wrong" <%= attribute %>>
        *Wrong email or password</span>
      </label>
      <label class="object">
        <span style="width: 100px"></span>
        <button type="submit" class="button">Log In</button>
      </label>
      </form>
      <form action="${pageContext.request.contextPath}/signup" class="action">
      <label class="object">
        <span style="width: 100px"></span>
        <span class ="or">or</span>
      </label>
      <label class="object">
        <span style="width: 100px"></span>
        <button class="buttonSignUp">Sign Up</button>
      </label>
      </form>
    </div>
  </div>
</body>
</html>
