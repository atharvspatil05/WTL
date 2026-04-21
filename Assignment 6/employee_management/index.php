<?php
include 'db.php';
?>

<!DOCTYPE html>
<html>
<head>

<title>Employee Management System</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="card shadow">

<div class="card-header bg-primary text-white d-flex justify-content-between">

<h4>Employee Management System</h4>

<a href="add.php" class="btn btn-light btn-sm">Add Employee</a>

</div>

<div class="card-body">

<table class="table table-bordered table-hover">

<thead class="table-dark">

<tr>
<th>Sr No.</th>
<th>Employee ID</th>
<th>Name</th>
<th>Email</th>
<th>Department</th>
<th>Salary</th>
<th>Action</th>
</tr>

</thead>

<tbody>

<?php

$sql = "SELECT * FROM employees";
$result = mysqli_query($conn,$sql);

$sr=1;

while($row=mysqli_fetch_assoc($result))
{

?>

<tr>

<td><?php echo $sr++; ?></td>

<td><?php echo $row['employee_id']; ?></td>

<td><?php echo $row['name']; ?></td>

<td><?php echo $row['email']; ?></td>

<td><?php echo $row['department']; ?></td>

<td><?php echo $row['salary']; ?></td>

<td>

<a href="edit.php?id=<?php echo $row['id']; ?>" class="btn btn-warning btn-sm">Edit</a>

<a href="delete.php?id=<?php echo $row['id']; ?>" 
class="btn btn-danger btn-sm"
onclick="return confirm('Delete this employee?')">
Delete
</a>

</td>

</tr>

<?php
}
?>

</tbody>

</table>

</div>

</div>

</div>

</body>
</html>