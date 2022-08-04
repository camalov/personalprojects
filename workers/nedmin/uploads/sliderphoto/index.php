<?php 

ob_start();
session_start();

if(!isset($_SESSION['userinfo'])){


	header("../../index.php");

}
else{};

?>