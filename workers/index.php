<?php include 'header.php' ?>
<?php include 'slider.php'; ?>
<?php  
  
  include 'nedmin/netting/baglan.php';

  $sehife=mysql_query("select * from sehifeler");

  $sehife_cek=mysql_fetch_assoc($sehife);


?>

    <!--==============================aside================================-->


    <aside>  
      <div class="wrapper">
        <?php 

        $sehife=mysql_query("select * from sehifeler where basic_page='1' order by sehife_sira ASC");

        $sirala=mysql_query("select * from sehifeler order by sehife_sira ASC");

        $pagenum=mysql_num_rows($sehife);

        $n=$pagenum=mysql_num_rows($sehife);

        
        
      while($sehife_cek=mysql_fetch_assoc($sehife)){ ?>  

        <div class="column-2" style="margin-left:14px; margin-top:10px;">
          <div class="box">
            <div class="aligncenter">
              <h4><?php echo $sehife_cek['sehife_ad'] ?></h4>
            </div>
            <div class="box-bg maxheight">
              <div class="padding">
               <!-- <h6 class="color-1">Sed ut perspiciatis unde omnis</h6> -->
                <p><?php echo substr($sehife_cek['sehife_mezmunu'], 0, 200)."..." ?></p>
              </div>
              <div class="aligncenter"> <a class="button"  style="margin-top:10px; margin-bottom:-10px;" href="sehife-mezmunu.php?sehife_id=<?php echo $sehife_cek['sehife_id'] ?>">Ətraflı oxu</a> </div>
            </div>
            </div>
          </div>
            <?php } ?>
        </div>      
    </aside>



    

    <!--==============================content================================-->
  <?php  
    
    $esas_sehife_sorgula=mysql_query("select * from esas_sehife");
    $esas_sehife_cek=mysql_fetch_assoc($esas_sehife_sorgula);

    ?>

    <!--This website template is optimized for 1280X1024 screen resolution. It is also XHTML &amp; CSS valid. Handyman Template goes with two packages – with PSD source files and without them. PSD
              source files are available for free for the registered members of Templates.com. The basic pack
              age (without PSD source) is available for anyone without registration.<a class="color-2" href="index.html">Home Page</a>, <a class="color-2" href="services.html">Services</a>, <a class="color-2" href="faq.html">FAQ</a>, <a class="color-2" href="prices.html">Prices</a>, <a class="color-2" href="staff.html">Our Staff</a>, <a class="color-2" href="contacts.html">Contacts</a> (note that contact us form – doesn’t work).
      -->
    

      <div class="block"></div>
    
  </div>
</div>

<?php include 'footer.php' ?>
