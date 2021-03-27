<%--
  Created by IntelliJ IDEA.
  User: xL3F
  Date: 3/25/2021
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Authorization</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">
    <link href="bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <link href="signin.css" rel="stylesheet">
  </head>
<body class="text-center">
<main class="form-signin">
  <form action="auth" method="post">

    <h1 class="h3 mb-3 fw-normal">Log in</h1>

    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="Username" name="usnm">
      <label for="floatingInput">Username</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="pwd">
      <label for="floatingPassword">Password</label>
    </div>
    <button class="w-50 btn btn-lg btn-primary" type="submit" style="margin-bottom: 20px;">Sign in</button>
    </form >


    <form action="registration.html">
    <button class="w-50 btn btn-lg btn-secondary" type="submit">Register</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2021</p>
    </form>
  </form>
</main>
</body>
</html>
