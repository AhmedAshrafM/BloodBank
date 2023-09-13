/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
const buildUrl = (url, queryParams) => {
                url = url.concat("?");
                Object.keys(queryParams).forEach(key => {
                    if (!queryParams[key])
                        delete queryParams[key]
                    else
                        url = url.concat(key, "=", queryParams[key], "&");
                });

                return url.slice(0, -1);
            };
            function addTransaction() {
                let params = {};
                params['transaction_id'] = document.getElementById("transaction_id").value;
                params['patient_id'] = document.getElementById("patient_id").value;
                params['donor_id'] = document.getElementById("donor_id").value;
                params['bag_id'] = document.getElementById("bag_id").value;
                params['transaction_date'] = document.getElementById("transaction_date").value;
                params['doctor_id'] = document.getElementById("doctor_id").value;
                if(params.bag_id === ""){
                    alert("Please enter a valid bag id");
                    return;
                }
                if(params.doctor_id === ""){
                    alert("Please enter a valid doctor id");
                    return;
                }
                const url = buildUrl("http://localhost:8080/BloodBank/addTransaction", params);

                var xhttp = new XMLHttpRequest();

                xhttp.open("POST", buildUrl("addTransaction", params), true); // to set transation number in the session
                xhttp.send();

                xhttp.onreadystatechange = function ()
                {

                    if (xhttp.readyState === 4 && xhttp.status === 200)
                    {
                        var data = xhttp.responseText;
                        if (data === "Done") {
                            alert("Data Saved...!");
                            loadTransactionData();
                        } else if (data === "NotDone") {
                            alert("Error...!");
                        }

                    }
                };
            }
            function loadTransactionData() {
                $.ajax({
                    url: "getTransactions?",
                    type: 'POST',
                    dataType: 'json',
                    contentType: 'application/json',
                    success: function (data) {
                        console.log(data);
                        document.getElementById("TransactionData").innerHTML = "";
                        for (var i = 0; i < data.length; i++) {
                            document.getElementById("TransactionData").innerHTML += "<tr>"
                                    + "         <td>" + data[i].transactionId + "</td>"
                                    + "         <td>" + data[i].patientId + "</td>"
                                    + "         <td>" + data[i].donorId + "</td>"
                                    + "         <td>" + data[i].bagId + "</td>"                                    
                                    + "         <td>" + new Date(data[i].transactionDate).toISOString().split('T')[0]  + "</td>"
                                    + "         <td>" + data[i].doctorId + "</td>"
                                    + "         <td><button class=\"button-6\" onclick=\"deleteTransaction('" + data[i].transactionId + "');\">Delete</button></td>"
                                    + "</tr>";
                        }
                        if (data.length === 0) {
                            document.getElementById("TransactionData").innerHTML = "<tr><td colspan='3'>No Data Found</td></tr>";
                        }
                    },
                    error: function (xhr, status) {
                        document.getElementById("TransactionData").innerHTML = "<tr><td colspan='3'>No Data Found</td></tr>";
                    }
                });
            }
            function loadPatientsTransactionsData() {
                $.ajax({
                    url: "getPatientsTransactions?",
                    type: 'POST',
                    dataType: 'json',
                    contentType: 'application/json',
                    success: function (data) {
                        console.log(data);
                        document.getElementById("TransactionData").innerHTML = "";
                        for (var i = 0; i < data.length; i++) {
                            document.getElementById("TransactionData").innerHTML += "<tr>"
                                    + "         <td>" + data[i].transactionId + "</td>"
                                    + "         <td>" + data[i].patientId + "</td>"
                                    + "         <td>" + data[i].donorId + "</td>"
                                    + "         <td>" + data[i].bagId + "</td>"                                    
                                    + "         <td>" + new Date(data[i].transactionDate).toISOString().split('T')[0]  + "</td>"
                                    + "         <td>" + data[i].doctorId + "</td>"
                                    + "         <td><button class=\"button-6\" onclick=\"deleteTransaction('" + data[i].transactionId + "');\">Delete</button></td>"
                                    + "</tr>";
                        }
                        if (data.length === 0) {
                            document.getElementById("TransactionData").innerHTML = "<tr><td colspan='3'>No Data Found</td></tr>";
                        }
                    },
                    error: function (xhr, status) {
                        document.getElementById("TransactionData").innerHTML = "<tr><td colspan='3'>No Data Found</td></tr>";
                    }
                });
            }
            function deleteTransaction(transactionId) {
                
                var xhttp = new XMLHttpRequest();

                xhttp.open("POST", "deleteTransaction?transaction_id=" + transactionId, true); // to set transation number in the session
                xhttp.send();

                xhttp.onreadystatechange = function ()
                {
                    if (xhttp.readyState === 4 && xhttp.status === 200)
                    {
                        var data = xhttp.responseText;
                        if (data === "Done") {
                            alert("Data Deleted...!");
                            loadTransactionData();
                        } else if (data === "NotDone") {
                            alert("Error...!");
                        }

                    }

                };
            }

