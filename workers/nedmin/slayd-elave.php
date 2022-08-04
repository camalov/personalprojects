<?php include 'input-security/security.php'; ?>

<?php include 'header.php'; ?>

<?php include 'sidebar.php'; ?>

<?php include 'netting/baglan.php' ?>

<?php 

	$menyular=mysql_query("select * from menyular");

	$menyu_cek=mysql_fetch_assoc($menyular);

?>

  <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-head-line">Yeni slayd əlavə edirsiniz</h1>
                          
                          <?php 


                            if($_GET['saxlandi']==ok)
                            { ?>
                              <h1 style="color:green;" class="page-subhead-line">Yeni  slayd əlavə edildi</h1>
                            
                              <?php }     

                                 

                                 else if($_GET['saxlandi']==no)

                                    { ?>

                                    <h1 style="color:red;" class="page-subhead-line">Yeni slayd əlavə edilmədi !</h1>
                                      <?php } 

                                      

                                        else { ?>


                                          <h1 style="" class="page-subhead-line">Bu səhifədə saytınıza yeni slaydlar əlavə edə bilərsiziniz</h1>


                                        <?php } ?>
                                      </div>
                                    </div>
                

                <!-- /. ROW  -->

            
          <form  action="netting/emeliyyatlar.php" method="POST" enctype="multipart/form-data" >
			         
               <div class="col-md-12" >
                <div class="form-group; col-md-6">
                  <label class="control-label col-md-6">Slayd şəkili yükləyin</label>
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





              <div class="col-md-12" >
             	 <div  class="form-group col-md-6">
                 	 <label>Slayd adı</label>
                    	<input class="form-control" type="text" name="slider_ad" required="" placeholder="Yeni slayd adı daxil edin">
              	  </div>
                </div>  


               <div class="col-md-12" >
                <div  class="form-group col-md-6">
                   <label>Slayd linki</label>
                      <input class="form-control" type="text" name="slider_url" placeholder="Slayd ünvanı">
                  </div>
              </div>


               <div class="col-md-12" >
                <div  class="form-group col-md-4">
                   <label>Slayd sırası</label>
                      <input class="form-control" type="number" name="slider_sira" placeholder="Slayd neçənci sırada olsun?">
                  </div>
              </div>


            <div style="margin-left:370px;" class="col-md-6">  
            <div class="form-group col-md-3">
                   <input style="width:100%" class="btn btn-success" type="submit" name="slider_elave_et" value="Əlavə et">
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


