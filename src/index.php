<!DOCTYPE html>
<html>
<body onload="showExcel()">

<script type="text/javascript">
function showExcel()
{
	document.getElementById("excel_div").style.display = 'block';

	document.getElementById("db_div").style.display = 'none';
	document.getElementById("html_div").style.display = 'none';
	document.getElementById("service_div").style.display = 'none';
}
function showDB()
{
	document.getElementById("db_div").style.display = 'block';

	document.getElementById("excel_div").style.display = 'none';
	document.getElementById("html_div").style.display = 'none';
	document.getElementById("service_div").style.display = 'none';
}
function showHTML()
{
	document.getElementById("html_div").style.display = 'block';

	document.getElementById("excel_div").style.display = 'none';
	document.getElementById("db_div").style.display = 'none';
	document.getElementById("service_div").style.display = 'none';
}
function showService()
{
	document.getElementById("service_div").style.display = 'block';

	document.getElementById("excel_div").style.display = 'none';
	document.getElementById("db_div").style.display = 'none';
	document.getElementById("html_div").style.display = 'none';
}
</script>

<input type="radio" name="resource-type" value="excel" onclick="showExcel()" checked> Excel
<input type="radio" name="resource-type" value="db" onclick="showDB()"> DataBase
<input type="radio" name="resource-type" value="html" onclick="showHTML()"> HTML
<input type="radio" name="resource-type" value="service" onclick="showService()"> Service

<!-- Excel -->
	<div id="excel_div">
	<form action="uploadExcel.php" method="post" enctype="multipart/form-data">
	Select resource to reference:<br/>
	<input type="file" name="fileToUpload" id="fileToUpload"></br/>

	<input type="submit" value="Reference This Resource" name="submit">

	</form>
	</div>


<!-- DB -->
	<div id="db_div">
	<form action="uploadDB.php" method="post" enctype="multipart/form-data">
	Enter login and password:<br/>
	<label for"url" id="url_label"> url : </label>
	<input type="text" name="url" id="url"/><br/>

	<label for"user" id="user_label"> userName : </label>
	<input type="text" name="user" id="user"/><br/>

	<label for"password" id="password_label"> password : </label>
	<input type="password" name="password" id="password"/><br/>
	<input type="submit" value="Reference This Resource" name="submit">

	</form>
	</div>

<!-- HTML -->
	<div id="html_div">
	<form action="uploadHTML.php" method="post" enctype="multipart/form-data">
	Select HTML resource to reference:<br/>
	<input type="file" name="fileToUpload" id="fileToUpload"></br/>
	<input type="submit" value="Reference This Resource" name="submit">

	</form>
	</div>

<!-- Service -->
	<div id="service_div">
	</div>


</body>
</html>
