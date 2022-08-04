<?php include 'header.php' ;

    
    $esas_sehife_sorgula=mysql_query("select * from esas_sehife");
    $esas_sehife_cek=mysql_fetch_assoc($esas_sehife_sorgula);

    ?>
    <!--==============================content================================-->
         <div class="wrapper">
        <article class="col-4">
          <div class="indent-left">
            <h3><?php echo $esas_sehife_cek['sehife_basliq'] ?></h3>
            <h4 class="prev-indent-bot"><?php echo $esas_sehife_cek['sehife_mezmunu'] ?></h4>
            <p class="prev-indent-bot"><?php echo $esas_sehife_cek['sehife_metin'] ?></p>
             </div>
        </article>

      </div>
    </section>
    <!--==============================aside================================-->
    <aside>
      <div class="wrapper">

      <div class="block"></div>
    </aside>
  </div>
</div>
<!--==============================footer=================================-->


<?php include 'footer.php' ?>
