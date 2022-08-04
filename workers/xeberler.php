<?php
include 'header.php'; 
?>

<!--==============================content================================-->
<section id="content">
  <div class="wrapper">
    <article class="col-1">


      <!-- While Başlangıç -->


      <!-- Sayfalama -->

      <?php

       $sayfada = 7; // sayfada gösterilecek içerik miktarını belirtiyoruz.

       $sorgu = mysql_query("select * from xeberler");
       $toplam_icerik = mysql_num_rows($sorgu);

       $toplam_sayfa = ceil($toplam_icerik / $sayfada);

         // eğer sayfa girilmemişse 1 varsayalım.
       $sayfa = isset($_GET['sayfa']) ? (int) $_GET['sayfa'] : 1;

        // eğer 1'den küçük bir sayfa sayısı girildiyse 1 yapalım.
       if($sayfa < 1) $sayfa = 1; 

        // toplam sayfa sayımızdan fazla yazılırsa en son sayfayı varsayalım.
       if($sayfa > $toplam_sayfa) $sayfa = $toplam_sayfa; 

       $limit = ($sayfa - 1) * $sayfada;

        //sayfalama bitiş

       

       

       $habersor=mysql_query("select * from xeberler order by xeber_id DESC LIMIT $limit,$sayfada");

       while ($habercek=mysql_fetch_assoc($habersor)) {?>


       <div class="indent-left">
        <div class="wrapper prev-indent-bot">
          <figure class="img-indent"><img width="200" height="200" src="nedmin/<?php echo $habercek['xeber_sekilyolu']; ?>" alt=""></figure>
          <div class="extra-wrap">


            <h6 class="prev-indent-bot"><?php echo $habercek['xeber_ad']; ?> </h6>
            
            <?php echo substr($habercek['xeber_mezmunu'],0,300); echo " ..."; ?> 


          </div>
        </div>

        <div style="float:right; padding-bottom: 15px;" class="indent-right">

          <a class="button-2" href="blog/<?=$habercek["xeber_id"].'/'.$habercek['xeber_xit'].'/'.seo($habercek['xeber_ad'])?>">Ətraflı oxu</a> 

        </div>
      </div>
      <br><br>
      <hr>

      <?php } ?>
      <!-- While Bitiş -->


      <!-- Sayfalama -->

      <div align="right" class="col-md-12">
        <?php


        $s=0;

        while ($s < $toplam_sayfa) {

          $s++; ?>

          <a href="xeberler.php?sayfa=<?php echo $s; ?>"><?php echo $s; ?></a>


          <?php   }             

          ?>
        </div>

        <!-- Sayfalama -->


      </article>
      <article class="col-2">
        <h4 style="font-size:20px;" class="p1">Ən çox oxunan xəbərlər</h4>
        <ul class="list-1">

        <?php
        
        $xeber_sorgula=mysql_query("select * from xeberler order by xeber_xit DESC");
        $i=1;
        
        while($i<=5){
        
        $xeber_cek=mysql_fetch_assoc($xeber_sorgula);
        
        ?>
        
        <li><a href="blog/<?=$xeber_cek["xeber_id"].'/'.$xeber_cek['xeber_xit'].'/'.seo($xeber_cek['xeber_ad'])?>"><?php echo $xeber_cek['xeber_ad']?></a><li>
            
            
        
        <?php $i++; } ?>
              

            

        
 
       </ul>
     </article>
   </div>
 </section>
 <!--==============================aside================================-->
 <aside>

  <div class="block"></div>
</aside>
</div>
</div>


<?php 
include 'footer.php'; 
?>