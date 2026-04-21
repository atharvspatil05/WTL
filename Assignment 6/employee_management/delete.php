<?php

include 'db.php';

$id = $_GET['id'];

$sql = "DELETE FROM employees WHERE id=$id";

mysqli_query($conn,$sql);

header("Location:index.php");

?>