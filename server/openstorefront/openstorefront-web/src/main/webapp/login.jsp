<%-- 
    Document   : login
    Created on : Apr 25, 2014, 3:18:20 PM
    Author     : dshurtleff
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		
	</head>
	<body>
	<div class="auth-forms">
	  <div class="auth-content">
		<div class="row">
		  <h2>Log In</h2>
		  <form action="Login.action?Login" method="POST">
			<span>By logging in you are consenting to these conditions</span>
			<div class="disclaimer">
			  <h1>WARNING:</h1>
			  <p>
				You are accessing a U.S. Government (USG) Information System (IS) that is provided for USG-authorized use only. By using this IS (which includes any device attached to this IS), you consent to the following conditions: 1) The USG routinely intercepts and monitors communication on this IS for purposes including, but not limited to, penetration testing, COMSEC monitoring, network operations and defense, personnel misconduct (PM), law enforcement (LE), and counterintelligence (CI) investigations, 2) At any time, the ISG may inspect and seize data stored on this IS, 3) Communications using, or data stored on this IS are not private, are subject to routine monitoring, interception, and search, and may be disclosed or used for any USG -authorized purpose. 4) This IS includes security measures (e.g. authentication and access controls) to protect USG interests â€“ not for your personal benefit or privacy. 5) Notwithstanding the above, using this IS does not constitute consent to PM, LE, or CI investigative searching or monitoring of the content of privileged communication, or work product, related to personal representation or services by attorneys, psychotherapists, or clergy, and their assistants. Such communication and work product are private and confidential.
			  </p>
			</div>		
			<div style="width: 300px; margin: 0px auto;">
			<input type="text" name="username" placeholder="Username" class="form-control" autofocus>
			<br>
			<input type="password" name="password" placeholder="Password" class="form-control">
			<br>
			<br>
			<input type="submit" value="Log in" style="width: auto;" class="btn btn-primary" />
			</div>
		  </form>
		</div>
	  </div>
	</div>	
	</body>
</html>




