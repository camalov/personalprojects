<?php include 'input-security/security.php'; ?>

<?php include 'header.php'; ?>

<?php include 'sidebar.php'; ?>

<?php include 'netting/baglan.php' ?>

<?php 

  $slayd_id=$_GET['$slider_id'];

	$slider=mysql_query("select * from slider where slider_id='$slayd_id'; ");

	$slider_cek=mysql_fetch_assoc($slider);

?>
  <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-head-line">Mövcud slayd'ı dəyişirsiniz</h1>
                          
                          <?php 


                            if($_GET['saxlandi']==ok)
                            { ?>
                              <h1 style="color:green;" class="page-subhead-line">Slayd mövzusu dəyişdirildi</h1>
                            
                              <?php }     

                                 

                                 else if($_GET['saxlandi']==no)

                                    { ?>

                                    <h1 style="color:red;" class="page-subhead-line">Slayd mövzusunu dəyişmək mümkün olmadı !</h1>
                                      <?php } 

                                      

                                        else { ?>


                                          <h1 style="" class="page-subhead-line">Bu səhifədə mövcud slayd'ı başqa slayd ilə dəyişdirə bilərsiziniz</h1>


                                        <?php } ?>
                                      </div>
                                    </div>
                

                <!-- /. ROW  -->


             <form  action="netting/emeliyyatlar.php" method="POST" enctype="multipart/form-data" >			         
                <div><img src="<?php echo $slider_cek['slider_sekilyolu']; ?>" class="fileupload-preview thumbnail" style="width: 200px; height: 150px; margin-left:25px; "></div>  
               <div class="col-md-12" >
                <div class="form-group; col-md-6">
                  <label class="control-label col-md-6">Mövcud slayd mövzunuz</label>
                    <div class="">
                      <div class="fileupload fileupload-new" data-provides="fileupload">
                        <div class="fileupload-preview thumbnail" style="width: 200px; height: 150px;"></div>
                          <div>
                            <span class="btn btn-file btn-success"><span class="fileupload-new">Şəkil seçin</span><span class="
                              fileupload-exists">Dəyiş</span><input type="file" name="slider_sekil"></span>
                                <a href="#" class="btn btn-danger fileupload-exists" data-dismiss="fileupload">Sil</a>
                                  </div>
                                   </div>
                                     </div>
                                       </div>
                                         </div>

              <input type="hidden" name="slider_id" value="<?php echo $slider_cek['slider_id'] ?>">
              <input type="hidden" name="slider_sekilyolu" value="<?php echo $slider_cek['slider_sekilyolu'] ?>">

            <div style="margin-left:370px;" class="col-md-6">  
            <div class="form-group col-md-4">
                 <a><input style="width:100%" class="btn btn-success" type="submit" name="slayd-movzu-deyisdir" value="Yadda saxla"></a>
            </div>
          </div>

               </form>
              

               </form>
             












              <!-- <div class="row">
                    <div class="col-md-12">
                        <div class="alert alert-info">
                            This is a free responsive admin under cc3.0 license, so you can use it for personal and commercial use.
                          <br />
                            Enjoy this admin and for more please keep looking <a href="http://www.binarytheme.com/" target="_blank">BinaryTheme.com</a>
                        </div>
                    </div> 
                </div> -->

            

            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->









<?php include 'footer.php'; ?>


