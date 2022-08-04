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
                              <h1 style="color:green;" class="page-subhead-line">Slayd parametrləri dəyişdirildi</h1>
                            
                              <?php }     

                                 

                                 else if($_GET['saxlandi']==no)

                                    { ?>

                                    <h1 style="color:red;" class="page-subhead-line">Slayd parametrlərini dəyişmək mümkün olmadı !</h1>
                                      <?php } 

                                      

                                        else { ?>


                                          <h1 style="" class="page-subhead-line">Bu səhifədə mövcud slayd parametrlərini redaktə edə bilərsiziniz</h1>


                                        <?php } ?>
                                      </div>
                                    </div>
                

                <!-- /. ROW  -->


             <form  action="netting/emeliyyatlar.php" method="POST">			         

              <div class="col-md-12" >
             	 <div  class="form-group col-md-6">
                 	 <label>Slayd adı</label>
                    	<input class="form-control" type="text" name="slider_ad" required="" value="<?php echo $slider_cek['slider_ad'] ?>">
              	  </div>
                </div>  


               <div class="col-md-12" >
                <div  class="form-group col-md-6">
                   <label>Slayd linki</label>
                      <input class="form-control" type="text" name="slider_url" value="<?php echo $slider_cek['slider_url'] ?>">
                  </div>
              </div>


               <div class="col-md-12" >
                <div  class="form-group col-md-4">
                   <label>Slayd sırası</label>
                      <input class="form-control" type="number" name="slider_sira" value="<?php echo $slider_cek['slider_sira'] ?>">
                  </div>
              </div>

              <input type="hidden" name="slider_id" value="<?php echo $slider_cek['slider_id'] ?>">
              <input type="hidden" name="slider_sekilyolu" value="<?php echo $slider_cek['slider_sekilyolu'] ?>">

            <div style="margin-left:370px;" class="col-md-6">  
            <div class="form-group col-md-4">
                 <a><input style="width:100%" class="btn btn-success" type="submit" name="slayd-deyisdir" value="Yadda saxla"></a>
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


