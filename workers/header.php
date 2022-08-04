<?php 

include 'nedmin/netting/baglan.php';
include 'nedmin/function.php';

$parametr=mysql_query("select * from parametrler");
$parametr_cek=mysql_fetch_assoc($parametr);

?>

<!DOCTYPE html>
<html lang="en">
<head>
<title><?php echo $parametr_cek['parametr_title'] ?></title>
<base href="http://localhost/oyrenirem/Layihelerim/temirci/">
<meta charset="utf8_turkish_ci">

  <meta name="'description'" content="<?php echo $parametr_cek['parametr_description']?>">
  <meta name="keywords" content="<?php echo $parametr_cek['parametr_keywords'] ?>">
  <meta name="author" content="C-DATA Yazılım">

<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen">
<script src="js/jquery-1.6.3.min.js"></script>
<script src="js/cufon-yui.js"></script>
<script src="js/cufon-replace.js"></script>

<script src="js/FF-cash.js"></script>
<script src="js/script.js"></script>
<script src="js/jquery.equalheights.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/tms-0.3.js"></script>
<script src="js/tms_presets.js"></script>
<script src="js/easyTooltip.js"></script>

<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen">
<![endif]-->
</head>

<!--    Bu hisse ile mutleq isle! Bura home page'n arxa plan movzusudur...
<style>

body{

background-image: url(images/home.jpg);
background-attachment: fixed;
-o-background-size:100% 100%;
-moz-background-size:100% 100%;
background-size:100% 100%;
}
-->

</style>

<body id="page1">
<div class="extra">
  <div class="main">
    <!--==============================header=================================-->
    <header>
      <div class="indent">
        <div class="row-top">
          <div class="wrapper">
            <img style="margin-top:30px; margin-left:20px;" src="images/logo.png" alt="" >
            <strong class="support"><?php echo $parametr_cek['parametr_telefon']; ?></strong> </div>
        </div>
       

        <nav>
           <ul class="menu">
            <li><a class="active" href="index.php">Home</a></li>
          
            <?php  

            $menyular=mysql_query("select * from menyular");

            while($menyu_cek=mysql_fetch_assoc($menyular)) { ?>

              <li> <a href= "<?php echo $menyu_cek['menyu_url'] ?>" ><?php echo $menyu_cek['menyu_ad']; ?></a></li>

            <?php } ?>
          </ul>
      </nav>
     </div>
     
    

    </header>

