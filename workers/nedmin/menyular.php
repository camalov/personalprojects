<?php 

ob_start();
session_start();

include 'input-security/security.php';

include 'header.php'; 

include 'sidebar.php'; 

include 'netting/baglan.php';

if(!isset($_SESSION['userinfo']))
{
    header("Location:login.php");
}


?>



  <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-head-line">Menyular</h1>
                        <h1 class="page-subhead-line">Saytınızdakı menyu keçidlərini bu səhifədə idarə edə bilərsiniz. </h1>
                    </div>
                    
                    <!-- Menyula Basladi -->

                    <div class="col-md-12">

                       <a href="menyu-elave.php"><button class="btn btn-success type="" >Menyu əlavə et</button></a>
                        <hr>


                    </div>
                    

                    <div class="col-md-12">
                     <!--    Hover Rows  -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Hazırda mövcud olan menyularınız
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive col-md-12">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th style="width:400px;">Menyu adı</th>
                                            <th>Menyu linki</th>
                                            <th style="width: 40px;"></th>
                                            <th style="width: 40px;"></th>
                                        </tr>
                                    </thead>
                                    
                                    <tbody>
                                    
                                    <?php 

                                    $menyular=mysql_query("select * from  menyular");

                                    while ($menyu_cek=mysql_fetch_assoc($menyular)) { ?>

                                        <tr>
                                            <td><?php echo $menyu_cek['menyu_id'] ?></td>
                                            <td><?php echo $menyu_cek['menyu_ad'] ?></td>
                                            <td><?php echo $menyu_cek['menyu_url'] ?></td>
                                            <td><a href="menyu-deyisdir.php?menyu_id=<?php echo $menyu_cek['menyu_id'] ?>"><button class="btn btn-primary type="" >Redaktə et</button></a></td>
                                            <td><a href="netting/emeliyyatlar.php?menyu_id=<?php echo $menyu_cek['menyu_id'] ?>&menyusilindi=ok"<button class="btn btn-danger type="" >Sil</button></a></td>
                                        </tr>

                                    <?php } ?>
                                    


                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- Sonluq -->
                </div>

                <!--Bitis -->




                </div>
                <!-- /. ROW  -->
                <div class="row">
                    <div class="col-md-12">
                        <!--<div class="alert alert-info">
                            This is a free responsive admin under cc3.0 license, so you can use it for personal and commercial use.
                          <br />
                            Enjoy this admin and for more please keep looking <a href="http://www.binarytheme.com/" target="_blank">BinaryTheme.com</a>
                        </div>-->
                    </div>
                </div>

            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->









<?php include 'footer.php'; ?>


