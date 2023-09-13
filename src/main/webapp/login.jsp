<%
    String open = (String) request.getSession().getAttribute("OpenHTMLFile");
    if(open.equals("Open")){
%>
<!<!doctype html>
<html lang="en">
  <head>
  	<title>Blood Bank</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="loginDesign/css/style.css">

	</head>
	<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Login</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-7 col-lg-5">
					<div class="login-wrap p-4 p-md-5">
		      	<div class="icon d-flex align-items-center justify-content-center">
		      		<span class="fa fa-user-o"></span>
		      	</div>
		      	<h3 class="text-center mb-4">Sign In</h3>
						<form action="#" class="login-form">
		      		<div class="form-group">
		      			<input type="text" class="form-control rounded-left" id="username" placeholder="Username" required>
		      		</div>
	            <div class="form-group d-flex">
	              <input type="password" class="form-control rounded-left" id="password" placeholder="Password" required>
	            </div>
	            <div class="form-group">
                        <button type="submit" class="form-control btn btn-primary rounded submit px-3" onclick="loginFunc()">Login</button>
	            </div>
	            <div class="form-group d-md-flex">
	            	<div class="w-50">
	            		
								</div>
								<div class="w-50 text-md-right">
									
								</div>
	            </div>
	          </form>
	        </div>
				</div>
			</div>
		</div>
	</section>          
  <script src="loginDesign/js/jquery.min.js"></script>
  <script src="loginDesign/js/popper.js"></script>
  <script src="loginDesign/js/bootstrap.min.js"></script>
 <script src="webDesign/vendors/pnotify/dist/pnotify.js"></script>
            <script src="webDesign/vendors/pnotify/dist/pnotify.buttons.js"></script>
  <script src="loginDesign/js/main.js"></script>
  <script src="login.js"></script>

	</body>
</html>


<% 
    }else{
    response.sendRedirect("login_AccesServlet");
}
%>