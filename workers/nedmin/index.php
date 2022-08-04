<?php 

ob_start();
session_start();

include 'header.php'; 

include 'sidebar.php'; 

if(!isset($_SESSION['userinfo']))
{
    header("Location:login.php");
}


?>
<head>
    <script src="//cdn.ckeditor.com/4.5.11/standard/ckeditor.js"></script>
</head>


  <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-head-line">EV-TƏMİR ADMİN PANELİNƏ XOŞ GƏLDİNİZ</h1>
                        <h1 class="page-subhead-line">Əsas səhifə / Haqqınızda bölməsi</h1>

                    </div>
                </div>
                <!-- /. ROW  -->
                <div class="row">
                    <div class="col-md-12">
                        <!--<div class="alert alert-info">
                            This is a free responsive admin under cc3.0 license, so you can use it for personal and commercial use.
                          <br />
                            Enjoy this admin and for more please keep looking <a href="http://www.binarytheme.com/" target="_blank">BinaryTheme.com</a>
                        </div>-->
                    </div>
                </div>
           
            <!-- Sehife basliq -->
            <?php $esas_sehife_sorgula=mysql_query("select * from esas_sehife"); $esas_sehife_cek=mysql_fetch_assoc($esas_sehife_sorgula); ?>
               
               <form action="netting/emeliyyatlar.php" method="POST">
               
               <div class="col-md-12" >
                <div  class="form-group col-md-6">
                   <label>Səhifə Başlıq</label>
                      <input class="form-control" type="text" required="" name="sehife_basliq" value="<?php echo $esas_sehife_cek['sehife_basliq'] ?>">
                  </div>
              </div>
           
           <!-- sehife mezmunu -->
            <div class="col-md-12" >
                <div  class="form-group col-md-6">
                   <label>Məlumat Başlığı</label>
                      <input class="form-control" type="text" name="sehife_mezmunu" value="<?php  echo $esas_sehife_cek['sehife_mezmunu'] ?>">
                  </div>
              </div>

           <!-- sehife blog -->
              <div class="col-md-12" >
                <div  class="form-group col-md-12">
                   <label>Səhifə məzmunu</label>
                      <textarea class="ckeditor" type="text" name="xeber_mezmunu"><?php echo $esas_sehife_cek['sehife_metin'] ?></textarea>
                  </div>
              </div>

            
            <div class="col-md-3" style="margin-left:745px;">
              <input style="width:100%" type="submit" class="btn btn-success" name="esas_sehife_data" value="Əlavə et">
            </div>
          
          </form>

            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->









<?php include 'footer.php'; ?>


