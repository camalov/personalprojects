<?php include 'header.php'; include 'netting/baglan.php';

$message_id=$_GET['message_id'];
$mesaj_sorgula=mysql_query("select * from elaqe where message_id='".$message_id."' "); 
$mesaj_cek=mysql_fetch_assoc($mesaj_sorgula);

$i=$mesaj_cek['message_read'];
++$i;
$edit=mysql_query("update elaqe set message_read='".$i."' where message_id='".$message_id."' ");
?>
<body>
    <div id="wrapper">

        <!-- /. NAV TOP  -->
<?php include 'sidebar.php' ?>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-head-line">Mesaj</h1>
                        <h1 class="page-subhead-line"><?php echo "Göndərilmə tarixi: ".$mesaj_cek['upload_time']; ?></h1>

                    </div>
                </div>
                <!-- /. ROW  -->
 
               <div class="row">
                   <div class="col-md-12">

                        <div class="panel panel-success">
                            <div class="panel-heading">
                                <?php $mesaj_sorgula=mysql_query("select * from elaqe where message_id='".$message_id."' "); $mesaj_cek=mysql_fetch_assoc($mesaj_sorgula); ?>
                               <?php echo $mesaj_cek['message_movzu'] ?>
                            </div>
                            <div class="panel-body" style="padding: 0px;">
                                <div class="chat-widget-main">
                                    <?php $mesaj_sorgula=mysql_query("select * from elaqe where message_id='".$message_id."'"); ?>
                                    <?php while($mesaj_cek=mysql_fetch_assoc($mesaj_sorgula)){ ?>
                                    <div class="chat-widget-left">
                                        <?php echo $mesaj_cek['message']; ?>
                                    </div>
                                    <div class="chat-widget-name-left">
                                        <h4><?php echo $mesaj_cek['message_ad'] ?></h4>
                                    </div>
                                    <?php } ?>
                                </div>
                            </div>

                <div class="row">
                    <div class="col-md-12">
                      <div class="panel panel-default">
                        <div class="panel-heading">
                            Təfərrüatlar
                        </div>
                        <div class="panel-body">
                            <ul class="media-list">
                        <li class="media">
        <a class="pull-left" " href="#" >
          <img class="media-object img-circle" src="assets/img/profile.jpeg" style="width:70px; height:65px">
        </a>
        <div class="media-body">
            <?php $mesaj_sorgula=mysql_query("select * from elaqe where message_id='".$message_id."' "); $mesaj_cek=mysql_fetch_assoc($mesaj_sorgula); ?>
            <h4 class="media-heading"><?php echo $mesaj_cek['message_ad']." tərəfindən göndərildi."?></h4>
          <p>
               Əlaqə vasitələri. <br>
               Telefon nömrəsi: <?php echo $mesaj_cek['message_telefon'] ?>
               <br>E-Poçt ünvanı: <?php echo $mesaj_cek['message_email'] ?>
               <br>Göndərilmə tarixi: <?php echo $mesaj_cek['upload_time'] ?>
          </p>
            </div>
                            </li>
                    



                    </div>
                            </div>
                        </div>


                    </div>
                   </div>
                     </div>
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->

<?php include 'footer.php' ?>

</body>
</html>
