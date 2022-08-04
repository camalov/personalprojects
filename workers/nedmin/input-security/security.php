<?php 

ob_start();
session_start();

if(!$_SESSION['userinfo']){


	header("Location:logout.php");
}

?>