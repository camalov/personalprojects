<?php include 'input-security/security.php'; ?>

<?php include 'header.php'; ?>

<?php include 'sidebar.php'; ?>

<?php include 'netting/baglan.php' ?>

<?php 

	$parametr=mysql_query("select * from parametrler");

	$parametr_cek=mysql_fetch_assoc($parametr);

?>

  <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-head-line">Ümumi Parametrlər</h1>
                          
                          <?php 


                            if($_GET['saxlandi']==ok)
                            { ?>
                              <h1 style="color:green;" class="page-subhead-line">Məlumatlarda edilmiş dəyişikliklər yadda saxlandı.</h1>
                            
                              <?php }     

                                 

                                 else if($_GET['saxlandi']==no)

                                    { ?>

                                    <h1 style="color:red;" class="page-subhead-line">Məlumatlar yenilənmədi! Ola bilsinki məlumatlarda heç bir dəyişiklik edilməyib....</h1>
                                      <?php } 

                                      

                                        else { ?>


                                          <h1 style="" class="page-subhead-line">Saytınızın ümumi parametrlərini bu bölmədə idarə edə bilərsiniz.</h1>


                                        <?php } ?>


                                       



                    </div>
                </div>
                <!-- /. ROW  -->
               



             
              <form  action="netting/emeliyyatlar.php" method="post">
			       <div class="col-md-12"> 	       		
             	 <div  class="form-group col-md-6">
                 	 <label>Başlıq</label>
                    	<input class="form-control" type="text" name="parametr_title" value="<?php echo $parametr_cek['parametr_title'] ?>">
              	  </div>
              </div>

            

              <div class="col-md-12"> 
               <div  class="form-group col-md-6">
                 <label>Sayt haqqında</label>
                 <input class="form-control" type="text" name="parametr_description" value="<?php echo $parametr_cek['parametr_description']?>">
               </div>
               </div>  		  



              
              <div class="col-md-12">       		
               <div  class="form-group col-md-6">
                 <label>Açar sözlər</label>
                   <input class="form-control" type="text" name="parametr_keywords" value="<?php echo $parametr_cek['parametr_keywords'] ?>">
                 </div>
               </div>  


                              


                  		
               <div  class="form-group col-md-3" style="margin-left:15px;">
                 <label>Telefon</label>
                   <input class="form-control" type="text" name="parametr_telefon" value="<?php echo $parametr_cek['parametr_telefon'] ?>">
                 </div>
            




                     		
               <div  class="form-group col-md-4">
                 <label>Facebook ünvanınız</label>
                   <input class="form-control" type="text" name="parametr_facebook" value="<?php echo $parametr_cek['parametr_facebook'] ?>">
                 </div>
                



               <div  class="form-group col-md-4">
                 <label>Twitter ünvanınız</label>
                   <input class="form-control" type="text" name="parametr_twitter" value="<?php echo $parametr_cek['parametr_twitter'] ?>">
                 </div>
                

                    		

              <div class="col-md-12">       		
               <div  class="form-group col-md-12">
                 <label>Footer</label>
                   <input class="form-control" type="text" name="parametr_footer" value="<?php echo $parametr_cek['parametr_footer'] ?>">
                 </div>
               </div> 

              
              <div class="col-md-12">           
               <div  class="form-group col-md-12">
                 <label>Ölkə</label>
                   <input class="form-control" type="text" name="parametr_olke" value="<?php echo $parametr_cek['parametr_olke'] ?>">
                 </div>
               </div>   


              <div class="col-md-12">       		
               <div  class="form-group col-md-12">
                 <label>Ünvan</label>
                   <input class="form-control" type="text" name="parametr_unvan" value="<?php echo $parametr_cek['parametr_unvan'] ?>">
                 </div>
               </div>   




                    		
               <div  class="form-group col-md-6" style="margin-left:15px;">
                 <label>E-poçt</label>
                   <input class="form-control" type="text" name="parametr_mail" value="<?php echo $parametr_cek['parametr_mail'] ?>">
                 </div>
               


               <div  class="form-group col-md-5">
                 <label>Faks</label>
                   <input class="form-control" type="text" name="parametr_fax" value="<?php echo $parametr_cek['parametr_fax'] ?>">
                </div>

                	
                <div class="form-group col-md-6">
                   <input style="width:100%" class="btn btn-success" type="submit" name="parametrsaxla" value="Yadda Saxla">
                </div>

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


