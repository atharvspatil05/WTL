<?php
include 'db.php';

if(isset($_POST['submit']))
{

$employee_id=$_POST['employee_id'];
$name=$_POST['name'];
$email=$_POST['email'];
$department=$_POST['department'];
$salary=$_POST['salary'];

$sql="INSERT INTO employees(employee_id,name,email,department,salary)
VALUES('$employee_id','$name','$email','$department','$salary')";

mysqli_query($conn,$sql);

header("Location:index.php");

}
?>

<!DOCTYPE html>
<html>
<head>

<title>Add Employee</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="card shadow">

<div class="card-header bg-success text-white">

<h4>Add Employee</h4>

</div>

<div class="card-body">

<form method="POST">

<div class="mb-3">
<label>Employee ID</label>
<input type="text" name="employee_id" class="form-control" required>
</div>

<div class="mb-3">
<label>Name</label>
<input type="text" name="name" class="form-control" required>
</div>

<div class="mb-3">
<label>Email</label>
<input type="email" name="email" class="form-control" required>
</div>

<div class="mb-3">
<label>Department</label>
<input type="text" name="department" class="form-control">
</div>

<div class="mb-3">
<label>Salary</label>
<input type="number" name="salary" class="form-control">
</div>

<button type="submit" name="submit" class="btn btn-success">Add Employee</button>

<a href="index.php" class="btn btn-secondary">Back</a>

</form>

</div>

</div>

</div>

</body>
</html>