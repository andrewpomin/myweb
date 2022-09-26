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
    <title>Sign Up</title>
  <meta name ="viewport" content="width=device-width, initial-scale=1, user-scalable=1" />
  <meta name="MobileOptimized" content="width">
  <link rel="icon" href="../icons/icon-my.png" type="image/png" sizes="64x64">
  <link rel="stylesheet" type="text/css" href="../css/main.css"/>
  <link rel="stylesheet" type="text/css" media="screen and (max-device-width:720px)" href="../css/main-smart.css">
  <link rel="stylesheet" type="text/css" href="../css/signup.css"/>
  <link rel="stylesheet" type="text/css" media="screen and (max-device-width:720px)" href="../css/signup-smart.css">
</head>
<body>
  <form action="${pageContext.request.contextPath}/user/register" method="post">
  <div class="outer">
    <div class="inner">
    <label class="object">
      <span class="description">First name</span>
      <input type="text" name="firstname" placeholder="First Name" required>
    </label>
    <label class="object">
      <span class="description">Last name</span>
      <input type="text" name="lastname" placeholder="Last Name" required>
    </label>
    <label class="object">
      <span class="description">Phone</span>
      <input type="tel" name="phone"
      placeholder="+38 (___) ___-__-__" required>
    </label>
    <label class="object">
      <span class="description">Email</span>
      <input type="email" name="email" placeholder="email@email.com" required>
    </label>
    <label class="object">
      <span class="description">Password</span>
      <input type="password" name="password" id="password" placeholder="password"
             pattern="(?=.*[0-9])(?=.*[a-z])[0-9a-zA-Z]{6,}" title="The password must contain at least 6 of
              upper and lower case Latin letters and numbers" required>
    </label>
    <label class="object">
      <span class="description">Repeat password</span>
      <input type="password" id="repeatPassword" placeholder="repeat password" oninput="checkRepeat()" required>
    </label>
      <label class="object">
        <span style="width: 165px; margin-right: 10px"></span>
        <span class="wrong" id="wrong" <%= attribute %>>>*User already exists</span>
      </label>
      <label class="object">
        <span style="width: 165px; margin-right: 10px"></span>
        <span id="outer-span">
          <span id="inner-span"></span>
          <button class="button" id="button" type="submit" >Sign Up</button>
        </span>
      </label>
  </div>
</div>
</form>
</body>

    <script src="../js/authorization.js"></script>

</html>
