<?php 
	
	include 'netting/baglan.php';

	$admin_melumat=mysql_query("select * from admin");
	$admin_melumat_cek=mysql_fetch_assoc($admin_melumat);
	$admin_login=$admin_melumat_cek['admin_login'];
	$time_set=date_default_timezone_set("Asia/Baku");
	$just_time = date("Y:m:d H:i");
	$son_gorulmeni_yenile=mysql_query("update admin set admin_son_gorulme='".$just_time."' where admin_login='".$admin_login."'");


session_start();
session_destroy();
 
header("Location:login.php");

?>