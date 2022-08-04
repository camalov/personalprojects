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
                        <h1 class="page-head-line">Yeni menyu əlavə edirsiniz</h1>
                          
                          <?php 


                            if($_GET['saxlandi']==ok)
                            { ?>
                              <h1 style="color:green;" class="page-subhead-line">Yeni  menyu əlavə edildi</h1>
                            
                              <?php }     

                                 

                                 else if($_GET['saxlandi']==no)

                                    { ?>

                                    <h1 style="color:red;" class="page-subhead-line">Yeni menyu əlavə edilmədi !</h1>
                                      <?php } 

                                      

                                        else { ?>


                                          <h1 style="" class="page-subhead-line">Bu səhifədə saytınıza yeni menyular əlavə edə bilərsiziniz</h1>


                                        <?php } ?>


                                       



                    </div>
                </div>
                <!-- /. ROW  -->
               



             
              <form  action="netting/emeliyyatlar.php" method="post">
			       <div class="col-md-12"> 	       		
             	 <div  class="form-group col-md-6">
                 	 <label>Menyu adı</label>
                    	<input class="form-control" type="text" name="menyu_ad" required="" placeholder="Yeni menyu adı daxil edin">
              	  </div>
                </div>


               <div class="col-md-12" >
                <div  class="form-group col-md-6">
                   <label>Menyu linki</label>
                      <input class="form-control" type="text" name="menyu_url" required="" value="http://">
                  </div>
              </div>

            <div style="margin-left:370px;" class="col-md-6">  
            <div class="form-group col-md-3">
                   <input style="width:100%" class="btn btn-success" type="submit" name="elave_et" value="Əlavə et">
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


