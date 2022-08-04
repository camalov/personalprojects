<?php include 'header.php' ?>
<?php  
  
  include 'nedmin/netting/baglan.php';

  $sehife_id=$_GET['sehife_id'];

  $sehife=mysql_query("select * from sehifeler where sehife_id='$sehife_id' ");

  $sehife_cek=mysql_fetch_assoc($sehife);
?>


    <!--==============================aside================================-->



    <aside>  
      <div class="wrapper" style="margin-top:-30px; margin-bottom:-50px;">
        <div class="column-3" style="margin-top:-0px;">
          <div class="box">
            <div class="aligncenter">
              <h4><?php echo $sehife_cek['sehife_ad'] ?></h4>
            </div>
            <div class="box-bg maxheight">
              <div class="padding">
               <!-- <h6 class="color-1">Sed ut perspiciatis unde omnis</h6> -->
                <p><?php echo $sehife_cek['sehife_mezmunu']; ?></p>
              </div>
            </div>
            </div>
          </div>
        </div>      
    </aside>



    

    <!--==============================content================================-->
 <section id="content">
      <div class="wrapper">
        <article class="col-1">
        </article>
        <article class="col-2">
            </div>
          </div>
        </article>
      </div>
      <div class="block"></div>
    </section>
  </div>
</div>

<?php include 'footer.php' ?>