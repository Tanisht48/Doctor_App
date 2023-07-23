<h1 align = "center"> Doctor Appointment </h1>

<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.0.6-brightgreen.svg" />
</a>

<a >
    <img alt="MySQL" src="https://img.shields.io/badge/MySQL-blue.svg">
</a>
</p>

This project is a Doctor Appointment Booking Service API that allows patients to schedule Appointments according to there health issues. 

---
<br>

## Framework Used
* Spring Boot

---
<br>

## Dependencies
The following dependencies are required to run the project:

* Spring Boot Dev Tools
* Spring Web
* Spring Data JPA
* MySQL Driver
* Lombok
* Validation

<br>

## Language Used
* Java

---
<br>

## Data Model

<br>

* Patient
``` 
    patientId;
    patientName;
    patientEmail;
    patientPassword;
    patientAge;
    patientAddress;
    patientGender;
 ```   
* Doctor
```
    doctorId;
    doctorName;
    pecialization;
    doctorContactNumber;
    qualification;
    doctorConsultationFee;
```
* Appointment
```
     appointmentId;
     appointmentDesc;
     appointmentScheduleTime;
     JsonProperty.Access.READ_ONLY)
     appointmentCreationTime;
```
* Admin
```
    adminId;
    adminName;
    adminEmail;
    adminPassword;
```
* AuthenticationToken
```
     tokenId;
     tokenValue;
     tokenCreationDateTime;
```
## Controller
* PatientController Api Endpoints
```
    @PostMapping("patient/signup") 
    @PostMapping("patient/signIn")
    @DeleteMapping("patient/signOut")
    @PostMapping("appointment/schedule")
    @DeleteMapping("appointment/cancel")
 
```
* DoctorController Api Endpoints
```
    @PostMapping("add/doctor")
    @GetMapping("doctors")
   
```
*  AdminController Api EndPoints
```
    @PostMapping("admin")
    @GetMapping("patients")
    @GetMapping("patients/Gender")
    @GetMapping("doctors/specialization")
    @PutMapping("reschedule")
   ```

<br>

## DataBase Used
* SQL database
```
We have used Persistent database to implement CRUD Operations.
```
---
<br>

####  Overall, the code structure follows the MVC (Model-View-Controller) pattern commonly used in Spring Boot applications. The controllers handle HTTP requests, the services handle the business logic, and the repositories handle the database operations.

---