
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body  {
    background-image: url("resources/images/cakes/img/wall2.jpg");
    background-size: cover;
    
}
.form {
	background-color:rgba(0,0,0,0.6);
}
</style>
<body>
<div class="container">
<div class="panel panel-default">
<div class="panel-heading">
<center>
<h3> CAKES FOR YOU</h3><br>
WE BAKE FOR YOU...!
</div>
</div>	
            <form>
            <div class="panel panel-default">
				<div class="panel-body">
                	<div class="controls controls-row">
               <b>Name:</b> <input id="name" name="name" type="text" placeholder="Name" style="width: 500px;"> <br><br>
               <b>Email:</b><input id="email" name="email" type="email"  placeholder="Email address" style="width: 500px;"><br><br>
                </div>
                <div class="controls">
                    <textarea id="message" name="message"  placeholder="Feedback" rows="10" cols="100"></textarea>
                </div>
                  
                <div class="controls">
                    <button id="contact-submit" type="submit" class="btn btn-primary input-medium ">Send</button>
                </div>
                </div>
                </div>
            </form>
        </div>
	
</center>
</body>
</html>