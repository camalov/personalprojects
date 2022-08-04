<?php include 'input-security/security.php'; ?>

<?php include 'header.php'; ?>

<?php include 'sidebar.php'; ?>

<?php include 'netting/baglan.php' ?>

<?php 

  $xeber_id=$_GET['xeber_id'];
  
	$xeberler=mysql_query("select * from xeberler where xeber_id='$xeber_id';");

	$xeber_cek=mysql_fetch_assoc($xeberler);

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
                            {  ?>
                              <h1 style="color:green;" class="page-subhead-line">Yadda saxlandı</h1>
                            
                              <?php }     

                                 

                                 else if($_GET['saxlandi']==no)

                                    { ?>

                                    <h1 style="color:red;" class="page-subhead-line">Yadda saxlanmadı !</h1>
                                      <?php } 

                                      

                                        else { ?>


                                          <h1 style="" class="page-subhead-line">Bu səhifədə saytınızda mövcud olan xəbərlərdə düzəliş edə bilərsiniz</h1>

                                          <?php } ?>
                                        


                                       



                    </div>
                </div>
                <!-- /. ROW  -->
               



             
              <form  action="netting/emeliyyatlar.php" method="post">
             <div class="col-md-12"> 	       		
             	 <div  class="form-group col-md-6">
                 	 <label>Xəbər başlıq</label>
                    	<input class="form-control" type="text" name="xeber_ad" required="" value="<?php echo $xeber_cek['xeber_ad'] ?>">
              	  </div>
                </div>

                <input type="hidden" name="xeber_id" value="<?php echo $xeber_cek['xeber_id'] ?>">
      
                <div class="col-md-12" >
                <div  class="form-group col-md-12">
                   <label>Xəbər məzmunu</label>
                      <textarea class="ckeditor" name="xeber_mezmunu"><?php echo $xeber_cek['xeber_mezmunu'] ?></textarea>
                  </div>
              </div>



            <div style="margin-left:840px;" class="col-md-7">  
            <div class="form-group col-md-3">
                   <input style="width:100%" class="btn btn-success" type="submit" name="xeber_redakte" value="Yadda saxla">
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


