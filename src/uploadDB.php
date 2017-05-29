<?php
$tmp_file_path = "uploads/DB.txt";
$myfile = fopen($tmp_file_path, "w") or die("Unable to open file!");
$txt = $_POST["url"] . "\n" . $_POST["user"] . "\n" . $_POST["password"];
fwrite($myfile, $txt);
fclose($myfile);
echo "The resource " . $_POST["url"] . " has been referenced.";
echo '<form action="index.php"><input type="submit" value="Go Back" /></form>';
exec('java -cp "java/bin/:java/lib/poi-3.15/*:java/lib/apache-jena-3.2.0/lib/*:java/lib/poi-3.15/ooxml-lib/*:java/lib/poi-3.15/lib/*:java/lib/mysql-connector-java-5.1.42/*" rfp.ResourceToOnto --db "' . $tmp_file_path . '" > java-debug.log');
unlink($tmp_file_path);
?>
