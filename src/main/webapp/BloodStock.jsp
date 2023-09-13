<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%      
    String loged = (String) request.getSession().getAttribute("adminSession");
    if(loged != null){
    String open = (String) request.getSession().getAttribute("OpenHTMLFile");
    if(open.equals("Open")){
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- website font  -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
        integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
  
    <link rel="stylesheet" type="text/css" href="css/style.css" />
        <title>Blood Stock</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="BloodStock.js"></script>
        
    </head>
    <body> 
        <!-- Navbar 2 Start -->
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
    <!-- Navbar 2 End -->
        <div style="display: flex; flex-direction: row; align-content: center; justify-content: space-around;">
        <div style="display: flex; flex-direction: column; width: 200px;">   
        Bag ID : <input disabled value="" id="bag_id" />
        <br>
        Blood Type : <input value="" id="blood_type" />
        <br>
        Donation Date : <input value="" id="donation_date" /> 
        <br>
        Doctor ID : <input value="" id="doctor_id" />
        <br>
        <button onclick="addBag()" id="submit_btn" class="button-6">Submit</button>
        <br>
        <button onclick="loadBagData()" id="get_btn" class="button-6">Get All Bags</button>
        <br>
        <button onclick="loadAvaliableBagData()" id="get_btn" class="button-6">Get Avaliable Bags</button>
        </div>
        <br>
        <br>
        <div class="containerss">
        <table border="10" style="border: 2px solid black;">
            <thead>
                <tr>
                    <th style="text-align:center">Bag id</th>
                    <th style="text-align:center">Blood Type</th>
                    <th style="text-align:center">Donation Date</th>
                    <th style="text-align:center">Doctor id</th>

                    <th></th>
                </tr>
            </thead>
            <tbody id="BagData">

            </tbody>
        </table>

        </div>
        </div>

    </body>
</html>
<% 
    }else{
    response.sendRedirect("login_AccessServlet");
} }else{
response.sendRedirect("login_AccessServlet");
}

%>