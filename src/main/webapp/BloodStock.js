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
            function addBag() {
                let params = {};
                params['bag_id'] = document.getElementById("bag_id").value;
                params['blood_type'] = document.getElementById("blood_type").value;
                params['donation_date'] = document.getElementById("donation_date").value;
                params['doctor_id'] = document.getElementById("doctor_id").value;
                const bloodt = ["A+","A-","B+","B-","O+","O-","AB+","AB-"];
                  if(params.blood_type === ""){
                    alert("Please fill blood type");
                    return;
                };
                 if(bloodt.includes(params.blood_type)){
                     void(0);
                }else{
                    alert("Please type a valid bloodtype");
                };
                 if(params.donation_date === ""){
                    alert("Please fill donation date");
                    return;
                }
                 if(params.doctor_id === "" || isNaN(params.doctor_id)){
                    alert("Please fill doctor id");
                    return;
                }
                const url = buildUrl("http://localhost:8080/BloodBank/addBag", params);

                var xhttp = new XMLHttpRequest();

                xhttp.open("POST", buildUrl("addBag", params), true); // to set transation number in the session
                xhttp.send();

                xhttp.onreadystatechange = function ()
                {

                    if (xhttp.readyState === 4 && xhttp.status === 200)
                    {
                        var data = xhttp.responseText;
                        if (data === "Done") {
                            alert("Data Saved...!");
                            loadBagData();
                        } else if (data === "NotDone") {
                            alert("Error...!");
                        }

                    }
                };
            }
            function loadBagData() {
                $.ajax({
                    url: "getBags?",
                    type: 'POST',
                    dataType: 'json',
                    contentType: 'application/json',
                    success: function (data) {
                        console.log(data);
                        document.getElementById("BagData").innerHTML = "";
                        for (var i = 0; i < data.length; i++) {
                            document.getElementById("BagData").innerHTML += "<tr>"
                                    + "         <td>" + data[i].bagId + "</td>"
                                    + "         <td>" + data[i].bloodType + "</td>"
                                    + "         <td>" + new Date(data[i].donationDate).toISOString().split('T')[0] + "</td>"
                                    + "         <td>" + data[i].doctorId + "</td>"
                                    + "         <td><button class=\"button-6\" onclick=\"deleteBag('" + data[i].bagId + "');\">Delete</button></td>"
                                    + "</tr>";
                        }
                        if (data.length === 0) {
                            document.getElementById("BagData").innerHTML = "<tr><td colspan='3'>No Data Found</td></tr>";
                        }
                    },
                    error: function (xhr, status) {
                        document.getElementById("BagData").innerHTML = "<tr><td colspan='3'>No Data Found</td></tr>";
                    }
                });
            }
            function loadAvaliableBagData() {
                $.ajax({
                    url: "getAvaliableBags?",
                    type: 'POST',
                    dataType: 'json',
                    contentType: 'application/json',
                    success: function (data) {
                        console.log(data);
                        document.getElementById("BagData").innerHTML = "";
                        for (var i = 0; i < data.length; i++) {
                            document.getElementById("BagData").innerHTML += "<tr>"
                                    + "         <td>" + data[i].bagId + "</td>"
                                    + "         <td>" + data[i].bloodType + "</td>"
                                    + "         <td>" + new Date(data[i].donationDate).toISOString().split('T')[0] + "</td>"
                                    + "         <td>" + data[i].doctorId + "</td>"
                                    + "         <td><button class=\"button-6\" onclick=\"deleteBag('" + data[i].bagId + "');\">Delete</button></td>"
                                    + "</tr>";
                        }
                        if (data.length === 0) {
                            document.getElementById("BagData").innerHTML = "<tr><td colspan='3'>No Data Found</td></tr>";
                        }
                    },
                    error: function (xhr, status) {
                        document.getElementById("BagData").innerHTML = "<tr><td colspan='3'>No Data Found</td></tr>";
                    }
                });
            }

            function deleteBag(bagId) {
                
                var xhttp = new XMLHttpRequest();

                xhttp.open("POST", "deleteBag?bag_id=" + bagId, true); // to set transation number in the session
                xhttp.send();

                xhttp.onreadystatechange = function ()
                {
                    if (xhttp.readyState === 4 && xhttp.status === 200)
                    {
                        var data = xhttp.responseText;
                        if (data === "Done") {
                            alert("Data Deleted...!");
                            loadBagData();
                        } else if (data === "NotDone") {
                            alert("Error...!");
                        }

                    }

                };
            }

