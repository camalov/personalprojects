<?php include 'header.php' ?>
    <!--==============================content================================-->
    <section id="content">
      <div class="wrapper">
        <article class="col-1">
          <div class="indent-left">
            <?php if($_GET['operation']=='ok'){ ?>
          
            <h3 class="p1">Mesajınız uğurla göndərildi.</h3>
            <?php }
            else if($_GET['operation']=='no'){ ?> 
            

            <!-- nedmin/netting/emeliyyatlar.php  -->
            <?php } 
            else{ ?>
            <form id="contact-form" action="http://c-datasoftware.tk/phpmail/index.php" method="POST" >
              <fieldset>
            <h3 class="p1">Bizimlə Əlaqə</h3>
                <label><span class="text-form">Adınız:</span>
                  <input type="text" name="name" required="">
                </label>
                <label><span class="text-form">E-poçt:</span>
                  <input type="email" name="email" required="">
                </label>
                <label><span class="text-form">Mövzu:</span>
                  <input type="text" name="subject" maxlength="50">
                </label>
                <div class="wrapper">
                  <div class="text-form">Mesaj:</div>
                  <div class="extra-wrap">
                    <textarea type="text" name="message" required=""></textarea>
                  </div>
                </div>
                <br>
               <button class="button-2" style="margin-left:525px;" type="submit" name="contact_us">Göndər</button>
              </fieldset>
              </form>
            </form>
            <?php } ?>
          </div>
        </article>
        <article class="col-2">

          <?php $parametr_sorgula=mysql_query("select * from parametrler"); $parametr_cek=mysql_fetch_assoc($parametr_sorgula);?>

          <h3 class="p1">Əlaqələrimiz</h3>
          <h6><?php echo $parametr_cek['parametr_olke']; ?></h6>
          <dl class="img-indent-bot">
            <dt><?php  echo $parametr_cek['parametr_unvan'] ?></dt>
            <dd><span>Telefon:</span><strong><?php echo $parametr_cek['parametr_telefon'] ?></strong></dd>
            <dd><span>Fax:</span><strong><?php echo $parametr_cek['parametr_fax'] ?></strong></dd>
            <dd><span>E-poçt:</span><strong><a target="blank" href="/<?php echo strstr($parametr_cek['parametr_mail'], '@') ?>"><?php echo $parametr_cek['parametr_mail'] ?></a></strong></dd>
          </dl>


       <!--   <h6>Canada</h6>
          <dl class="img-indent-bot">
            <dt>8901 Marmora Road, Glasgow, D04</dt>
            <dd><span>Telephone:</span><strong>+1 959 603 6035</strong></dd>
            <dd><span>Fax:</span><strong>+1 504 889 9898</strong></dd>
            <dd><span>Email:</span><strong><a href="#">mail@thomsander.com</a></strong></dd>
          </dl>
          <h6>Great Britain</h6>
          <dl>
            <dt>8901 Marmora Road, Glasgow, D04</dt>
            <dd><span>Telephone:</span><strong>+1 959 603 6035</strong></dd>
            <dd><span>Fax:</span><strong>+1 504 889 9898</strong></dd>
            <dd><span>Email:</span><strong><a href="#">mail@thomsander.com</a></strong></dd> -->
          </dl>
        </article>
      </div>
      <div class="block"></div>
    </section>
  </div>
</div>
<!--==============================footer=================================-->
<?php include 'footer.php' ?>
<!--coded by cheh-->
</body>
</html>
