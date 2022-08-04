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
                        <h1 class="page-head-line">Səhifələr</h1>
                        <h1 class="page-subhead-line">Saytınızdakı səhifələri bu bölmədə idarə edə bilərsiniz. </h1>
                    </div>
                    
                    <!-- Menyula Basladi -->

                    <div class="col-md-12">

                       <a href="sehife-elave.php"><button class="btn btn-success type="" >Səhifə əlavə et</button></a>
                        <hr>


                    </div>
                    

                    <div class="col-md-12">
                     <!--    Hover Rows  -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Hazırda mövcud olan səhifələr
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive col-md-12">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th style="width:190px;">Səhifə adı</th>
                                            <th>Əsas səhifədə göstərilir</th>
                                            <th>Əlavə edilmə tarixi</th>
                                            <th style="width: 40px;"></th>
                                            <th style="width: 40px;"></th>
                                        </tr>
                                    </thead>
                                    
                                    <tbody>
                                    
                                    <?php 

                                    $sehifeler=mysql_query("select * from  sehifeler");

                                    while ($sehife_cek=mysql_fetch_assoc($sehifeler)) { ?>

                                        <tr>
                                            <td><?php echo $sehife_cek['sehife_id'] ?></td>
                                            <td><?php echo $sehife_cek['sehife_ad'] ?></td>
                                            <td><?php if($sehife_cek['basic_page']==1){ echo "Bəli"; }else if($sehife_cek['basic_page']==0){ echo "Xeyr"; } ?></td>
                                            <td><?php echo $sehife_cek['sehife_tarixi'] ?></td>
                                            <td><a href="sehife-redakte.php?sehife_id=<?php echo $sehife_cek['sehife_id'] ?>"><button class="btn btn-primary type="" >Redaktə et</button></a></td>
                                            <td><a href="netting/emeliyyatlar.php?sehife_id=<?php echo $sehife_cek['sehife_id'] ?>&sehifesilindi=ok"<button class="btn btn-danger type="" >Sil</button></a></td>
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


