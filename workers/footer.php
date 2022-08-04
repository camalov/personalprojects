<!--==============================footer=================================-->
<footer>
  <div class="main">
    <div class="footer-bg">
     
    <?php echo $parametr_cek['parametr_footer']; ?>

     <!-- <p class="prev-indent-bot">Copyright &copy; <a href="#">C-DATA YAZILIM</a> Bütün hüquqlar qorunur | Design by C-DATA YAZILIM<a target="_blank" href=""></a></p> -->
     

      <ul class="list-services">
      
        <li><a class="tooltips" target="blank" href="<?php echo $parametr_cek['parametr_facebook']; ?>"></a></li>
        <li class="item-1"><a target="blank" class="tooltips" href="<?php echo $parametr_cek['parametr_twitter']; ?>"></a></li>
      <!--  <li class="item-2"><a class="tooltips" href="#"></a></li> -->
      
      </ul>
    </div>
  </div>
</footer>
<script>Cufon.now();</script>
<script>
$(window).load(function () {
    $('.slider')._TMS({
        duration: 800,
        easing: 'easeOutQuart',
        preset: 'simpleFade',
        slideshow: 7000,
        banners: false,
        pauseOnHover: true,
        waitBannerAnimation: false,
        prevBu: '.prev',
        nextBu: '.next'
    });
});
</script>
</body>
</html>
