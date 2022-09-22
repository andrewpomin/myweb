 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greetings</title>
    <meta name ="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0" />
    <meta name="MobileOptimized" content="width">
    <link rel="icon" href="../icons/icon-my.png" type="image/png" sizes="64x64">
    <link rel="stylesheet" type="text/css" media="screen" href="../css/choose.css">
    <link rel="stylesheet" type="text/css" media="screen and (max-device-width:720px)" href="../css/choose-smart.css">
</head>
<body>
    <div class="flex-container">
        <div class="groups">
            <form action="${pageContext.request.contextPath}/login" class="form">
                <button class="b-login">Log In</button>
            </form>
            <form action="${pageContext.request.contextPath}/signup" class="form">
                <button class="b-signup">Sign Up</button>
            </form>
        </div>
    </div>
</body>
</html>
