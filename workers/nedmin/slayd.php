<?php 

ob_start();
session_start();

include 'input-security/security.php';

include 'header.php'; 

include 'sidebar.php'; 

include 'netting/baglan.php';


?>



  <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-head-line">SLAYD</h1>
                        <h1 class="page-subhead-line">Saytınızdakı slayd'ları bu səhifədə idarə edə bilərsiniz. </h1>
                    </div>
                    
                    <!-- Menyula Basladi -->

                    <div class="col-md-12">

                       <a href="slayd-elave.php"><button class="btn btn-success type="" >Slyad əlavə et</button></a>
                        <hr>


                    </div>
                    

                    <div class="col-md-12">
                     <!--    Hover Rows  -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Mövcud slayd'lar
                        </div>
                        <div class="panel-body" style="">
                           <div class="table-responsive col-md-12">
                                <table class="table table-hover" style="margin-top:-135px;">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Slayd adı</th>
                                            <th>Slayd mövzusu</th>
                                            <th>Slayd linki</th>
                                            <th>Slayd sırası</th>
                                            <th style="width: 40px;"></th>
                                            <th style="width: 40px;"></th>
                                        </tr>
                                    </thead>
                                    
                                    <tbody>
                                    
                                    <?php 

                                    $slider=mysql_query("select * from  slider");

                                    while ($slider_cek=mysql_fetch_assoc($slider)) { ?>

                                        <tr>
                                            <form action="netting/emeliyyatlar.php" method="POST">
                                            <td><?php echo $slider_cek['slider_id'] ?></td>
                                            <td><?php echo $slider_cek['slider_ad'] ?></td>
                                            <td><img style="margin-left:-35px;" width=200; src="<?php echo $slider_cek['slider_sekilyolu']?>" ><?php if($slider_cek['slider_url']){ ?> <img style="margin-left:-4px;" width=200; height="120" src="<?php echo $slider_cek['slider_url']?>" > <?php } ?></td>
                                            <td><input type="textarea" name="" value="<?php echo $slider_cek['slider_url'] ?>" ></td>
                                            <td><?php echo $slider_cek['slider_sira'] ?></td>

                                            <input type="hidden" name="slayd_silinme_id" value="<?php echo $slider_cek['slider_id'] ?>">
                                            <input type="hidden" name="slayd_deyisme_id" value="<?php echo $slider_cek['slider_id'] ?>">
                                            <input type="hidden" name="slider_ad" value="<?php echo $slider_cek['slider_ad'] ?>">
                                            <input type="hidden" name="slider_sekilyolu" value="<?php echo $slider_cek['slider_sekilyolu'] ?>">
                                            <input type="hidden" name="slider_url" value="<?php echo $slider_cek['slider_url'] ?>">
                                            <input type="hidden" name="slider_sira" value="<?php echo $slider_cek['slider_sira'] ?>">
                                            <td><a><button class="btn btn-danger type="submit" name="slaydsil"  >Sil</button></a></td>      
                                            </form>
                                            <td><a href="slayd-deyisdir.php?$slider_id=<?php echo $slider_cek['slider_id'] ?>"><button class="btn btn-primary">Redaktə et</button></a></td>
                                            <br>
                                            <td><a href="slayd-movzu-deyis.php?$slider_id=<?php echo $slider_cek['slider_id'] ?>"><button class="btn btn-primary" style="margin-top:45px; margin-left:-190px;">Slayd mövzusunu dəyiş</button></a></td>


                                           
                                            
                                            

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
                        </div>  
                    </div> 
                </div>

            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
            </div>
                </div>
                 </div>








<?php include 'footer.php'; ?>


