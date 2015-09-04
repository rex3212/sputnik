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
		setDateProcessing();	
		setData();
		setUploadHandler();
	});

	setData = function(){
		$.getJSON( "/sputnik/rest/sputnikrest/showuser", function( data ) {
			$('#firstname').val(data['firstName']);
			$('#secondname').val(data['secondName']);
			$('#shurname').val(data['shurName']);
			$('#datepicker').val(data['dateOfBirth']);
		});
	}	
	
	setDateProcessing = function(){
		$("#datepicker").datepicker();
	}
	
	uploadDataToServer = function(){
		$.ajax({
			type:"POST",
			url: "/sputnik/rest/sputnikrest/saveuser",
			async:false,
			data: JSON.stringify({"firstName":$('#firstname').val(),"secondName":$('#secondname').val(), 
				"shurName":$('#shurname').val(),"dateOfBirth":$('#datepicker').val()}),
			contentType:"application/json",
			complete:function(data){}
		});
	}
	
	setUploadHandler = function(){
		$('#accept').on( "click", uploadDataToServer);	
	}
	
</script>
</head>

<body>
	<h2>Sputnik test task</h2>

	<form name="loginForm" method="post" action="mainform">
		First Name: <input type="text" id="firstname" name="firstName"  value='${user.getFirstName()}' />
		 <br /> Second Name: <input type="text" id="secondname" name="secondName"  value='${user.getSecondName()}' /> 
		 <br /> Shurname: <input type="text" name="shurName" id="shurname" value='${user.getShurName()}' /> 
		 <br /> Date: <input type="date" id="datepicker" name="dateOfBirth" value='${user.getDateOfBirth()}' />
		 		 
	</form>
	<br /> <input type="submit" id="accept" value="Save/Update user" />

</body>
</html>