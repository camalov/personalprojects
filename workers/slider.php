           <div class="wrapper">
        <div class="slider">
          <ul class="items">
  
        <?php    
      
      $slider=mysql_query("select * from slider order by slider_sira ASC");
      
          while($slidercek=mysql_fetch_assoc($slider)){ ?> 
                            
            <li><img src="nedmin/<?php echo $slidercek['slider_sekilyolu'] ?>" alt="<?php echo $slidercek['slider_ad']; ?>"></li>
          
           <?php } ?>
        
         </ul>
        </div>
        <a class="prev">prev</a> <a class="next">next</a>
        <div class="banner1-bg"></div>
        <div class="banner-1"></div>
      </div>