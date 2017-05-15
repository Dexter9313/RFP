<!DOCTYPE html>
<html>
<body>

<form action="upload.php" method="post" enctype="multipart/form-data">
    Select resource to reference:<br/>
    <input type="file" name="fileToUpload" id="fileToUpload"></br/>
    <input type="submit" value="Reference This Resource" name="submit">
</form>

<form action="upload.php" method="post" enctype="multipart/form-data">
    Enter login and password:<br/>
    <label for"url"> url : </label>
    <input type="text" name="url" id="url"/><br/>

    <label for"user"> userName : </label>
    <input type="text" name="user" id="user"/><br/>

    <label for"password"> password : </label>
    <input type="password" name="password"/><br/>

    <input type="submit" value="Reference This Resource" name="submit">
</form>


</body>
</html>
