<?php

$conn = mysqli_connect("localhost","root","Samarpan","employee_db");

if(!$conn){
die("Connection Failed: " . mysqli_connect_error());
}

?>