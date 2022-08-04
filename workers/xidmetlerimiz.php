<?php include 'header.php';

  $xidmetler=mysql_query("select * from xidmetler ");

?>
    <!--==============================content================================-->
  <?php 

  $sehife = $_GET['sehife'];
  $sehifede = 10;
  $xidmet_sayi = mysql_num_rows($xidmetler);
  $toplam_sehife = ceil($xidmet_sayi/$sehifede);
  $sehife = (isset($_GET['sehife'])) ? (int) $_GET['sehife'] : 1;  
  $limit = ($sehife-1)*$sehifede;  

  if($sehife<1 or (!isset($sehife)) ){

    header("Location:xidmetlerimiz.php?sehife=1");
  }
  else if($sehife>$toplam_sehife){

    header("Location:xidmetlerimiz.php?sehife=$toplam_sehife");
  }

  ?>


    <section id="content">
      <div class="indent-left">
        <h3 class="p1">Xidmətlərimiz</h3>
        <div class="wrapper">
          <div class="col-1">
            <ul class="price-list">
              <?php 

              $xidmetler=mysql_query("select * from xidmetler LIMIT $limit,$sehifede");

              while($xidmet_cek=mysql_fetch_assoc($xidmetler)){ ?>
            
              <li><span>(AZN) <?php echo $xidmet_cek['xidmet_haqqi'] ?></span><?php echo $xidmet_cek['xidmet_ad'] ?><strong>&nbsp;</strong></li>
              
              <?php } ?>
     <div align="right">

      <?php  

       $i=1;                   
        
        while($i<=$toplam_sehife){ ?>

            <a href="xidmetlerimiz.php?sehife=<?php echo $i ?>"><?php echo $i ?></a>
            
            
            <?php $i++; } ?>
            </div> 
          </div>
        </div>
      </div>
    </section>
    <!--==============================footer================================-->


  <div class="block"></div>
</div>
</div>

<?php include 'footer.php' ?>
</body>
</html>
