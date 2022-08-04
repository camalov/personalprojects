<?php 

try {

	$db = new PDO("mysql:host=localhost; dbname=sales", 'root', '123456789az');
	
} catch (PDOException $e) {

	echo $e->getMessage();
					
}

?>