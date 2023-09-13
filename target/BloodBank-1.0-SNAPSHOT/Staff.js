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
            function addStaff() {
                let params = {};
                params['staff_first_name'] = document.getElementById("staff_first_name").value;
                params['staff_last_name'] = document.getElementById("staff_last_name").value;
                params['gender'] = document.getElementById("gender").value;
                params['address'] = document.getElementById("Address").value;
                params['blood_type'] = document.getElementById("blood_type").value;
                params['nat_id'] = document.getElementById("nat_id").value;
                params['date_of_birth'] = document.getElementById("Date_of_birth").value;
                params['Primary_Number'] = document.getElementById("Primary_Number").value;
                params['secondary_number'] = document.getElementById("secondary_number").value;
                params['salary'] = document.getElementById("salary").value;
                params['job_id'] = document.getElementById("job_id").value;
                
                const bloodt = ["A+","A-","B+","B-","O+","O-","AB+","AB-"];
                 const genders = ["Male","Female","M","F"];
                  if(params.blood_type === ""){
                    alert("Please fill blood_type");
                    return;
                };
                 if(bloodt.includes(params.blood_type)){
                     void(0);
                }else{
                    alert("Please type a valid bloodtype");
                };
                 if(params.staff_first_name === ""){
                    alert("Please fill first_name");
                    return;
                };
                if(params.staff_last_name === ""){
                    alert("Please fill last_name");
                    return;
                };
                 if(params.gender === ""){
                    alert("Please fill gender");
                    return;
                };
                if(genders.includes(params.gender)){
                    void(0);
                }else{
                    alert("Please type a valid gender");
                    return;
                };
                 if(params.address === ""){
                    alert("Please fill address");
                    return;
                };
                 if(params.job_id === "" || isNaN(params.job_id)){
                    alert("Please fill doctor_id");
                    return;
                };
                if(params.nat_id === "" || params.nat_id.length !== 16 || isNaN(params.nat_id)){
                    alert("Please fill valid national id");
                    return;
                };
                 if(params.date_of_birth === ""){
                    alert("Please fill birth date");
                    return;
                };
                 if(params.Primary_Number === "" || isNaN(params.Primary_Number)){
                    alert("Please fill Primary_Number");
                    return;
                };
                
                const url = buildUrl("http://localhost:8080/BloodBank/addStaff", params);

                var xhttp = new XMLHttpRequest();

                xhttp.open("POST", buildUrl("addStaff", params), true); // to set transation number in the session
                xhttp.send();

                xhttp.onreadystatechange = function ()
                {

                    if (xhttp.readyState === 4 && xhttp.status === 200)
                    {
                        var data = xhttp.responseText;
                        if (data === "Done") {
                            alert("Data Saved...!");
                            loadStaffData();
                        } else if (data === "NotDone") {
                            alert("Error...!");
                        }

                    }
                };
            }
            function loadStaffData() {
                $.ajax({
                    url: "getStaff?",
                    type: 'POST',
                    dataType: 'json',
                    contentType: 'application/json',
                    success: function (data) {
                        document.getElementById("StaffData").innerHTML = "";
                        for (var i = 0; i < data.length; i++) {
                            document.getElementById("StaffData").innerHTML += "<tr>"
                                    + "         <td>" + data[i].empId + "</td>"
                                    + "         <td>" + data[i].staffFirstName + "</td>"
                                    + "         <td>" + data[i].staffLastName + "</td>"
                                    + "         <td>" + data[i].gender + "</td>"
                                    + "         <td>" + data[i].address + "</td>"
                                    + "         <td>" + data[i].bloodType + "</td>"
                                    + "         <td>" + data[i].natId + "</td>"
                                    + "         <td>" + new Date(data[i].dateOfBirth).toISOString().split('T')[0] + "</td>"
                                    + "         <td>" + data[i].primaryNumber + "</td>"
                                    + "         <td>" + data[i].secondaryNumber + "</td>"
                                    + "         <td>" + data[i].salary + "</td>"
                                    + "         <td>" + data[i].jobId + "</td>"
                                    + "         <td><button class=\"button-6\" onclick=\"deleteStaff('" + data[i].natId + "');\">Delete</button></td>"
                                    + "</tr>";
                        }
                        if (data.length === 0) {
                            document.getElementById("StaffData").innerHTML = "<tr><td colspan='3'>No Data Found</td></tr>";
                        }
                    },
                    error: function (xhr, status) {
                        document.getElementById("StaffData").innerHTML = "<tr><td colspan='3'>No Data Found</td></tr>";
                    }
                });
            }

            function deleteStaff(natId) {
                
                var xhttp = new XMLHttpRequest();

                xhttp.open("POST", "deleteStaff?nat_id=" + natId, true); // to set transation number in the session
                xhttp.send();

                xhttp.onreadystatechange = function ()
                {
                    if (xhttp.readyState === 4 && xhttp.status === 200)
                    {
                        var data = xhttp.responseText;
                        if (data === "Done") {
                            alert("Data Deleted...!");
                            loadStaffData();
                        } else if (data === "NotDone") {
                            alert("Error...!");
                        }

                    }

                };
            }
             function getCertainStaff(){
                
                nat_id = document.getElementById("nat_id").value;
                if(nat_id === ""  || isNaN(nat_id)){
                    alert("Please fill valid national id");
                    return;
                };
                     $.ajax({
                    url: "getCertainStaff?" + "nat_id=" + nat_id,
                    type: 'POST',
                    dataType: 'json',
                    contentType: 'application/json',
                    success: function (data) {
                        console.log(data);
                        document.getElementById("StaffData").innerHTML = "";
                        for (var i = 0; i < data.length; i++) {
                            document.getElementById("StaffData").innerHTML += "<tr>"
                                    + "         <td>" + data[i].empId + "</td>"
                                    + "         <td>" + data[i].staffFirstName + "</td>"
                                    + "         <td>" + data[i].staffLastName + "</td>"
                                    + "         <td>" + data[i].gender + "</td>"
                                    + "         <td>" + data[i].address + "</td>"
                                    + "         <td>" + data[i].bloodType + "</td>"
                                    + "         <td>" + data[i].natId + "</td>"
                                    + "         <td>" + new Date(data[i].dateOfBirth).toISOString().split('T')[0] + "</td>"
                                    + "         <td>" + data[i].primaryNumber + "</td>"
                                    + "         <td>" + data[i].secondaryNumber + "</td>"
                                    + "         <td>" + data[i].salary + "</td>"
                                    + "         <td>" + data[i].jobId + "</td>"
                                    + "         <td><button class=\"button-6\" onclick=\"deleteStaff('" + data[i].natId + "');\">Delete</button></td>"
                                    + "</tr>";
                        }
                        document.getElementById("staff_first_name").value = data[0].staffFirstName;
                        document.getElementById("staff_last_name").value = data[0].staffLastName;
                        document.getElementById("gender").value = data[0].gender;
                        document.getElementById("Address").value = data[0].address;
                        document.getElementById("blood_type").value = data[0].bloodType;
                        document.getElementById("nat_id").value = data[0].natId;
                        document.getElementById("Date_of_birth").value = new Date(data[0].dateOfBirth).toISOString().split('T')[0];
                        document.getElementById("Primary_Number").value = data[0].primaryNumber;
                        document.getElementById("secondary_number").value = data[0].secondaryNumber;
                        document.getElementById("job_id").value = data[0].jobId;
                        document.getElementById("salary").value = data[0].salary;
                        
                        if (data.length === 0) {
                            document.getElementById("StaffData").innerHTML = "<tr><td colspan='3'>No Data Found</td></tr>";
                        }
                    },
                    error: function (xhr, status) {
                        document.getElementById("StaffData").innerHTML = "<tr><td colspan='3'>No Data Found</td></tr>";
                    }
                });}
                
                function updateStaff() {
                let params = {};
                params['staff_first_name'] = document.getElementById("staff_first_name").value;
                params['staff_last_name'] = document.getElementById("staff_last_name").value;
                params['gender'] = document.getElementById("gender").value;
                params['address'] = document.getElementById("Address").value;
                params['blood_type'] = document.getElementById("blood_type").value;
                params['nat_id'] = document.getElementById("nat_id").value;
                params['date_of_birth'] = document.getElementById("Date_of_birth").value;
                params['Primary_Number'] = document.getElementById("Primary_Number").value;
                params['secondary_number'] = document.getElementById("secondary_number").value;
                params['job_id'] = document.getElementById("job_id").value;
                 const bloodt = ["A+","A-","B+","B-","O+","O-","AB+","AB-"];
                 const genders = ["Male","Female","M","F"];
                  if(params.blood_type === ""){
                    alert("Please fill blood_type");
                    return;
                };
                 if(bloodt.includes(params.blood_type)){
                     void(0);
                }else{
                    alert("Please type a valid bloodtype");
                };
                 if(params.staff_first_name === ""){
                    alert("Please fill first_name");
                    return;
                };
                if(params.staff_last_name === ""){
                    alert("Please fill last_name");
                    return;
                };
                 if(params.gender === ""){
                    alert("Please fill gender");
                    return;
                };
                if(genders.includes(params.gender)){
                    void(0);
                }else{
                    alert("Please type a valid gender");
                    return;
                };
                 if(params.address === ""){
                    alert("Please fill address");
                    return;
                };
                 if(params.job_id === "" || isNaN(params.job_id)){
                    alert("Please fill job id");
                    return;
                };
                if(params.nat_id === "" || params.nat_id.length !== 16 || isNaN(params.nat_id)){
                    alert("Please fill valid national id");
                    return;
                };
                 if(params.date_of_birth === ""){
                    alert("Please fill birth date");
                    return;
                };
                 if(params.Primary_Number === "" || isNaN(params.Primary_Number)){
                    alert("Please fill Primary_Number");
                    return;
                };
                const url = buildUrl("http://localhost:8080/BloodBank/updateStaff", params);

                var xhttp = new XMLHttpRequest();

                xhttp.open("POST", buildUrl("updateStaff", params), true); // to set transation number in the session
                xhttp.send();

                xhttp.onreadystatechange = function ()
                {

                    if (xhttp.readyState === 4 && xhttp.status === 200)
                    {
                        var data = xhttp.responseText;
                        if (data === "Done") {
                            alert("Data Updated...!");
                            loadStaffData();
                        } else if (data === "NotDone") {
                            alert("Error...!");
                        }

                    }
                };
            }

