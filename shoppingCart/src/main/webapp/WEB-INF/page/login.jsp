<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
body {
	 background-color:rgba(0,0,0,0.5);
   
    background-image: url("resources/images/cakes/img/1bg.jpg");
    background-size: cover;
}

.form_bg {
    
   
    
    color:#666;
    padding:20px;
    border-radius:10px;
    position: relative;
    border:1px solid #fff;
    margin:40;
    top: 30;
    bottom:40;
    right:100;
    left:100;
    width: 620px;
    height: 300px;
}
.align-center {
    
color: white;
font-weight: bold;
    text-align:center;
}

</style>
</head>
<body>

<%@ include file="header.jsp" %><br><center>
<div class="container">
 <!-- <div>
 <h2>ENTER USERNAME AND PASSWORD </h2></center>
</div><br>
 -->

<!-- these 3 are model attribute, fr one value other two will be null -->


    <div class="row">
        <div class="form_bg">
            <form action="j_spring_security_check" method="POST">
                 <h2 class="text-center">Login Please</h2>
                 
                <br/>
                <div class="form-group">
                    <input type="text" name="username" class="form-control"  placeholder="User id">
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control"  placeholder="Password">
                
                    </div>
                    
                    <br/>
                   <div class="align-center">
                <center><button type="submit" class="btn btn-success" id="login">Login</button></center>
                    </div>
                     
            </form>
            
  ${error }
${logout }
${registrationSuccess }            
        </div>
    </div>
</div>
</center>
<!-- <div><center>
    <label><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required><br><br>

    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required><br><br>

    <button type="submit">Login</button>
    
    
    <input type="checkbox" checked="checked"> Remember me
  </div></center><br>
<center>
  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
 	</center> -->
  </div>
   
</form>
</div>
</body>
</html>