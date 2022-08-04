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
                        <h1 class="page-head-line">Blog</h1>
                        <h1 class="page-subhead-line">Saytınızdakı xəbərləri bu bölmədə idarə edə bilərsiniz. </h1>
                    </div>
                    
                    <!-- Menyula Basladi -->

                    <div class="col-md-12">

                       <a href="xeber-elave.php"><button class="btn btn-success type="" >Xəbər əlavə et</button></a>
                        <hr>


                    </div>
                    

                    <div class="col-md-12">
                     <!--    Hover Rows  -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Hazırda mövcud olan xəbərlər
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive col-md-12">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th style="width:190px;">Xəbər adı</th>
                                            <th>Əlavə edilmə tarixi</th>
                                            <th>Oxunma sayı</th>
                                            <th style="width: 20px;"></th>
                                            <th style="width: 20px;"></th>
                                        </tr>
                                    </thead>
                                    
                                    <tbody>
                                    
                                    <?php 

                                    $xeberler=mysql_query("select * from  xeberler");

                                    while ($xeber_cek=mysql_fetch_assoc($xeberler)) { ?>

                                        <tr>
                                            <td><?php echo $xeber_cek['xeber_id'] ?></td>
                                            <td><?php echo substr($xeber_cek['xeber_ad'], 0, 30)."..." ?></td>
                                            <td><?php echo $xeber_cek['xeber_tarix'] ?></td>
                                            <td><?php echo $xeber_cek['xeber_xit'] ?></td>
                                            <input type="hidden" name="xeber_sekilyolu" value="<?php echo $xeber_cek['xeber_sekilyolu'] ?>">
                                            <td><a href="xeber-redakte.php?xeber_id=<?php echo $xeber_cek['xeber_id'] ?>"><button class="btn btn-primary type="" >Redaktə et</button></a></td>
                                            <td><a href="netting/emeliyyatlar.php?xeber_id=<?php echo $xeber_cek['xeber_id'] ?>&xeber_silindi=ok"<button class="btn btn-danger type="" >Sil</button></a></td>
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


