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
            function addPatient() {
                let params = {};
                params['patient_first_name'] = document.getElementById("patient_first_name").value;
                params['patient_last_name'] = document.getElementById("patient_last_name").value;
                params['gender'] = document.getElementById("gender").value;
                params['address'] = document.getElementById("Address").value;
                params['blood_type'] = document.getElementById("blood_type").value;
                params['nat_id'] = document.getElementById("nat_id").value;
                params['date_of_birth'] = document.getElementById("Date_of_birth").value;
                params['Primary_Number'] = document.getElementById("Primary_Number").value;
                params['secondary_number'] = document.getElementById("secondary_number").value;
                params['doctor_id'] = document.getElementById("doctor_id").value;
                
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
                 if(params.patient_first_name === ""){
                    alert("Please fill first_name");
                    return;
                };
                if(params.patient_last_name === ""){
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
                 if(params.doctor_id === "" || isNaN(params.doctor_id)){
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
                
                const url = buildUrl("http://localhost:8080/BloodBank/addPatient", params);

                var xhttp = new XMLHttpRequest();

                xhttp.open("POST", buildUrl("addPatient", params), true); // to set transation number in the session
                xhttp.send();

                xhttp.onreadystatechange = function ()
                {

                    if (xhttp.readyState === 4 && xhttp.status === 200)
                    {
                        var data = xhttp.responseText;
                        if (data === "Done") {
                            alert("Data Saved...!");
                            loadPatientData();
                        } else if (data === "NotDone") {
                            alert("Error...!");
                        }

                    }
                };
            }
            function loadPatientData() {
                $.ajax({
                    url: "getPatients?",
                    type: 'POST',
                    dataType: 'json',
                    contentType: 'application/json',
                    success: function (data) {
                        console.log(data);
                        document.getElementById("PatientData").innerHTML = "";
                        for (var i = 0; i < data.length; i++) {
                            document.getElementById("PatientData").innerHTML += "<tr>"
                                    + "         <td>" + data[i].patientId + "</td>"
                                    + "         <td>" + data[i].patientFirstName + "</td>"
                                    + "         <td>" + data[i].patientLastName + "</td>"
                                    + "         <td>" + data[i].gender + "</td>"
                                    + "         <td>" + data[i].address + "</td>"
                                    + "         <td>" + data[i].bloodType + "</td>"
                                    + "         <td>" + data[i].natId + "</td>"
                                    + "         <td>" + new Date(data[i].dateOfBirth).toISOString().split('T')[0] + "</td>"
                                    + "         <td>" + data[i].primaryNumber + "</td>"
                                    + "         <td>" + data[i].secondaryNumber + "</td>"
                                    + "         <td>" + data[i].doctorId + "</td>"
                                    + "         <td><button class=\"button-6\" onclick=\"deletePatient('" + data[i].natId + "');\">Delete</button></td>"
                                    + "</tr>";
                        }
                        if (data.length === 0) {
                            document.getElementById("PatientData").innerHTML = "<tr><td colspan='3'>No Data Found</td></tr>";
                        }
                    },
                    error: function (xhr, status) {
                        document.getElementById("PatientData").innerHTML = "<tr><td colspan='3'>No Data Found</td></tr>";
                    }
                });
            }

            function deletePatient(natId) {
                
                var xhttp = new XMLHttpRequest();

                xhttp.open("POST", "deletePatient?nat_id=" + natId, true); // to set transation number in the session
                xhttp.send();

                xhttp.onreadystatechange = function ()
                {
                    if (xhttp.readyState === 4 && xhttp.status === 200)
                    {
                        var data = xhttp.responseText;
                        if (data === "Done") {
                            alert("Data Deleted...!");
                            loadPatientData();
                        } else if (data === "NotDone") {
                            alert("Error...!");
                        }

                    }

                };
            }
            function getPatient(){
                
                nat_id = document.getElementById("nat_id").value;
                if(nat_id === ""  || isNaN(nat_id)){
                    alert("Please fill valid national id");
                    return;
                };
                     $.ajax({
                    url: "getPatient?" + "nat_id=" + nat_id,
                    type: 'POST',
                    dataType: 'json',
                    contentType: 'application/json',
                    success: function (data) {
                        console.log(data);
                        document.getElementById("PatientData").innerHTML = "";
                        for (var i = 0; i < data.length; i++) {
                            document.getElementById("PatientData").innerHTML += "<tr>"
                                    + "         <td>" + data[i].patientFirstName + "</td>"
                                    + "         <td>" + data[i].patientLastName + "</td>"
                                    + "         <td>" + data[i].gender + "</td>"
                                    + "         <td>" + data[i].address + "</td>"
                                    + "         <td>" + data[i].bloodType + "</td>"
                                    + "         <td>" + data[i].natId + "</td>"
                                    + "         <td>" + new Date(data[i].dateOfBirth).toISOString().split('T')[0] + "</td>"
                                    + "         <td>" + data[i].primaryNumber + "</td>"
                                    + "         <td>" + data[i].secondaryNumber + "</td>"
                                    + "         <td>" + data[i].doctorId + "</td>"
                                    + "         <td><button class=\"button-6\" onclick=\"deletePatient('" + data[i].natId + "');\">Delete</button></td>"
                                    + "</tr>";
                        }
                        document.getElementById("patient_first_name").value = data[0].patientFirstName;
                        document.getElementById("patient_last_name").value = data[0].patientLastName;
                        document.getElementById("gender").value = data[0].gender;
                        document.getElementById("Address").value = data[0].address;
                        document.getElementById("blood_type").value = data[0].bloodType;
                        document.getElementById("nat_id").value = data[0].natId;
                        document.getElementById("Date_of_birth").value = new Date(data[0].dateOfBirth).toISOString().split('T')[0];
                        document.getElementById("Primary_Number").value = data[0].primaryNumber;
                        document.getElementById("secondary_number").value = data[0].secondaryNumber;
                        document.getElementById("doctor_id").value = data[0].doctorId;
                        
                        if (data.length === 0) {
                            document.getElementById("PatientData").innerHTML = "<tr><td colspan='3'>No Data Found</td></tr>";
                        }
                    },
                    error: function (xhr, status) {
                        document.getElementById("PatientData").innerHTML = "<tr><td colspan='3'>No Data Found</td></tr>";
                    }
                });}
                
                function updatePatient() {
                let params = {};
                params['patient_first_name'] = document.getElementById("patient_first_name").value;
                params['patient_last_name'] = document.getElementById("patient_last_name").value;
                params['gender'] = document.getElementById("gender").value;
                params['address'] = document.getElementById("Address").value;
                params['blood_type'] = document.getElementById("blood_type").value;
                params['nat_id'] = document.getElementById("nat_id").value;
                params['date_of_birth'] = document.getElementById("Date_of_birth").value;
                params['Primary_Number'] = document.getElementById("Primary_Number").value;
                params['secondary_number'] = document.getElementById("secondary_number").value;
                params['doctor_id'] = document.getElementById("doctor_id").value;
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
                 if(params.patient_first_name === ""){
                    alert("Please fill first_name");
                    return;
                };
                if(params.patient_last_name === ""){
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
                 if(params.doctor_id === "" || isNaN(params.doctor_id)){
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
                const url = buildUrl("http://localhost:8080/BloodBank/updatePatient", params);

                var xhttp = new XMLHttpRequest();

                xhttp.open("POST", buildUrl("updatePatient", params), true); // to set transation number in the session
                xhttp.send();

                xhttp.onreadystatechange = function ()
                {

                    if (xhttp.readyState === 4 && xhttp.status === 200)
                    {
                        var data = xhttp.responseText;
                        if (data === "Done") {
                            alert("Data Updated...!");
                            loadPatientData();
                        } else if (data === "NotDone") {
                            alert("Error...!");
                        }

                    }
                };
            }

