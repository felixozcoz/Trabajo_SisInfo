<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" type="text/css" href="assets/dist/css/authenticate.css" />
  
  
</head>
<body>
  <div class="container" id="container">
    <div class="form-container sign-up-container">
    <!-- Contaniner para registrar cuenta -->
      <form action="CreateAccount" method="post"> <!-- así consique que se active el servlet Coco -->
        <h1>Create Account</h1>
        <input type="text" placeholder="Name" name="inputNameCA"/>
        <input type="email" placeholder="Email" name="inputEmailCA"/>
        <input type="password" placeholder="Password" name="inputPasswdCA"/>
        <button id="register">Sign Up</button>
      </form>
    </div>
    <div class="form-container sign-in-container">
      <form action="SignIn" method="post">
        <h1>Sign in</h1>
        <input type="text" placeholder="Email/Name" name="inputEmailNameSI"/>
        <input type="password" placeholder="Password" name="inputPasswordSI"/>
        <a href="#">Forgot your password?</a>
        <button>Sign In</button>
      </form>
    </div>
    <div class="overlay-container">
      <div class="overlay">
        <div class="overlay-panel overlay-left">
          <h1>Welcome Back!</h1>
          <p>To keep connected with us please login with your personal info</p>
          <button class="ghost" id="signIn">Sign In</button>
        </div>
        <div class="overlay-panel overlay-right">
          <h1>Hello, Friend!</h1>
          <p>Enter your personal details and start journey with us</p>
          <button class="ghost" id="signUp">Sign Up</button>
        </div>
      </div>
    </div>
  </div>
  <script src="assets/dist/js/authenticate.js"></script>
</body>
</html>