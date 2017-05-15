<!DOCTYPE html>
<html>
<body onload="showExcel()">

<script type="text/javascript">
	function showExcel()
	{
		document.getElementById("excel_div").style.display = 'block';

		document.getElementById("db_div").style.display = 'none';
	}
	function showDB()
	{
		document.getElementById("db_div").style.display = 'block';

		document.getElementById("excel_div").style.display = 'none';
	}
</script>

<form action="upload.php" method="post" enctype="multipart/form-data">
    <input type="radio" name="resource-type" value="excel" onclick="showExcel()" checked> Excel
    <input type="radio" name="resource-type" value="db" onclick="showDB()"> DataBase
    <input type="radio" name="resource-type" value="html"> HTML
    <input type="radio" name="resource-type" value="service"> Service

<!-- Excel -->
    <div id="excel_div">
    Select resource to reference:<br/>
    <input type="file" name="fileToUpload" id="fileToUpload"></br/>
    </div>


<!-- DB -->
    <div id="db_div">
    Enter login and password:<br/>
    <label for"url" id="url_label"> url : </label>
    <input type="text" name="url" id="url"/><br/>

    <label for"user" id="user_label"> userName : </label>
    <input type="text" name="user" id="user"/><br/>

    <label for"password" id="password_label"> password : </label>
    <input type="password" name="password" id="password"/><br/>
    </div>

<!-- Common -->
    <input type="submit" value="Reference This Resource" name="submit">

</form>


</body>
</html>
