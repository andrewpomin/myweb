<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="myprojects.generators.Music" %>
<%@ page import="myprojects.generators.Body" %>
<%
  Body body = new Body();
  Music music = new Music();
  PrintWriter pw = response.getWriter();
  pw.write("<link rel=\"icon\" href=\"../icons/icon-my.png\" type=\"image/png\" sizes=\"64x64\">");
  pw.write(body.getNavigation());
  pw.write("<div class=\"outer-container\">");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta name ="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0" />
  <meta name="MobileOptimized" content="width">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Music</title>

  <link rel="stylesheet" type="text/css" href="../css/main.css">
  <link rel="stylesheet" type="text/css" media="screen and (max-device-width:720px)" href="../css/main-smart.css">
  <link rel="stylesheet" type="text/css" media="screen" href="../css/music.css">
  <link rel="stylesheet" type="text/css" media="screen and (max-device-width:720px)" href="../css/music-smart.css">
</head>
<body onload="getDuration()">


  <%
    if (request.getParameter("sort") == null) {
      pw.write(music.printMusic());
    } else if (request.getParameter("sort").equals("random")) {
      pw.write(music.printRandomMusic());
    } else {
      pw.write(music.printMusic());
    }

    pw.write("</div>");
  %>
</body>

<script src="../js/main.js"></script>
<script src="../js/music.js"></script>

</html>
