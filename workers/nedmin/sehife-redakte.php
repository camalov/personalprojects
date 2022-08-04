<?php include 'input-security/security.php'; ?>

<?php include 'header.php'; ?>

<?php include 'sidebar.php'; ?>

<?php include 'netting/baglan.php' ?>

<?php 

  $sehife_id=$_GET['sehife_id'];
  
	$sehifeler=mysql_query("select * from sehifeler where sehife_id='$sehife_id';");

	$sehife_cek=mysql_fetch_assoc($sehifeler);

?>

<head>

  <script src="//cdn.ckeditor.com/4.5.11/standard/ckeditor.js"></script>

</head>
  <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-head-line">Səhifədə düzəliş edirsiniz</h1>
                          
                          <?php 


                            if($_GET['saxlandi']==ok)
                            { ?>
                              <h1 style="color:green;" class="page-subhead-line">Yadda saxlandı</h1>
                            
                              <?php }     

                                 

                                 else if($_GET['saxlandi']==no)

                                    { ?>

                                    <h1 style="color:red;" class="page-subhead-line">Yadda saxlanmadı !</h1>
                                      <?php } 

                                      

                                        else { ?>


                                          <h1 style="" class="page-subhead-line">Bu səhifədə saytınızda mövcud olan səhifələrdə düzəliş edə bilərsiniz</h1>


                                        <?php } ?>


                                       



                    </div>
                </div>
                <!-- /. ROW  -->
               



             
              <form  action="netting/emeliyyatlar.php" method="post">
			       <div class="col-md-12"> 	       		
             	 <div  class="form-group col-md-6">
                 	 <label>Səhifə adı</label>
                    	<input class="form-control" type="text" name="sehife_ad" required="" value="<?php echo $sehife_cek['sehife_ad'] ?>">
              	  </div>
                </div>

                <input type="hidden" name="sehife_id" value="<?php echo $sehife_cek['sehife_id'] ?>">
      
                <div class="col-md-12" >
                <div  class="form-group col-md-12">
                   <label>Sehife mezmunu</label>
                      <textarea class="ckeditor" name="sehife_mezmunu"><?php echo $sehife_cek['sehife_mezmunu'] ?></textarea>
                  </div>
              </div>

             <div class="col-md-12">            
               <div  class="form-group col-md-2">
                   <label>Səhifə sırası</label>
                      <input class="form-control" type="text" name="sehife_sira" value="<?php echo $sehife_cek['sehife_sira'] ?>">
                  </div>
                </div>

              <div class="col-md-12" >
                <div class="form-group col-md-6">
                  <label>Əsas səhifədə göstərilsin?</label>
                   <select class="form-control" name="basic_page">
                    <?php 

                      if($sehife_cek['basic_page']==0){ ?>

                              <option  value="0" >Xeyr</option>
                              <option value="1" >Bəli</option>

                        <?php  } else if($sehife_cek['basic_page']==1){ ?>

                              <option value="1" >Bəli</option>
                              <option  value="0" >Xeyr</option>
                              
                           <?php } ?>
                  </select>
                 </div>
               </div>

            <div style="margin-left:353px;" class="col-md-7">  
            <div class="form-group col-md-3">
                   <input style="width:100%" class="btn btn-success" type="submit" name="sehife-redakte" value="Yadda saxla">
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


