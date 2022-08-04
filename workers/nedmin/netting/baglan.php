<?php  
ob_start();
session_start();
?>


<?php 

$username="root";
$password="123456789az";
$server="localhost";
$database="temirci";

$baglan=mysql_connect($server, $username, $password);
mysql_query("SET NAMES UTF8");

if(!$baglan)
{

	echo "Diqqət! Bağlantıda səhv var. İstifadəçi adı, və parolun dəqiqliyini bir daha yoxlayın!"."<br>Səhv: ".mysql_errno();
	exit();

}

$db=mysql_select_db($database);

if(!$db)
{
	echo "Diqqət! Verilənlər bazasının adı düzgün qeyd edilməyib!"."<br>Səhv:".mysql_error();
	exit();
}


?>