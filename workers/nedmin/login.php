<?php 

ob_start();
session_start();

if(isset($_SESSION['userinfo'])){


  header("Location:index.php");
}

?>



<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Daxil ol</title>

  <!-- BOOTSTRAP STYLES-->
  <link href="assets/css/bootstrap.css" rel="stylesheet" />
  <!-- FONTAWESOME STYLES-->
  <link href="assets/css/font-awesome.css" rel="stylesheet" />
  <!-- GOOGLE FONTS-->
  <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

  <style>
body{

  background-image: url(assets/img/bg.jpg);
  background-attachment:fixed;
  -moz-background-size:100% 100%;
  -o-background-size:100% 100%;
  -webkit-
  background-size:100% 100%;


  </style>
</head>
<body >
    <div class="container">
        <div class="row text-center " style="padding-top:100px;">
            <div class="col-md-12">
         <!--       <img src="assets/img/logo-invoice.png" />   -->  
            </div>
        </div>
        <div class="row ">

            <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">

                <div style="background-color:white; border-radius:15px; margin-top:95px; opacity:0.8" class="panel-body">
                    <form action="netting/emeliyyatlar.php" method="POST">
                        <hr />
                        <center><h3><strong>Admin Giriş</strong></h3></center>
                        <?php

                        if($_GET['login']=='no'){ 

                          echo "İstifadəçi adınızı, və yaxud şifrənizi yanlış daxil etdiniz." ?>

                        <br>
                      <?php } ?>
                      
                      <br />
                        <div class="form-group input-group">
                            <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                            <input type="text" class="form-control" required="" name="admin_login" placeholder="İstifadəçi adnız" autofocus="" />
                        </div>
                        <div class="form-group input-group">
                            <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                            <input type="password" class="form-control" required="" name="admin_sifre"  placeholder="Şifrəniz" />
                        </div>
                        <div class="form-group">
                       <!--     <label class="checkbox-inline">
                                <input type="checkbox" /> Remember me
                            </label> -->
                      <!--      <span class="pull-right">
                             <a href="index.html" >Forget password ? </a> 
                         </span> -->
                     </div>

                     
                     <button style="width:100%" class ="btn btn-primary" type="submit" name="userinfo" >Daxil ol</button>
                 <!--     <hr />
                     Not register ? <a href="index.html" >click here </a> or go to <a href="index.html">Home</a>    -->
                 </form>
             </div>

         </div>


     </div>
 </div>

</body>
</html>
