<html>
<head>
<meta charset="utf-8">
<title>Sputnik test task</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
</head>

<body>
	<h2>Sputnik test task</h2>

	<form name="loginForm" method="post" action="mainform">
		First Name: <input type="text" name="firstName"  value='${user.getFirstName()}' />
		 <br /> Second Name: <input type="text" name="secondName"  value='${user.getSecondName()}' /> 
		 <br /> Shurname: <input type="text" name="shurName" value='${user.getShurName()}' /> 
		 <br /> Date: <input type="date" id="datepicker" name="dateOfBirth" value='${user.getDateOfBirth()}' />
		 
		 <br /> <input type="submit" value="Save/Update user" />		 
	</form>

</body>
</html>
