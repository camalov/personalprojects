<head>
	<script src="//cdn.ckeditor.com/4.5.11/standard/ckeditor.js"></script>
</head>

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
                        <h1 class="page-head-line">Yeni xəbər əlavə edirsiniz</h1>
                          
                          <?php 


                            if($_GET['saxlandi']==ok)
                            { ?>
                              <h1 style="color:green;" class="page-subhead-line">Yeni  xəbər əlavə edildi</h1>
                            
                              <?php }     

                                 

                                 else if($_GET['saxlandi']==no)

                                    { ?>

                                    <h1 style="color:red;" class="page-subhead-line">Yeni xəbər əlavə edilmədi !</h1>
                                      <?php } 

                                      

                                        else { ?>


                                          <h1 style="" class="page-subhead-line">Bu səhifədə saytınıza yeni xəbərlər əlavə edə bilərsiziniz</h1>


                                        <?php } ?>
                                      </div>
                                    </div>
                

                <!-- /. ROW  -->

            
          <form  action="netting/emeliyyatlar.php" method="POST" enctype="multipart/form-data" >
			         
               <div class="col-md-12" >
                <div class="form-group; col-md-6">
                  <label class="control-label col-md-6">Xəbər şəkili yükləyin</label>
                    <div class="">
                      <div class="fileupload fileupload-new" data-provides="fileupload">
                        <div class="fileupload-preview thumbnail" style="width: 200px; height: 150px;"></div>
                          <div>
                            <span class="btn btn-file btn-success"><span class="fileupload-new">Şəkil seçin</span><span class="
                              fileupload-exists">Dəyiş</span><input type="file" name="xeber_sekil"></span>
                                <a href="#" class="btn btn-danger fileupload-exists" data-dismiss="fileupload">Sil</a>
                                  </div>
                                   </div>
                                     </div>
                                       </div>
                                         </div>





              <div class="col-md-12" >
             	 <div  class="form-group col-md-5">
                 	 <label>Xəbər başlıq</label>
                    	<input class="form-control" type="text" name="xeber_ad" required="" placeholder="Yeni xəbər adı daxil edin">
              	  </div>
                </div>  


               <div class="col-md-12" >
                <div  class="form-group col-md-12">
                   <label>Xəbər məzmunu</label>
                      <textarea class="ckeditor" type="text" name="xeber_mezmunu"></textarea>
                  </div>
              </div>


            <div style="margin-left:737px;" class="col-md-12">  
            <div class="form-group col-md-3">
                   <input style="width:100%" class="btn btn-success" type="submit" name="xeber_elave_et" value="Əlavə et">
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
