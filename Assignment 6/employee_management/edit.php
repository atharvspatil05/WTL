<?php
include 'db.php';

$id=$_GET['id'];

$result=mysqli_query($conn,"SELECT * FROM employees WHERE id=$id");
$row=mysqli_fetch_assoc($result);

if(isset($_POST['update']))
{

$employee_id=$_POST['employee_id'];
$name=$_POST['name'];
$email=$_POST['email'];
$department=$_POST['department'];
$salary=$_POST['salary'];

$sql="UPDATE employees SET
employee_id='$employee_id',
name='$name',
email='$email',
department='$department',
salary='$salary'
WHERE id=$id";

mysqli_query($conn,$sql);

header("Location:index.php");

}
?>

<!DOCTYPE html>
<html>
<head>

<title>Edit Employee</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="card shadow">

<div class="card-header bg-warning">

<h4>Edit Employee</h4>

</div>

<div class="card-body">

<form method="POST">

<div class="mb-3">
<label>Employee ID</label>
<input type="text" name="employee_id" class="form-control" value="<?php echo $row['employee_id']; ?>">
</div>

<div class="mb-3">
<label>Name</label>
<input type="text" name="name" class="form-control" value="<?php echo $row['name']; ?>">
</div>

<div class="mb-3">
<label>Email</label>
<input type="email" name="email" class="form-control" value="<?php echo $row['email']; ?>">
</div>

<div class="mb-3">
<label>Department</label>
<input type="text" name="department" class="form-control" value="<?php echo $row['department']; ?>">
</div>

<div class="mb-3">
<label>Salary</label>
<input type="number" name="salary" class="form-control" value="<?php echo $row['salary']; ?>">
</div>

<button type="submit" name="update" class="btn btn-warning">Update</button>

<a href="index.php" class="btn btn-secondary">Back</a>

</form>

</div>

</div>

</div>

</body>
</html>