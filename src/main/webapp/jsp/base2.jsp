<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
* {
  box-sizing: border-box;
}

body {
  font-family: Arial;
  padding: 10px;
  background: #f3f2f8;
}

/* Header/Blog Title */
.header {
  padding: 0px;
  text-align: center;
  height:147px
}

.header h1 {
  font-size: 50px;
  color : #0e0314;
  padding-top: 93px;
}

.hero-image {
  background-image: linear-gradient(rgba(0, 0, 0, 0.4), rgba(0, 0, 0, 0.7)),url('Kaggle.png');
  height: 50%;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}

.hero-text {
  text-align: center;
  position: relative;
  top: 0%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: #8784be;
}

/* Style the top navigation bar */
.topnav {
  overflow: hidden;
  background-color:  #0e0314;
}

/* Style the topnav links */
.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  /*margin-bottom:300px;*/
  text-decoration: none;
}

/* Change color on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.column {
  float: left;
  width: 25%;
  padding: 0 10px;
}

.row{
  margin-top:260px;
}

/* Add a card effect for articles */
.card {
  background-color: #0e0314 ;
  padding: 20px;
  margin-top: 100px;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  border-radius: 5px;
  height:400px;
  text-align:center;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
  padding-top: 100px;
}

/* Footer */
.footer {
  padding: 20px;
  text-align: center;
  background: #ddd;
  margin-top: 20px;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 800px) {
  .leftcolumn, .rightcolumn {   
    width: 100%;
    padding: 0;
  }
}

/* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */
@media screen and (max-width: 400px) {
  .topnav a {
    float: none;
    width: 100%;
  }
}
</style>
</head>
<body>

  <div class="header">
    <div class="hero-text">
      <h1 style="font-size:50px"> Community Health Management System</h1>
      <h3>Welcome to CHM, a unique initiative by Behala Club(estd. 1980) to monitor pandemics locally!</h3>  
    </div>
  </div>

<div class="topnav">
   <a href="/sign-up">Sign Up</a>
   <a href="/login">Login</a>
   <a href="#">About Us</a>
   <a href="/logout" style="float:right">Logout</a>
 </div>


  
<div class="row">
  <div class="column">
    <div class="card">
      <h3 style="color:#fcf5f5">Card 1</h3>
      <p>Some text</p>
      <p>Some text</p>
    </div>
  </div>

  <div class="column">
    <div class="card">
      <h3 style="color:#fcf5f5">Card 2</h3>
      <p>Some text</p>
      <p>Some text</p>
    </div>
  </div>
  
  <div class="column">
    <div class="card">
      <h3 style="color:#fcf5f5">Card 3</h3>
      <!--img src="Kaggle.png" style="width:100%"/-->
      <p>Some text</p>
      <p>Some text</p>
    </div>
  </div>

  <div class="column">
    <div class="card">
      <h3 style="color:#fcf5f5">Card 4</h3>
      <p>Some text</p>
      <p>Some text</p>
    </div>
  </div>
</div>
<div class="footer">
  <h2>Footer</h2>
</div>

</body>
</html>
