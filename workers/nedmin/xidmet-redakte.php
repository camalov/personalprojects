<?php include 'input-security/security.php'; ?>

<?php include 'header.php'; ?>

<?php include 'sidebar.php'; ?>

<?php include 'netting/baglan.php' ?>

<?php 
	
	
	$xidmet_id=$_GET['xidmet_id'];
	$xidmetler=mysql_query("select * from xidmetler where xidmet_id='".$xidmet_id."' ");
	$xidmet_cek=mysql_fetch_assoc($xidmetler);

?>

<head>

  <script src="//cdn.ckeditor.com/4.5.11/standard/ckeditor.js"></script>

</head>

  <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-head-line">Yeni xidmət əlavə edirsiniz</h1>
                          
                          <?php 


                            if($_GET['saxlandi']==ok)
                            { ?>
                              <h1 style="color:green;" class="page-subhead-line">Yeni  xidmət əlavə edildi</h1>
                            
                              <?php }     

                                 

                                 else if($_GET['saxlandi']==no)

                                    { ?>

                                    <h1 style="color:red;" class="page-subhead-line">Yeni xidmət əlavə edilmədi !</h1>
                                      <?php } 

                                      

                                        else { ?>


                                          <h1 style="" class="page-subhead-line">Bu bölmədə saytınıza yeni xidmətlər əlavə edə bilərsiziniz</h1>


                                        <?php } ?>


                                       



                    </div>
                </div>
                <!-- /. ROW  -->
               



             
              <form  action="netting/emeliyyatlar.php" method="post" >
			       
             <div class="col-md-12"> 	       		
             	 <div  class="form-group col-md-6">
                 	 <label>Xidmət adı</label>
                    	<input class="form-control" type="text" name="xidmet_ad" required="" value="<?php echo $xidmet_cek['xidmet_ad'] ?>">
              	  </div>
                </div>


             <div class="col-md-12"> 	       		
             	 <div  class="form-group col-md-6">
                 	 <label>Xidmət haqqı</label>
                    	<input class="form-control" type="text" name="xidmet_haqqi" value="<?php echo $xidmet_cek['xidmet_haqqi'] ?>" required="" >
              	  </div>
                </div>
          		
          		<input type="hidden" name="xidmet_id" value="<?php echo $xidmet_id; ?>">
          		
              <input type="hidden" name="xidmet_zaman" value="<?php date_default_timezone_set("Asia/Baku"); $time=date("Y:m:d H:i:s"); echo $time; ?>">

          <div style="margin-left:370px;" class="col-md-6">  
            <div class="form-group col-md-3">
                   <input style="width:100%" class="btn btn-success" type="submit" name="xidmet-redakte" value="Əlavə et">
            </div>
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


