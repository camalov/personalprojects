<?php include 'input-security/security.php'; ?>

<?php include 'header.php'; ?>

<?php include 'sidebar.php'; ?>

<?php include 'netting/baglan.php' ?>

<?php 

  $menyu_id=$_GET['menyu_id'];
  
	$menyular=mysql_query("select * from menyular where menyu_id='$menyu_id';");

	$menyu_cek=mysql_fetch_assoc($menyular);

?>

  <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-head-line">Menyuda düzəliş edirsiniz</h1>
                          
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


                                          <h1 style="" class="page-subhead-line">Bu səhifədə saytınızda mövcud olan menyularda düzəliş edə bilərsiniz</h1>


                                        <?php } ?>


                                       



                    </div>
                </div>
                <!-- /. ROW  -->
               



             
              <form  action="netting/emeliyyatlar.php" method="post">
			       <div class="col-md-12"> 	       		
             	 <div  class="form-group col-md-6">
                 	 <label>Menyu adı</label>
                    	<input class="form-control" type="text" name="menyu_ad" required="" value="<?php echo $menyu_cek['menyu_ad'] ?>">
              	  </div>
                </div>

                <input type="hidden" name="menyu_id" value="<?php echo $menyu_cek['menyu_id'] ?>">
      
                <div class="col-md-12" >
                <div  class="form-group col-md-6">
                   <label>Menyu linki</label>
                      <input class="form-control" type="text" name="menyu_url" required="" value="<?php echo $menyu_cek['menyu_url']  ?>">
                  </div>
              </div>

            <div style="margin-left:353px;" class="col-md-7">  
            <div class="form-group col-md-3">
                   <input style="width:100%" class="btn btn-success" type="submit" name="deyisdir" value="Yadda saxla">
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


