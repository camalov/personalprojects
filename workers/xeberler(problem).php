<?php 
      include 'header.php'; 
?>

    <!--==============================content================================-->
    <section id="content">
      <div class="wrapper">
        <article class="col-1">
        
      <h3 class="prev-indent-bot">Xəbərlər</h3> 
       <?php 

       $sehife = $_GET['sehife'];
       $sehifede_xeber_sayi=5;
       $xeber_sorgula=mysql_query("select * from xeberler");
       $xeber_sayi=mysql_num_rows($xeber_sorgula);
       $toplam_sehife=ceil($xeber_sayi/$sehifede_xeber_sayi);
       $limit=($sehife-1) * $sehifede_xeber_sayi;

       if($_GET['sehife']<1){
        header("Location:xeberler.php?sehife=1");
        }
        if($sehife>$toplam_sehife){
        header("Location:xeberler.php?sehife=$toplam_sehife");
        }


       $xeberler=mysql_query("select * from xeberler order by xeber_id DESC LIMIT $limit,$sehifede_xeber_sayi ");
              
          
           while($xeber_cek=mysql_fetch_assoc($xeberler)){ ?> 
          
          <div class="indent-left">
            <br>
            <div class="wrapper prev-indent-bot">
              <figure class="img-indent"><img src="nedmin/<?php echo $xeber_cek['xeber_sekilyolu'] ?>" height="190px" width="230px" alt=""></figure>
              <div class="extra-wrap">
              
                <h6 class="prev-indent-bot"><?php echo $xeber_cek['xeber_ad'] ?></h6>
                <?php echo substr($xeber_cek['xeber_mezmunu'], 0 , 250)."...";  ?></div>
            </div>
            

        <!--   <p class="p2">Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatemt enim ad minima veniam, quis nostrum exercitationem.</p>  -->

            <a class="button-2" style="margin-top:10px; float:right" href="blog/<?=$xeber_cek["xeber_id"].'/'.$xeber_cek['xeber_xit'].'/'.seo($xeber_cek['xeber_ad'])?>">Daha ətraflı</a> </div>

        <?php // SEO funksiyasi ile cagrilmamisdan evvel bu link metodu istifade edilirdi.   blog.php?xeber_id=<?php echo $xeber_cek['xeber_id'] &xeber_xit=<?php echo $xeber_cek['xeber_xit'] 
        ?>

            <br>
            <br>
            <hr>
           
            <?php } ?>
                
            <div class="col-md-6" align="left" style="padding-left:600px">
              <?php 
                $a=1;
                
                while($a<=$toplam_sehife){
                  
                  ?>

                  <a href="xeberler.php?sehife=<?php echo $a ?>"><?php echo $a ?></a>

                 <?php   
                 $a++;
                }
                  
                  ?>
              

        </div>  
      
        </article>








        <article class="col-2">
          <h4 style="font-size:25px;" class="p1">Ən çox oxunan xəbərlər</h4>
          <ul class="list-1">
            <?php 
            $xeberler=mysql_query("select * from xeberler order by xeber_xit DESC");
            $i=0;
            $xeber_sayi_cek=mysql_query("select * from xeberler");
            $xeber_sayi=mysql_num_rows($xeber_sayi_cek);

            while($xeber_cek=mysql_fetch_assoc($xeberler)){ if($i==5){  while($xeber_sayi==0){ $xeber_sayi--; ?> <li></li> <?php   }  } else{ ?>

              

            <li><a href="blog/<?=$xeber_cek["xeber_id"].'/'.$xeber_cek['xeber_xit'].'/'.seo($xeber_cek['xeber_ad'])?>"><?php echo $xeber_cek['xeber_ad'] ?></a></li>
            <hr>
            
            <? ++$i; } } ?>
          </ul>
        </article>
      </div>
    </section>


<!-- aside -->
<aside>
  <div class="block"></div>
</aside>

</div>
</div>
<!--==============================footer=================================-->
<?php include 'footer.php' ?>

</body>
</html>
