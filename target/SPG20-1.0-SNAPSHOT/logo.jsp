<%--
  Created by IntelliJ IDEA.
  User: uman_
  Date: 28-09-2024
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<div class="box">
    <img src="https://cdn-icons-png.flaticon.com/512/2450/2450449.png" alt="Logo" width="30" height="24"
         class="d-inline-block align-text-top">
    <script>
        gsap.to(".box", {x: 300, rotation: 360, duration: 4});
    </script>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.10.4/gsap.min.js"></script>
</body>
</html>
