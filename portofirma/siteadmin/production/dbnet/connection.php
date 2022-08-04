<?php 

try {

	$db = new PDO("mysql:host=localhost; dbname=pdocompany", 'root', '123456789az');
	
} catch (PDOException $e) {

	echo $e->getMessage();
					
}

?>