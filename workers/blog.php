<?php include 'header.php' ?>
<?php  
  
  include 'nedmin/netting/baglan.php';

  $xeber_id=$_GET['xeber_id'];

  $xeber=mysql_query("select * from xeberler where xeber_id=$xeber_id ");

  $xeber_cek=mysql_fetch_assoc($xeber);
  
  $i=$xeber_cek['xeber_xit'];

  $i++;

  if($_GET['xeber_id']){


    $xeber_xit=mysql_query("update xeberler set xeber_xit='".$i."' where xeber_id='".$_GET['xeber_id']."' ");

  }
?>


    <!--==============================aside================================-->



    <aside>  
      <div class="wrapper" style="margin-top:-30px; margin-bottom:-50px;">
        <div class="column-3" style="margin-top:-0px;">
          <div class="box">
            <div class="aligncenter">
              <h4><?php echo $xeber_cek['xeber_ad'] ?></h4>
            </div>
            <div class="box-bg maxheight">
              <div class="padding">
               <!-- <h6 class="color-1">Sed ut perspiciatis unde omnis</h6> -->
               <figure class="img-indent"><img src="nedmin/<?php echo $xeber_cek['xeber_sekilyolu'] ?>" height="190px" width="230px" alt=""></figure>
                <p><?php echo $xeber_cek['xeber_mezmunu']; ?></p>
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