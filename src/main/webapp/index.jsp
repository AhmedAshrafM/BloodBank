<%      
    String loged = (String) request.getSession().getAttribute("adminSession");
    if(loged != null){
    String open = (String) request.getSession().getAttribute("OpenHTMLFile");
    if(open.equals("Open")){
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />


    <!-- website font  -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
        integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

    <!-- Bootstrap CSS -->
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
    
    <link rel="stylesheet" href="css/style.css">
    <title>Blood Bank</title>
</head>

<body>

    <!-- Navbar Start -->
    <section id="Nav2">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <img src="imgs/logo.png" width="10%"></img>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link selected" href="index_AccessServlet">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="donors_AccessServlet">Donors</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="patients_AccessServlet">Patients</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="bloodstock_AccessServlet">Blood Stock</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="bloodtransactions_AccessServlet">Blood Transactions</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="staff_AccessServlet">Staff</a>
                    </li>
                </ul>
                <button class="btn login" onclick= "window.location.href = 'logOut_ControllerServlet';">Logout</button>
            </div>
        </nav>
    </section>
    <!-- Navbar End -->


    <!-- App Start -->
    <section id="app">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="info">
                        <h1>Blood Bank Management System</h1>
                        <h3>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quae earum officiis et eligendi nam
                            harum corporis saepe deserunt.</h3>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- App End -->
</body>

</html>
<% 
    }else{
    response.sendRedirect("login_AccessServlet");
} }else{
response.sendRedirect("login_AccessServlet");
}

%>